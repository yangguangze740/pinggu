package com.zhulin.common.menu.scan;

import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.sys.pojo.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuURLLoad {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuURLLoad.class);

    private static final String RESOURCE_PATTERN = "/**/*.class";
    private ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
    private List<String> scanPackages = new ArrayList<>();
    private List<TypeFilter> annotationFilters = new ArrayList<>();

    public static Set<Class<?>> scanClasses = new HashSet<>();

    public MenuURLLoad(List<String> packages2ScanPaths, Class<? extends Annotation>... annotations) {
        if (packages2ScanPaths != null) {
            for (String packagePath : packages2ScanPaths) {
                this.scanPackages.add(packagePath);
            }
        }

        if (annotations != null) {
            for (Class<? extends Annotation> annotation : annotations) {
                annotationFilters.add(new AnnotationTypeFilter(annotation, false));
            }
        }
    }

    public List<Menu> scanAnnotationMenus() throws IOException, ClassNotFoundException {
        this.scanClasses.clear();
        List<Menu> menus = new ArrayList<>();

        if (!this.scanPackages.isEmpty()) {
            for (String pkg : scanPackages) {
                String pathPattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                        + ClassUtils.convertClassNameToResourcePath(pkg) + RESOURCE_PATTERN;

                Resource[] resources = this.patternResolver.getResources(pathPattern);
                MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(this.patternResolver);

                for (Resource resource : resources) {
                    if (resource.isReadable()) {
                        MetadataReader reader = readerFactory.getMetadataReader(resource);
                        String className = reader.getClassMetadata().getClassName();

                        if (matchAnnotationFilter(reader, readerFactory)) {
                            this.scanClasses.add(Class.forName(className));
                        }
                    }
                }
            }
        }

        if (LOGGER.isInfoEnabled()) {
            for (Class<?> clazz : this.scanClasses) {
                LOGGER.info("===================================================================================================================================================================");
                LOGGER.info("[MENU LOAD -> com.zhulin.Project.common.menu.scan.scanAnnotationMenus -> scanAnnotationMenus] found class {}.", clazz.getName());
            }
        }

        for (Class<?> clazz : this.scanClasses) {
            ClassMenuURL menuURL = clazz.getAnnotation(ClassMenuURL.class);

            if (menuURL != null) {
                Menu menu = new Menu();

                menu.setMenuName(menuURL.name());
                menu.setMenuURL(menuURL.value());
                menu.setMenuGroupName(menuURL.groupName());
                menu.setMenuGroupValue(menuURL.group());

                menus.add(menu);
            }
        }

        if (LOGGER.isInfoEnabled()) {
            for (Menu menu : menus) {
                LOGGER.info("===================================================================================================================================================================");
                LOGGER.info("[MENU LOAD -> com.zhulin.Project.common.menu.scan.MenuURLLoad -> scanAnnotationMenus] menu menuGroup : {} menuName : {} URL {}.",
                        menu.getMenuGroupName(), menu.getMenuName(), menu.getMenuURL());
            }
        }

        return menus;
    }

    private boolean matchAnnotationFilter(MetadataReader reader, MetadataReaderFactory readerFactory) throws IOException {
        if (!this.annotationFilters.isEmpty()) {
            for (TypeFilter filter : annotationFilters) {
                if (filter.match(reader, readerFactory)) {
                    return true;
                }
            }
        }

        return false;
    }
}

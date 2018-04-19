package com.zhulin.common.permission.preload;

import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.sys.pojo.ClassRole;
import com.zhulin.sys.pojo.MethodPermission;
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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 通过扫描指定包下面的类的指定的permission相关的注解获取系统中所有的权限
 */
public class SystemPermissionConfigPreload {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemPermissionConfigPreload.class);

    private static final String RESOURCE_PATTERN = "/**/*.class";
    private ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
    private List<String> scanPackages = new ArrayList<>();
    private List<TypeFilter> annotationFilters = new ArrayList<>();

    public static Set<Class<?>> scanClasses = new HashSet<>();

    public SystemPermissionConfigPreload(List<String> packages2ScanPaths, Class<? extends Annotation>... annotations) {
        if (packages2ScanPaths != null) {
            for (String package2ScanPath : packages2ScanPaths) {
                this.scanPackages.add(package2ScanPath);
            }
        }

        if (annotations != null) {
            for (Class<? extends Annotation> annotation : annotations) {
                annotationFilters.add(new AnnotationTypeFilter(annotation, false));
            }
        }
    }

    public List<ClassRole> scanAnnotationClasses() throws IOException, ClassNotFoundException {
        this.scanClasses.clear();
        List<ClassRole> classRoles = new ArrayList<>();
        List<MethodPermission> methodPermissions = new ArrayList<>();

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
                LOGGER.info("[PRELOAD -> com.zl.Project.common.permission.preload.SystemPermissionConfigPreload -> scanAnnotationClasses] found class {}.", clazz.getName());
            }
        }

        for (Class<?> clazz : this.scanClasses) {
            ClassRolePermission classRole = clazz.getAnnotation(ClassRolePermission.class);

            if (classRole != null) {
                ClassRole classRoleVO = new ClassRole();

                classRoleVO.setName(classRole.name());
                classRoleVO.setGroup(classRole.group());
                classRoleVO.setValue(classRole.value());
                classRoleVO.setMenuValue(classRole.menuValue());

                Method[] methods = clazz.getMethods();
                List<MethodPermission> tmpMethodPermissionVOs = new ArrayList<>();

                for (Method method : methods) {
                    MethodRolePermission methodPermission = method.getAnnotation(MethodRolePermission.class);

                    if (methodPermission != null) {
                        MethodPermission methodPermissionVO = new MethodPermission();

                        methodPermissionVO.setValue(methodPermission.value());
                        methodPermissionVO.setGroup(methodPermission.group());
                        methodPermissionVO.setName(methodPermission.name());
                        methodPermissionVO.setGroupName(methodPermission.groupName());

                        methodPermissions.add(methodPermissionVO);
                        tmpMethodPermissionVOs.add(methodPermissionVO);
                    }
                }

                classRoleVO.setMethodPermissions(tmpMethodPermissionVOs);
                classRoles.add(classRoleVO);
            }
        }

        if (LOGGER.isInfoEnabled()) {
            for (ClassRole classRoleVO : classRoles) {
                LOGGER.info("===================================================================================================================================================================");
                LOGGER.info("[PRELOAD -> com.zl.Project.common.permission.preload.SystemPermissionConfigPreload -> scanAnnotationClasses] classRole group : {} name : {} role {}.",
                        classRoleVO.getGroup(), classRoleVO.getName(), classRoleVO.getValue());
            }
        }
        if (LOGGER.isInfoEnabled()) {
            for (MethodPermission methodPermissionVO : methodPermissions) {
                LOGGER.info("===================================================================================================================================================================");
                LOGGER.info("[PRELOAD -> com.zl.Project.common.permission.preload.SystemPermissionConfigPreload -> scanAnnotationClasses] methodPermission group : {} name : {} permission {}.",
                        methodPermissionVO.getGroup(), methodPermissionVO.getName(), methodPermissionVO.getValue());
            }
            LOGGER.info("===================================================================================================================================================================");
        }

        return classRoles;
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

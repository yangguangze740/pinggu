package com.zhulin.sys.controller.config.ui;

import com.google.common.base.Strings;
import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.common.def.Constants;
import com.zhulin.common.file.FileSaveResult;
import com.zhulin.common.file.FileStoreUtil;
import com.zhulin.pojo.SystemUIConfig;
import com.zhulin.sys.service.config.ui.SystemUIConfigServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;

@Controller
@RequestMapping("/admin/ui")
@ClassMenuURL(value = "/admin/ui", group = "system", name = "系统UI配置", groupName = "系统配置")
public class SystemUIConfigController {

    @Autowired
    private SystemUIConfigServiceI uiConfigService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        SystemUIConfig uiConfig = uiConfigService.readNowUIConfig(Constants.UI_CONFIG_ID);

        request.getServletContext().setAttribute(Constants.UI_CONFIG_KEY, uiConfig);

        model.addAttribute("uiConfig", uiConfig);

        return "sys/config/ui/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String updateNowUIConfig(Model model,
                                    HttpServletRequest request,
                                    SystemUIConfig uiConfig,
                                    @RequestParam(value = "loginLogoFile", required = false) MultipartFile loginLogoFile,
                                    @RequestParam(value = "titleIcoFile", required = false) MultipartFile titleIcoFile) throws FileNotFoundException {
        // 1. 查询系统没有更改前的ui配置
        SystemUIConfig oldUiConfig = uiConfigService.readNowUIConfig(Constants.UI_CONFIG_ID);

        String path = ResourceUtils.getURL("classpath:").getPath();

        // 保存登录页面的logo图

        if (loginLogoFile == null || Strings.isNullOrEmpty(loginLogoFile.getOriginalFilename())) {
            uiConfig.setLoginLogo(oldUiConfig.getLoginLogo());
        } else {
            String loginLogoPath = path + "static" + Constants.SYSTEM_UI_CONFIG_RESOURCES_DIR;
            FileSaveResult result = FileStoreUtil.saveSpringWebMultipartFile(loginLogoPath, loginLogoFile);
            String loginLogoFileName = result.getDistFileName();

            if (Strings.isNullOrEmpty(loginLogoFileName)) {
                loginLogoFileName = Constants.UI_CONFIG_DEFAULT_LOGIN_LOGO_FILE_NAME;
            }

            uiConfig.setLoginLogo(Constants.SYSTEM_UI_CONFIG_RESOURCES_DIR + loginLogoFileName);
        }

        // 保存页签上的ico文件
        if (titleIcoFile == null || Strings.isNullOrEmpty(titleIcoFile.getOriginalFilename())) {
            uiConfig.setTitleIco(oldUiConfig.getTitleIco());
        } else {
            String titleIcoPath = path + "static" + Constants.SYSTEM_UI_CONFIG_RESOURCES_DIR;
            FileSaveResult result = FileStoreUtil.saveSpringWebMultipartFile(titleIcoPath, titleIcoFile);
            String titleIcoFileName = result.getDistFileName();

            if (Strings.isNullOrEmpty(titleIcoFileName)) {
                titleIcoFileName = Constants.UI_CONFIG_DEFAULT_TITLE_ICO_FILE_NAME;
            }

            uiConfig.setTitleIco(Constants.SYSTEM_UI_CONFIG_RESOURCES_DIR + titleIcoFileName);
        }

        if (Strings.isNullOrEmpty(uiConfig.getSystemName())) {
            uiConfig.setSystemName(oldUiConfig.getSystemName());
        }

        if (Strings.isNullOrEmpty(uiConfig.getNavTitle())) {
            uiConfig.setNavTitle(oldUiConfig.getNavTitle());
        }

        if (Strings.isNullOrEmpty(uiConfig.getTitleValue())) {
            uiConfig.setTitleValue(oldUiConfig.getTitleValue());
        }

        boolean updateSuccess = uiConfigService.updateUIConfig(uiConfig);

        return "redirect:/admin/ui";
    }
}

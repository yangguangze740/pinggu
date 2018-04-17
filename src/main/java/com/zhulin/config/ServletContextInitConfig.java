package com.zhulin.config;

import com.zhulin.common.def.Constants;
import com.zhulin.pojo.SystemUIConfig;
import com.zhulin.sys.service.config.ui.SystemUIConfigServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class ServletContextInitConfig {

    @Autowired
    private SystemUIConfigServiceI uiConfigService;

    @Bean
    public ServletContextInitializer initializer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {

                SystemUIConfig uiConfig = uiConfigService.readNowUIConfig(Constants.UI_CONFIG_ID);

                servletContext.setAttribute(Constants.UI_CONFIG_KEY, uiConfig);
            }
        };
    }
}

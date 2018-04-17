package com.zhulin.config;

import com.zhulin.common.xss.XSSFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        registrationBean.setFilter(new XSSFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("xssFilter");
        registrationBean.setOrder(Integer.MAX_VALUE);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean shiroFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new DelegatingFilterProxy("shiroFilter"));
        registrationBean.addInitParameter("targetFilterLifecycle", "true");
        registrationBean.setEnabled(true);
        registrationBean.setOrder(Integer.MAX_VALUE - 1);
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}

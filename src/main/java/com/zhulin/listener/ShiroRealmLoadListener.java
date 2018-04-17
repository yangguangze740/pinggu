package com.zhulin.listener;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ShiroRealmLoadListener {
    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();

        DefaultWebSecurityManager manager = (DefaultWebSecurityManager) context.getBean("securityManager");
        AuthorizingRealm realm = (AuthorizingRealm) context.getBean("realm");

        manager.setRealm(realm);
    }
}

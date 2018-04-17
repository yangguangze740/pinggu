package com.zhulin.common.shiro;

import com.google.common.base.Optional;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static void setSessionAttr(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttr(Object key) {
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return Optional.fromNullable(SecurityUtils.getSubject().getPrincipal()).isPresent();
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    public static String getKaptcha(String key) {
        Object kaptcha = getSessionAttr(key);

        if (!Optional.fromNullable(kaptcha).isPresent()) {
            return null;
        }

        getSession().removeAttribute(key);

        return kaptcha.toString();
    }

    public static String getSalt() {
        return RandomStringUtils.randomAlphanumeric(20);
    }
}

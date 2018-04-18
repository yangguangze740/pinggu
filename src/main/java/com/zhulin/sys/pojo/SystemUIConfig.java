package com.zhulin.sys.pojo;

public class SystemUIConfig {
    private String uiConfigId;
    private String loginLogo; // 登录页面的Logo
    private String systemName; // 系统页面导航栏的系统名
    private String titleValue; // 浏览器页签上的名
    private String navTitle; // 系统登登录后折叠导航栏后的缩写名
    private String titleIco; // 浏览器页签上的ico

    public String getTitleIco() {
        return titleIco;
    }

    public void setTitleIco(String titleIco) {
        this.titleIco = titleIco;
    }

    public String getUiConfigId() {
        return uiConfigId;
    }

    public void setUiConfigId(String uiConfigId) {
        this.uiConfigId = uiConfigId;
    }

    public String getLoginLogo() {
        return loginLogo;
    }

    public void setLoginLogo(String loginLogo) {
        this.loginLogo = loginLogo;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getTitleValue() {
        return titleValue;
    }

    public void setTitleValue(String titleValue) {
        this.titleValue = titleValue;
    }

    public String getNavTitle() {
        return navTitle;
    }

    public void setNavTitle(String navTitle) {
        this.navTitle = navTitle;
    }
}

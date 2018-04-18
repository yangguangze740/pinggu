package com.zhulin.sys.pojo;

import java.sql.Timestamp;
import java.util.List;

public class Menu {
    private String menuId;
    private String parentId = "0";
    private String menuName;
    private String menuURL = "";
    private String icon = "";
    private int menuType = 1;
    private int orderNum;
    private String menuGroupName = "";
    private String menuGroupValue = "";
    private Timestamp createTime;
    private int version;
    private int isParentMenu = 0;
    private List<Menu> childMenus;
    private int editFlag;
    private String oldIcon = "";
    private List<String> childMenuIds;
    private List<String> oldChildMenuIds;

    public List<String> getOldChildMenuIds() {
        return oldChildMenuIds;
    }

    public void setOldChildMenuIds(List<String> oldChildMenuIds) {
        this.oldChildMenuIds = oldChildMenuIds;
    }

    public String getOldIcon() {
        return oldIcon;
    }

    public void setOldIcon(String oldIcon) {
        this.oldIcon = oldIcon;
    }

    public List<String> getChildMenuIds() {
        return childMenuIds;
    }

    public void setChildMenuIds(List<String> childMenuIds) {
        this.childMenuIds = childMenuIds;
    }

    public int getEditFlag() {
        return editFlag;
    }

    public void setEditFlag(int editFlag) {
        this.editFlag = editFlag;
    }

    public List<Menu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Menu> childMenus) {
        this.childMenus = childMenus;
    }

    public int getIsParentMenu() {
        return isParentMenu;
    }

    public void setIsParentMenu(int isParentMenu) {
        this.isParentMenu = isParentMenu;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getMenuGroupName() {
        return menuGroupName;
    }

    public void setMenuGroupName(String menuGroupName) {
        this.menuGroupName = menuGroupName;
    }

    public String getMenuGroupValue() {
        return menuGroupValue;
    }

    public void setMenuGroupValue(String menuGroupValue) {
        this.menuGroupValue = menuGroupValue;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuURL() {
        return menuURL;
    }

    public void setMenuURL(String menuURL) {
        this.menuURL = menuURL;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getMenuType() {
        return menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public int hashCode() {
        return this.getMenuId().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        Menu menu = (Menu) object;

        return this.getMenuId().equals(menu.getMenuId());
    }
}

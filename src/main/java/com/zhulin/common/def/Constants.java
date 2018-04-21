package com.zhulin.common.def;

public class Constants {
    public static final String TOKEN_KEY = "token";

    /* 请求重定下传参是消息参数的KEY */
    public static final String REDIRECT_MESSAGE_KEY = "message";
    /* 请求重定下传参是消息参数的状态码KEY */
    public static final String REDIRECT_MESSAGE_CODE = "msgCode";

    /* 系统ui配置的数据库记录的主键 */
    public static final String UI_CONFIG_ID = "2e7dfb5c-9117-4263-a799-ee3b4c1fba68";

    /* 系统全局ui配置的key */
    public static final String UI_CONFIG_KEY = "ui";

    /* 登录页面默认的Logo图片 */
    public static final String UI_CONFIG_DEFAULT_LOGIN_LOGO_FILE_NAME = "static/system/logo.png";

    /* 系统访问浏览器页签上显示的默认的ico文件 */
    public static final String UI_CONFIG_DEFAULT_TITLE_ICO_FILE_NAME = "static/system/favicon.ico";

    /* 登录用户的session标识 */
    public static final String LOGIN_USER = "loginUser";

    /* 配置系统UI资源,如ico等存放的目录 */
    public static final String SYSTEM_UI_CONFIG_RESOURCES_DIR = "/system/";

    /* 系统数据库中菜单记录的标识菜单为父菜单的标识 */
    public static final int TRUE_PARENT_MENU_FLAG_VALUE = 1;

    /* 菜单表中parentId的默认值 */
    public static final String IS_NOT_PARENT_MENU_DEFAULT_PARENT_ID = "0";

    /* 系统数据库中菜单记录的可编辑标识值 1为可编辑 */
    public static final int TRUE_MENU_EDIT_FLAG_VALUE = 1;

    /* 子菜单在table显示的前缀 */
    public static final String CHILD_MENU_NAME_PREFIX = "|--";

    /* 系统父菜单默认的分组名和分组值 */
    public static final String PARENT_MENU_DEFAULT_MENU_GROUP_NAME = "父菜单";
    public static final String PARENT_MENU_DEFAULT_MENU_GROUP_VALUE = "menu:parent";

    /* 菜单icon的的前缀,因为bootstrap-iconpicker选择的菜单值默认少font awesome的icon前缀 */
    public static final String MENU_ICON_PREFIX = "fa ";

    /* 分组查询菜单时没有父菜单的分组名 */
    public static final String NO_PARENT_MENU_GROUP_NAME = "无父菜单";

    /* 角色权限关联表中确定可以删除的角色权限关系记录的标识值 */
    public static final int ROLE_PERMISSION_TABLE_TRUE_DELETE_FLAG = 1;

    /* 标识角色可编辑 */
    public static final int TRUE_ROLE_EDIT_FLAG = 1;

    /* 用户登陆后菜单的标识 */
    public static final String USER_MENU_PARENT_LEVEL = "userMenu";

    /* 超级管理员的ID */
    public static final String SUPER_ADMIN_USER_ID = "0";

    /* 用户登陆后遍历的菜单,无父菜单的菜单 */
    public static final String USER_MENU_LEVEL_1 = "userMenuLevel1";

    /**
     * excel文件后缀名
     */
    public static final String EXCEL_FILE_SUFFIX_1 = ".xls";
    public static final String EXCEL_FILE_SUFFIX_2 = ".xlsx";
}

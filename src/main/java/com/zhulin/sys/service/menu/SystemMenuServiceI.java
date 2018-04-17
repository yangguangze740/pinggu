package com.zhulin.sys.service.menu;

import com.zhulin.pojo.ClassRole;
import com.zhulin.pojo.Menu;

import java.util.List;
import java.util.Map;

public interface SystemMenuServiceI {
    boolean delete(String id);
    boolean update(Menu menu);
    Menu readDetail(String id);
    boolean createNewMenu(Menu menu);
    List<Menu> readList();
    boolean initSystemMenuAndRoleAndPermission(List<Menu> menus, List<ClassRole> roles);
    Map<String, List<Menu>> readNoParentMenus();
    boolean updateMenuIcon(Menu menu);
    Menu readEditMenuDetail(String id);
    Map<String,List<Menu>> readAllChildMenus();
    Map<String, List<Menu>> readListGroupByParent();
    List<Menu> readRoleMenuList(String id);
}

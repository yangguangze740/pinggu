package com.zhulin.sys.service.menu.impl;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import com.zhulin.common.def.Constants;
import com.zhulin.sys.pojo.*;
import com.zhulin.sys.mapper.menu.SystemMenuMapper;
import com.zhulin.sys.mapper.permission.SystemPermissionMapper;
import com.zhulin.sys.mapper.role.SystemRoleMapper;
import com.zhulin.sys.service.menu.SystemMenuServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ClassRolePermission(group = "system", name = "菜单管理角色", value = "menu:m", menuValue = "/admin/menu")
@Service
public class SystemMenuServiceImpl implements SystemMenuServiceI {

    @Autowired
    private SystemMenuMapper systemMenuMapper;
    @Autowired
    private SystemRoleMapper systemRoleMapper;
    @Autowired
    private SystemPermissionMapper systemPermissionMapper;

    @MethodRolePermission(group = "menu", name = "菜单删除", value = "menu:md", groupName = "菜单组")
    @Transactional
    @Override
    public boolean delete(String id) {
        // 判断是否是父菜单
        Menu menu = systemMenuMapper.selectMenuDetail(id);

        if (menu.getIsParentMenu() == Constants.TRUE_PARENT_MENU_FLAG_VALUE) {
            // 如果是父菜单 更新对应的子菜单的id为默认id

            String parentId = menu.getMenuId();
            int updateChildMenuNum = systemMenuMapper.updateChildMenuNoParent(parentId, Constants.IS_NOT_PARENT_MENU_DEFAULT_PARENT_ID);
        }

        // 物理删除菜单信息
        int deleteMenuNum = systemMenuMapper.deleteMenu(id);

        return deleteMenuNum == 1;
    }

    @MethodRolePermission(group = "menu", name = "菜单更新", value = "menu:mu", groupName = "菜单组")
    @Override
    public boolean update(Menu menu) {
        if (menu.getChildMenuIds().isEmpty()) return false;

        // 1. 判断新的icon是否为null,如果为null用老的
        String icon = menu.getIcon();
        if (Strings.isNullOrEmpty(icon)) {
            menu.setIcon(menu.getOldIcon());
        }

        int deleteChildMenuParentIdNum = 0;

        // 2.更新原来的子菜单的parentId为0
        if (menu.getOldChildMenuIds().size() > 0) {
            deleteChildMenuParentIdNum = systemMenuMapper.updateChildMenuParentId(Constants.IS_NOT_PARENT_MENU_DEFAULT_PARENT_ID, menu.getOldChildMenuIds());
        }

        // 3.更新菜单的新的子菜单
        int updateMenuChildNum = systemMenuMapper.updateChildMenuParentId(menu.getMenuId(), menu.getChildMenuIds());

        // 4.更新菜单
        int updateMenu = systemMenuMapper.updateMenu(menu);

        return (updateMenuChildNum == menu.getChildMenuIds().size()) && (deleteChildMenuParentIdNum == menu.getOldChildMenuIds().size());
    }

    @Override
    public Menu readDetail(String id) {
        return systemMenuMapper.selectMenuDetail(id);
    }

    @MethodRolePermission(group = "menu", name = "父菜单添加", value = "menu:pc", groupName = "菜单组")
    @Transactional
    @Override
    public boolean createNewMenu(Menu menu) {
        if (menu.getChildMenuIds().isEmpty()) return false;

        // 构建父menu对象
        String menuId = PrimaryKeyUtil.uuidPrimaryKey();
        menu.setMenuId(menuId);
        menu.setIsParentMenu(Constants.TRUE_PARENT_MENU_FLAG_VALUE);
        menu.setEditFlag(Constants.TRUE_MENU_EDIT_FLAG_VALUE);
        menu.setMenuGroupName(Constants.PARENT_MENU_DEFAULT_MENU_GROUP_NAME);
        menu.setMenuGroupValue(Constants.PARENT_MENU_DEFAULT_MENU_GROUP_VALUE);

        Menu menuLastOrderNum = systemMenuMapper.selectLastMenuOrderNum();

        int newOrderNum = menuLastOrderNum.getOrderNum() + 1;

        menu.setOrderNum(newOrderNum);

        // 保存父菜单
        int createParentMenuNum = systemMenuMapper.createNewParentMenu(menu);
        // 更新子菜单
        int updateChildMenNum = systemMenuMapper.updateChildMenuParentId(menuId, menu.getChildMenuIds());

        return (createParentMenuNum == 1) && (updateChildMenNum == menu.getChildMenuIds().size());
    }

    @MethodRolePermission(group = "menu", name = "菜单查询", value = "menu:r", groupName = "菜单组")
    @Override
    public List<Menu> readList() {
        List<Menu> menus = new ArrayList<>();

        // 读取所有父菜单
        List<Menu> parentMenus = systemMenuMapper.selectParentMenus(Constants.TRUE_PARENT_MENU_FLAG_VALUE);

        if (!parentMenus.isEmpty()) {
            for (Menu menu : parentMenus) {
                menu.setIcon(Constants.MENU_ICON_PREFIX + menu.getIcon());
                menus.add(menu);

                String parentId = menu.getMenuId();

                // 读取每个父菜单的下面的子菜单
                List<Menu> childMenus = systemMenuMapper.selectParentChildMenus(parentId);

                for (Menu tmpMenu : childMenus) {
                    tmpMenu.setMenuName(Constants.CHILD_MENU_NAME_PREFIX + tmpMenu.getMenuName());
                    tmpMenu.setIcon(Constants.MENU_ICON_PREFIX + tmpMenu.getIcon());
                }

                menus.addAll(childMenus);
            }
        }

        // 如果没有父菜单读取所有主菜单
        List<Menu> otherMenus = systemMenuMapper.selectNoParentChildMenus(Constants.IS_NOT_PARENT_MENU_DEFAULT_PARENT_ID);

        for (Menu otherMenu : otherMenus) {
            otherMenu.setIcon(Constants.MENU_ICON_PREFIX + otherMenu.getIcon());
        }

//        menus.addAll(parentMenus);
        menus.addAll(otherMenus);

        return menus;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,
            rollbackFor = {RuntimeException.class, Exception.class, SQLException.class, ArithmeticException.class},
            propagation= Propagation.REQUIRED)
    @Override
    public boolean initSystemMenuAndRoleAndPermission(List<Menu> menus, List<ClassRole> roles) {

        if (menus.isEmpty()) {
            return true;
        }

        // 1. 查询现在的menu
        List<Menu> oldMenus = systemMenuMapper.selectDBAllMenuRecords();

        if (!oldMenus.isEmpty()) {
            // 2. 备份现在的menu
            int newestVersion = 1;
            // 2.1 查询最后备份的版本
            Menu backMenuVersion = systemMenuMapper.selectLastVersionFromBakMenu();

            if (Optional.fromNullable(backMenuVersion).isPresent()) {
                newestVersion = backMenuVersion.getVersion() + 1;

                for (Menu oldMenu : oldMenus) {
                    oldMenu.setVersion(newestVersion);
                }
            }

            // 2.2 插入新的备份
            int insertBackMenuNumber = systemMenuMapper.insertBakMenuToBakMenuTable(oldMenus);
            // 3. 删除现在的menu
            int deleteOldMenuNumber = systemMenuMapper.delete4CleanMenuTable(oldMenus);
        }

        // 对菜单对象的数据预处理,赋默认值
        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.get(i);

            menu.setMenuId(PrimaryKeyUtil.uuidPrimaryKey());
            menu.setOrderNum(i);
        }

        // 4. 插入系统的menu
        int insertNewMenuNumber = systemMenuMapper.insertNewMenuToMenuTable(menus);

        // *******************************************************************************************************
        if (roles.isEmpty()) return true;

        List<RolePermission> rolePermissions = new ArrayList<>();
        List<MethodPermission> methodPermissions = new ArrayList<>();

        // 1. 获取权限
        // 2. 构建对应数据关系,主键和外键的值
        for (ClassRole classRole : roles) {
            String rolePrimaryKey = PrimaryKeyUtil.uuidPrimaryKey();
            classRole.setRoleId(rolePrimaryKey);

            List<MethodPermission> tmpPermissions = classRole.getMethodPermissions();

            for (MethodPermission permission : tmpPermissions) {
                String permissionPrimaryKey = PrimaryKeyUtil.uuidPrimaryKey();

                permission.setPermissionId(permissionPrimaryKey);

                methodPermissions.add(permission);

                RolePermission rolePermission = new RolePermission();

                rolePermission.setPermissionId(permissionPrimaryKey);
                rolePermission.setRoleId(rolePrimaryKey);

                rolePermissions.add(rolePermission);
            }
        }

        // 3. 备份当前版本的角色和权限
        List<ClassRole> oldRoles = systemRoleMapper.selectDBAllRoleRecords();

        if (!oldRoles.isEmpty()) {
            // 3.1 备份数据, 先获取版本号
            int newestVersion = 1;

            ClassRole lastVersionRole = systemRoleMapper.selectLastVersionFromBakRole();
            if (Optional.fromNullable(lastVersionRole).isPresent()) {
                newestVersion = lastVersionRole.getVersion() + 1;
            }

            for (ClassRole tmpOldRole : oldRoles) {
                tmpOldRole.setVersion(newestVersion);
            }

            int insertBakNum = systemRoleMapper.insertBakRoleToBakRoleTable(oldRoles);
            // 3.2 删除数据
            int deleteNum = systemRoleMapper.delete4CleanRoleTable(oldRoles);
        }

        // 3.3 添加新的角色
        int newRolesNumber = systemRoleMapper.insertNewRolesToRoleTable(roles);

        // 3.4 添加角色关联菜单
        List<SystemRoleMenu> roleMenus = new ArrayList<>();

        for (ClassRole role : roles) {
            String menuValue = role.getMenuValue();
            String roleId = role.getRoleId();

            SystemRoleMenu roleMenu = new SystemRoleMenu();
            roleMenu.setRoleId(roleId);

            for (Menu menu : menus) {
                if (menu.getMenuURL().equals(menuValue)) {
                    roleMenu.setMenuId(menu.getMenuId());
                }
            }

            if (!Strings.isNullOrEmpty(roleMenu.getMenuId())) {
                roleMenus.add(roleMenu);
            }
        }

        // 删除角色菜单
        List<SystemRoleMenu> allRoleMenus = systemMenuMapper.selectDBAllRoleMenus();
        int deleteAllRoleMenuNum = systemMenuMapper.deleteAllRoleMenus(allRoleMenus);

        // 插入角色对应的菜单
        int insertRoleMenus = systemRoleMapper.insertRoleMenus(roleMenus);

        // 4. 备份当前版本权限
        List<MethodPermission> oldPermissions = systemPermissionMapper.selectDBAllPermissionRecords();
        if (!oldPermissions.isEmpty()) {
            // 4.1 备份权限数据, 先获取版本号
            int newestVersion = 1;

            MethodPermission lastVersionPermissionDTO = systemPermissionMapper.selectLastVersionFromBakPermission();

            if (Optional.fromNullable(lastVersionPermissionDTO).isPresent()) {
                newestVersion = lastVersionPermissionDTO.getVersion() + 1;

                for (MethodPermission tmpPermission : oldPermissions) {
                    tmpPermission.setVersion(newestVersion);
                }
            }

            int insertBakPermissionNum = systemPermissionMapper.insertBakPermissionToBakPermissionTable(oldPermissions);
            // 4.3 备份数据
            int deletePermissionNum = systemPermissionMapper.delete4CleanPermissionTable(oldPermissions);
        }

        // 4.4 添加新的权限
        int insertNewPermissionNum = systemPermissionMapper.insertNewPermissionsToPermissionTable(methodPermissions);

        // 5. 添加新的角色和权限关系表数据
        List<RolePermission> oldRolePermissions = systemRoleMapper.selectDBAllRolePermissionRecords();

        if (!oldRolePermissions.isEmpty()) {
            int deleteRolePermissionNum = systemRoleMapper.delete4CleanRolePermissionTable(oldRolePermissions);
        }

        int insertNewRolePermissionNum = systemRoleMapper.insertNewRolePermissionsToRolePermissionTable(rolePermissions);

        // ***************************************************************************************************************
        // 6. 初始化超级管理员的角色关系
        List<SystemUserRole> adminRoles = new ArrayList<>();

        for (ClassRole role : roles) {
            SystemUserRole userRole = new SystemUserRole();

            userRole.setUserId(Constants.SUPER_ADMIN_USER_ID);
            userRole.setRoleId(role.getRoleId());

            adminRoles.add(userRole);
        }

        // 删除超级管理员角色
        List<SystemUserRole> oldUserRoles = systemRoleMapper.selectAllUserRoles();
        int deleteAllUserRoleNum = systemRoleMapper.deleteAllUserRoles(oldUserRoles);

        int insertAdminRoles = systemRoleMapper.insertUserRoles(adminRoles);

        return true;
    }

    @MethodRolePermission(group = "menu", name = "独立菜单查询", value = "menu:amr", groupName = "菜单组")
    @Override
    public Map<String, List<Menu>> readNoParentMenus() {
        List<Menu> isNotParentMenus = systemMenuMapper.selectNoParentChildMenus(Constants.IS_NOT_PARENT_MENU_DEFAULT_PARENT_ID);

        Map<String, List<Menu>> groupMenus = new HashMap<>();

        for (Menu menu : isNotParentMenus) {
            String menuGroupValue = menu.getMenuGroupName();

            if (groupMenus.containsKey(menuGroupValue)) {
                groupMenus.get(menuGroupValue).add(menu);
            } else {
                List<Menu> tmpMenus = new ArrayList<>();
                tmpMenus.add(menu);

                groupMenus.put(menuGroupValue, tmpMenus);
            }
        }

        return groupMenus;
    }

    @Transactional
    @Override
    public boolean updateMenuIcon(Menu menu) {
        return systemMenuMapper.updateMenuIcon(menu);
    }

    @MethodRolePermission(group = "menu", name = "菜单编辑查询", value = "menu:mer", groupName = "菜单组")
    @Override
    public Menu readEditMenuDetail(String id) {
        Menu parentMenu = systemMenuMapper.selectEditMenuDetail(id);
        parentMenu.setIcon(Constants.MENU_ICON_PREFIX + parentMenu.getIcon());

        if (parentMenu.getIsParentMenu() == 1) {
            List<Menu> childMenus = systemMenuMapper.selectParentChildMenus(parentMenu.getMenuId());

            for (Menu childMenu : childMenus) {
                childMenu.setIcon(Constants.MENU_ICON_PREFIX + childMenu.getIcon());
            }

            parentMenu.setChildMenus(childMenus);
        }

        return parentMenu;
    }

    @MethodRolePermission(group = "menu", name = "全部子菜单查询", value = "menu:acmr", groupName = "菜单组")
    @Override
    public Map<String, List<Menu>> readAllChildMenus() {
        List<Menu> allChildMenus = systemMenuMapper.selectAllChildMenus();

        Map<String, List<Menu>> groupMenus = new HashMap<>();

        for (Menu menu : allChildMenus) {
            String menuGroupValue = menu.getMenuGroupName();

            if (groupMenus.containsKey(menuGroupValue)) {
                groupMenus.get(menuGroupValue).add(menu);
            } else {
                List<Menu> tmpMenus = new ArrayList<>();
                tmpMenus.add(menu);

                groupMenus.put(menuGroupValue, tmpMenus);
            }
        }

        return groupMenus;
    }

    @Transactional
    @Override
    public Map<String, List<Menu>> readListGroupByParent() {
        List<Menu> parentMenus = systemMenuMapper.selectParentMenus(Constants.TRUE_PARENT_MENU_FLAG_VALUE);

        Map<String, List<Menu>> menuMap = new HashMap<>();

        if (!parentMenus.isEmpty()) {
            for (Menu menu : parentMenus) {
                String parentId = menu.getMenuId();

                // 读取每个父菜单的下面的子菜单
                List<Menu> childMenus = systemMenuMapper.selectParentChildMenus(parentId);

                menuMap.put(menu.getMenuName(), childMenus);
            }
        }

        // 如果没有父菜单读取所有主菜单
        List<Menu> otherMenus = systemMenuMapper.selectNoParentChildMenus(Constants.IS_NOT_PARENT_MENU_DEFAULT_PARENT_ID);

        menuMap.put(Constants.NO_PARENT_MENU_GROUP_NAME, otherMenus);

        return menuMap;
    }

    @MethodRolePermission(group = "role", name = "角色菜单查询", value = "role:rmr", groupName = "菜单组")
    @Override
    public List<Menu> readRoleMenuList(String id) {
        return systemMenuMapper.selectRoleMenuList(id);
    }

    @Override
    public Map<Menu, List<Menu>> readUserMenus(String userId) {
        // 1. 获得用户关联的所有角色
        List<SystemRole> roles = systemRoleMapper.selectUserRolesByUserId(userId);

        // 2. 获得角色关联的所有菜单
        List<Menu> menus = new ArrayList<>();

        for (SystemRole role : roles) {
            String roleId = role.getRoleId();

            List<Menu> roleMenus = systemMenuMapper.selectRoleMenuList(roleId);

            menus.addAll(roleMenus);
        }

        Menu noParentMenuMapKey = new Menu();
        noParentMenuMapKey.setMenuId(Constants.IS_NOT_PARENT_MENU_DEFAULT_PARENT_ID);

        List<Menu> noParentMenus = new ArrayList<>();

        // 3. 构建菜单父子结构
        Map<Menu, List<Menu>> map = new HashMap<>();
        for (Menu menu : menus) {
            String parentId = menu.getParentId();

            if (parentId.equals(Constants.IS_NOT_PARENT_MENU_DEFAULT_PARENT_ID)) {
                noParentMenus.add(menu);

                continue;
            }

            Menu parentMenuInfo = systemMenuMapper.selectMenuDetail(parentId);
            parentMenuInfo.setIcon(Constants.MENU_ICON_PREFIX + parentMenuInfo.getIcon());

            if (!map.containsKey(parentMenuInfo)) {
                List<Menu> mapValue = new ArrayList<>();
                mapValue.add(menu);

                map.put(parentMenuInfo, mapValue);
            } else {
                map.get(parentMenuInfo).add(menu);
            }
        }

        map.put(noParentMenuMapKey, noParentMenus);

        return map;
    }
}

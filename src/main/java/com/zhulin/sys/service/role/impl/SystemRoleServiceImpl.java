package com.zhulin.sys.service.role.impl;

import com.google.common.base.Optional;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import com.zhulin.common.def.Constants;
import com.zhulin.pojo.*;
import com.zhulin.sys.mapper.menu.SystemMenuMapper;
import com.zhulin.sys.mapper.permission.SystemPermissionMapper;
import com.zhulin.sys.mapper.role.SystemRoleMapper;
import com.zhulin.sys.service.role.SystemRoleServiceI;
import org.apache.ibatis.reflection.ReflectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ClassRolePermission(group = "system", name = "角色管理角色", value = "role:m")
@Service
public class SystemRoleServiceImpl implements SystemRoleServiceI {

    @Autowired
    private SystemRoleMapper systemRoleMapper;
    @Autowired
    private SystemPermissionMapper systemPermissionMapper;
    @Autowired
    private SystemMenuMapper systemMenuMapper;

    @MethodRolePermission(group = "role", name = "用户角色查询", value = "role:urr", groupName = "角色组")
    @Override
    public List<SystemRole> queryUserRolesByUserId(String userId) {
        return systemRoleMapper.selectUserRolesByUserId(userId);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,
            rollbackFor = {RuntimeException.class, Exception.class, SQLException.class, ArithmeticException.class, ReflectionException.class},
            propagation= Propagation.REQUIRED)
    @Override
    public boolean initSystemRolesAndPermissions(List<ClassRole> roles) {

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

        // 4. 备份当前版本权限
        List<MethodPermission> oldPermissions = systemPermissionMapper.selectDBAllPermissionRecords();
        if (!oldPermissions.isEmpty()) {
            // 4.1 备份权限数据, 先获取版本号
            int newestVersion = 1;

            MethodPermission lastVersionPermissionDTO = systemPermissionMapper.selectLastVersionFromBakPermission();

            if (Optional.fromNullable(lastVersionPermissionDTO).isPresent()) {
                newestVersion += 1;

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

        return true;
    }

    @MethodRolePermission(group = "role", name = "角色查询", value = "role:rr", groupName = "角色组")
    @Override
    public List<SystemRole> appReadList(SystemRole role) {
        // 1.查询所有的角色
        List<SystemRole> roles = systemRoleMapper.selectList();

        return roles;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,
            rollbackFor = {RuntimeException.class, Exception.class, SQLException.class, ArithmeticException.class},
            propagation= Propagation.REQUIRED)
    @MethodRolePermission(group = "role", name = "角色添加", value = "role:ra", groupName = "角色组")
    @Override
    public boolean createNewRole(SystemRole role) {
        // 1. 添加角色
        String roleId = PrimaryKeyUtil.uuidPrimaryKey();
        role.setRoleId(roleId);
        role.setEditFlag(Constants.TRUE_ROLE_EDIT_FLAG);

        // 2. 添加角色和菜单关系
        List<SystemRoleMenu> roleMenus = new ArrayList<>();

        List<String> menuIds = role.getMenuIds();

        for (String menuId : menuIds) {
            SystemRoleMenu roleMenu = new SystemRoleMenu();

            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);

            roleMenus.add(roleMenu);
        }

        // 3. 添加角色和权限关系
        List<SystemRolePermission> rolePermissions = new ArrayList<>();

        List<String> permissionIds = role.getPermissionIds();

        for (String permissionId : permissionIds) {
            SystemRolePermission rolePermission = new SystemRolePermission();

            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            rolePermission.setShouldDeleteFlag(Constants.ROLE_PERMISSION_TABLE_TRUE_DELETE_FLAG);

            rolePermissions.add(rolePermission);
        }

        int insertRoleMenuNum = systemRoleMapper.insertBatchRoleMenu(roleMenus);
        int insertRolePermissionNum = systemRoleMapper.insertBatchRolePermission(rolePermissions);
        int insertRoleNum = systemRoleMapper.insertNewRole(role);

        return (insertRoleMenuNum == menuIds.size())
                && (insertRolePermissionNum == permissionIds.size()
                && insertRoleNum == 1);
    }

    @Transactional
    @MethodRolePermission(group = "role", name = "角色删除", value = "role:rd", groupName = "角色组")
    @Override
    public boolean deleteRole(String id) {
        // 1. 删除角色权限
        int deletePermissionNum = systemRoleMapper.deleteRolePermissions(id);
        // 2. 删除角色菜单
        int deleteMenuNum = systemRoleMapper.deleteRoleMenus(id);
        // 3. 删除角色
        int deleteRoleNum = systemRoleMapper.deleteRole(id);

        return (deletePermissionNum >= 0) && (deleteMenuNum >= 0) && (deleteRoleNum >= 0);
    }

    @MethodRolePermission(group = "role", name = "角色详细查询", value = "role:rv", groupName = "角色组")
    @Override
    public SystemRole readDetail(String id) {
        return systemRoleMapper.selectDetail(id);
    }

    @Transactional
    @MethodRolePermission(group = "role", name = "角色编辑", value = "role:ru", groupName = "角色组")
    @Override
    public boolean update(SystemRole role) {
        String roleId = role.getRoleId();
        // 1. 删除原来的角色关联菜单
        int deleteMenuNum = systemRoleMapper.deleteRoleMenus(roleId);
        // 2. 删除原来的角色关联权限
        int deletePermissionNum = systemRoleMapper.deleteRolePermissions(roleId);
        // 3. 更新角色
        role.setEditFlag(Constants.TRUE_ROLE_EDIT_FLAG);

        int updateRoleNum = systemRoleMapper.update(role);

        // 4. 添加角色和菜单关系
        List<SystemRoleMenu> roleMenus = new ArrayList<>();

        List<String> menuIds = role.getMenuIds();

        for (String menuId : menuIds) {
            SystemRoleMenu roleMenu = new SystemRoleMenu();

            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);

            roleMenus.add(roleMenu);
        }

        int insertRoleMenuNum = systemRoleMapper.insertBatchRoleMenu(roleMenus);

        // 5. 添加角色和权限关系
        List<SystemRolePermission> rolePermissions = new ArrayList<>();

        List<String> permissionIds = role.getPermissionIds();

        for (String permissionId : permissionIds) {
            SystemRolePermission rolePermission = new SystemRolePermission();

            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            rolePermission.setShouldDeleteFlag(Constants.ROLE_PERMISSION_TABLE_TRUE_DELETE_FLAG);

            rolePermissions.add(rolePermission);
        }

        int insertRolePermissionNum = systemRoleMapper.insertBatchRolePermission(rolePermissions);

        return (deleteMenuNum >= 0) && (deletePermissionNum >= 0) && (insertRoleMenuNum > 0) && (insertRolePermissionNum > 0);
    }
}

package com.zhulin.sys.service.permission.impl;

import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.pojo.SystemPermission;
import com.zhulin.sys.mapper.permission.SystemPermissionMapper;
import com.zhulin.sys.service.permission.SystemPermissionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ClassRolePermission(group = "system", name = "权限管理角色", value = "permission:m")
@Service
public class SystemPermissionServiceImpl implements SystemPermissionServiceI {

    @Autowired
    private SystemPermissionMapper systemPermissionMapper;

    @MethodRolePermission(group = "permission", name = "角色权限查询", value = "permission:rrolep", groupName = "权限组")
    @Override
    public List<SystemPermission> queryRolePermissionsByRoleId(String roleId) {
        return systemPermissionMapper.selectRolePermissionsByRoleId(roleId);
    }

    @Transactional
    @MethodRolePermission(group = "permission", name = "所有权限查询", value = "permission:apr", groupName = "权限组")
    @Override
    public Map<String, List<SystemPermission>> readAllListGroupByGroupName() {

        List<SystemPermission> permissions = systemPermissionMapper.selectAllList();

        Map<String, List<SystemPermission>> groupPermissions = new HashMap<>();

        for (SystemPermission permission : permissions) {
            String permissionGroupName = permission.getPermissionGroupName();

            if (groupPermissions.containsKey(permissionGroupName)) {
                groupPermissions.get(permissionGroupName).add(permission);
            } else {
                List<SystemPermission> tmpPermissions = new ArrayList<>();
                tmpPermissions.add(permission);

                groupPermissions.put(permissionGroupName, tmpPermissions);
            }
        }

        return groupPermissions;
    }

    @MethodRolePermission(group = "role", name = "角色权限查询", value = "role:rqr", groupName = "权限")
    @Override
    public List<SystemPermission> readRolePermissionList(String id) {
        return systemPermissionMapper.selectRolePermissionList(id);
    }

    @Override
    public List<SystemPermission> readAllPermissions() {
        return systemPermissionMapper.selectAllPermissions();
    }
}

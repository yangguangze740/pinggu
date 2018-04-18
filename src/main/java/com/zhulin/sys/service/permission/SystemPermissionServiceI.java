package com.zhulin.sys.service.permission;

import com.zhulin.sys.pojo.SystemPermission;

import java.util.List;
import java.util.Map;

public interface SystemPermissionServiceI {
    List<SystemPermission> queryRolePermissionsByRoleId(String roleId);
    Map<String, List<SystemPermission>> readAllListGroupByGroupName();
    List<SystemPermission> readRolePermissionList(String id);
    List<SystemPermission> readAllPermissions();
}

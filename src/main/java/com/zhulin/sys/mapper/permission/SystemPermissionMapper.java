package com.zhulin.sys.mapper.permission;

import com.zhulin.pojo.MethodPermission;
import com.zhulin.pojo.SystemPermission;
import com.zhulin.sys.mapper.permission.provider.PermissionDeleteProvider;
import com.zhulin.sys.mapper.permission.provider.PermissionInsertProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface SystemPermissionMapper {
    @Select("SELECT permissionId, permissionName, permissionRemark, permissionCreateTime, permissionGroup, permissionValue FROM system_permission WHERE permissionId IN (SELECT permissionId FROM system_role_permission WHERE roleId = #{value})")
    @Results({
            @Result(id = true, column = "permissionId", property = "permissionId"),
            @Result(column = "permissionName", property = "permissionName"),
            @Result(column = "permissionRemark", property = "permissionRemark"),
            @Result(column = "permissionCreateTime", property = "permissionCreateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "permissionGroup", property = "permissionGroup"),
            @Result(column = "permissionValue", property = "permissionValue")
    })
    List<SystemPermission> selectRolePermissionsByRoleId(String roleId);

    @Select("SELECT permissionId, permissionName, permissionRemark, permissionCreateTime, permissionGroup, permissionValue, permissionGroupName FROM system_permission")
    @Results({
            @Result(id = true, column = "permissionId", property = "permissionId"),
            @Result(column = "permissionName", property = "name"),
            @Result(column = "permissionRemark", property = "remark"),
            @Result(column = "permissionCreateTime", property = "createTime"),
            @Result(column = "permissionGroup", property = "group"),
            @Result(column = "permissionValue", property = "value"),
            @Result(column = "permissionGroupName", property = "groupName")
    })
    List<MethodPermission> selectDBAllPermissionRecords();

    @Select("SELECT version FROM bak_permission ORDER BY version DESC LIMIT 0,1")
    @Results({
            @Result(column = "version", property = "version")
    })
    MethodPermission selectLastVersionFromBakPermission();

    @InsertProvider(type = PermissionInsertProvider.class, method = "insertBakPermissionToBakPermissionTable")
    int insertBakPermissionToBakPermissionTable(@Param("list") List<MethodPermission> oldPermissions);

    @DeleteProvider(type = PermissionDeleteProvider.class, method = "delete4CleanPermissionTable")
    int delete4CleanPermissionTable(@Param("list") List<MethodPermission> oldPermissions);

    @InsertProvider(type = PermissionInsertProvider.class, method = "insertNewPermissionsToPermissionTable")
    int insertNewPermissionsToPermissionTable(@Param("list") List<MethodPermission> permissionDTOs);

    @Select("SELECT permissionId, permissionName, permissionGroup, permissionValue, permissionRemark, permissionGroupName FROM system_permission")
    @Results({
            @Result(id = true, column = "permissionId", property = "permissionId"),
            @Result(column = "permissionName", property = "permissionName"),
            @Result(column = "permissionGroup", property = "permissionGroup"),
            @Result(column = "permissionValue", property = "permissionValue"),
            @Result(column = "permissionRemark", property = "permissionRemark"),
            @Result(column = "permissionGroupName", property = "permissionGroupName")
    })
    List<SystemPermission> selectAllList();

    @Select("SELECT permissionId, permissionName FROM system_permission WHERE permissionId IN (SELECT permissionId FROM system_role_permission WHERE roleId = #{value})")
    @Results({
            @Result(id = true, column = "permissionId", property = "permissionId"),
            @Result(column = "permissionName", property = "permissionName")
    })
    List<SystemPermission> selectRolePermissionList(String id);

    @Select("SELECT permissionId, permissionName, permissionRemark, permissionGroup, permissionGroupName, permissionValue FROM system_permission")
    @Results({
            @Result(id = true, column = "permissionId", property = "permissionId"),
            @Result(column = "permissionName", property = "permissionName"),
            @Result(column = "permissionRemark", property = "permissionRemark"),
            @Result(column = "permissionGroup", property = "permissionGroup"),
            @Result(column = "permissionGroupName", property = "permissionGroupName"),
            @Result(column = "permissionValue", property = "permissionValue")
    })
    List<SystemPermission> selectAllPermissions();
}

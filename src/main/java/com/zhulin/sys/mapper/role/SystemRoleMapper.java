package com.zhulin.sys.mapper.role;

import com.zhulin.sys.pojo.*;
import com.zhulin.sys.mapper.role.provider.RoleDeleteProvider;
import com.zhulin.sys.mapper.role.provider.RoleInsertProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface SystemRoleMapper {
    @Select("SELECT roleId, roleName, roleRemark, createTime, roleGroup, roleValue FROM system_role WHERE roleId IN (SELECT roleId FROM system_user_role WHERE userId = #{value})")
    @Results({
            @Result(id = true, column = "roleId", property = "roleId"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleRemark", property = "roleRemark"),
            @Result(column = "createTime", property = "createTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "roleGroup", property = "roleGroup"),
            @Result(column = "roleValue", property = "roleValue")
    })
    List<SystemRole> selectUserRolesByUserId(String userId);

    @Select("SELECT roleId, roleName, roleRemark, createTime, roleGroup, roleValue FROM system_role")
    @Results({
            @Result(id = true, column = "roleId", property = "roleId"),
            @Result(column = "roleName", property = "name"),
            @Result(column = "roleRemark", property = "remark"),
            @Result(column = "createTime", property = "createTime"),
            @Result(column = "roleGroup", property = "group"),
            @Result(column = "roleValue", property = "value"),
    })
    List<ClassRole> selectDBAllRoleRecords();

    @Select("SELECT version FROM bak_role ORDER BY version DESC LIMIT 0,1")
    @Results({
            @Result(column = "version", property = "version", jdbcType = JdbcType.TINYINT, javaType = Integer.class)
    })
    ClassRole selectLastVersionFromBakRole();

    @InsertProvider(type = RoleInsertProvider.class, method = "insertBakRoleToBakRoleTable")
    int insertBakRoleToBakRoleTable(@Param("list") List<ClassRole> oldRoles);

    @DeleteProvider(type = RoleDeleteProvider.class, method = "delete4CleanRoleTable")
    int delete4CleanRoleTable(@Param("list") List<ClassRole> oldRoles);

    @InsertProvider(type = RoleInsertProvider.class, method = "insertNewRolesToRoleTable")
    int insertNewRolesToRoleTable(@Param("list") List<ClassRole> newRoles);

    @Select("SELECT roleId, permissionId FROM system_role_permission")
    @Results({
            @Result(id = true, column = "roleId", property = "roleId"),
            @Result(id = true, column = "permissionId", property = "permissionId")
    })
    List<RolePermission> selectDBAllRolePermissionRecords();

    @DeleteProvider(type = RoleDeleteProvider.class, method = "delete4CleanRolePermissionTable")
    int delete4CleanRolePermissionTable(List<RolePermission> oldRolePermissions);

    @InsertProvider(type = RoleInsertProvider.class, method = "insertNewRolePermissionsToRolePermissionTable")
    int insertNewRolePermissionsToRolePermissionTable(List<RolePermission> rolePermissionDTOs);

    @Select("SELECT roleId, roleName, roleRemark, roleGroup, roleValue, editFlag FROM system_role ORDER BY editFlag DESC")
    @Results({
            @Result(id = true, column = "roleId", property = "roleId"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleRemark", property = "roleRemark"),
            @Result(column = "roleGroup", property = "roleGroup"),
            @Result(column = "roleValue", property = "roleValue"),
            @Result(column = "editFlag", property = "editFlag")
    })
    List<SystemRole> selectList();

    @InsertProvider(type = RoleInsertProvider.class, method = "insertBatchRoleMenu")
    int insertBatchRoleMenu(@Param("list") List<SystemRoleMenu> roleMenus);

    @InsertProvider(type = RoleInsertProvider.class, method = "insertBatchRolePermission")
    int insertBatchRolePermission(@Param("list") List<SystemRolePermission> rolePermissions);

    @Insert("INSERT INTO system_role (roleId, roleName, roleGroup, roleValue, editFlag, roleRemark) VALUES (#{roleId}, #{roleName}, #{roleGroup}, #{roleValue}, #{editFlag}, #{roleRemark})")
    int insertNewRole(SystemRole role);

    @Delete("DELETE FROM system_role_permission WHERE roleId = #{value} AND shouldDeleteFlag = 1")
    int deleteRolePermissions(String id);

    @Delete("DELETE FROM system_role_menu WHERE roleId = #{value}")
    int deleteRoleMenus(String id);

    @Delete("DELETE FROM system_role WHERE roleId = #{value}")
    int deleteRole(String id);

    @Select("SELECT roleId, roleName, roleRemark, roleGroup, roleValue, editFlag FROM system_role WHERE roleId = #{value}")
    SystemRole selectDetail(String id);

    @Update("UPDATE system_role SET roleName = #{roleName}, roleGroup = #{roleGroup}, roleValue = #{roleValue}, roleRemark = #{roleRemark} WHERE roleId = #{roleId}")
    int update(SystemRole role);

    @InsertProvider(type = RoleInsertProvider.class, method = "insertUserRoles")
    int insertUserRoles(@Param("list") List<SystemUserRole> userRoles);

    @DeleteProvider(type = RoleDeleteProvider.class, method = "deleteUserRoles")
    int deleteUserRoles(@Param("list") List<String> oldRoleIds);

    @Delete("DELETE FROM system_user_role WHERE userId = #{value}")
    int deleteUserRolesByUserId(String userId);

    @InsertProvider(type = RoleInsertProvider.class, method = "insertRoleMenus")
    int insertRoleMenus(@Param("list") List<SystemRoleMenu> roleMenus);

    @DeleteProvider(type = RoleDeleteProvider.class, method = "deleteAllUserRoles")
    int deleteAllUserRoles(@Param("list") List<SystemUserRole> oldUserRoles);

    @Select("SELECT userId, roleId FROM system_user_role")
    @Results({
            @Result(id = true, column = "userId", property = "userId"),
            @Result(id = true, column = "roleId", property = "roleId")
    })
    List<SystemUserRole> selectAllUserRoles();
}

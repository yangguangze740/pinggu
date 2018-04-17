package com.zhulin.sys.mapper.menu;

import com.zhulin.pojo.Menu;
import com.zhulin.sys.mapper.menu.provider.SystemMenuDeleteProvider;
import com.zhulin.sys.mapper.menu.provider.SystemMenuInsertProvider;
import com.zhulin.sys.mapper.menu.provider.SystemMenuUpdateProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface SystemMenuMapper {
    @Select("SELECT menuId, parentId, menuName, menuURL, menuType, icon, orderNum, menuGroupValue, menuGroupName, createTime, isParentMenu FROM system_menu")
    @Results({
            @Result(id = true, column = "menuId", property = "menuId"),
            @Result(column = "parentId", property = "parentId"),
            @Result(column = "menuName", property = "menuName"),
            @Result(column = "menuType", property = "menuType", jdbcType = JdbcType.TINYINT, javaType = Integer.class),
            @Result(column = "icon", property = "icon"),
            @Result(column = "orderNum", property = "orderNum", jdbcType = JdbcType.TINYINT, javaType = Integer.class),
            @Result(column = "menuGroupValue", property = "menuGroupValue"),
            @Result(column = "menuGroupName", property = "menuGroupName"),
            @Result(column = "createTime", property = "createTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "isParentMenu", property = "isParentMenu", jdbcType = JdbcType.TINYINT, javaType = Integer.class)
    })
    List<Menu> selectDBAllMenuRecords();

    @Select("SELECT version FROM bak_menu ORDER BY version DESC LIMIT 0, 1")
    @Results({
            @Result(column = "version", property = "version", jdbcType = JdbcType.TINYINT, javaType = Integer.class)
    })
    Menu selectLastVersionFromBakMenu();

    @InsertProvider(type = SystemMenuInsertProvider.class, method = "insertBakMenuToBakMenuTable")
    int insertBakMenuToBakMenuTable(@Param("list") List<Menu> oldMenus);

    @DeleteProvider(type = SystemMenuDeleteProvider.class, method = "delete4CleanMenuTable")
    int delete4CleanMenuTable(@Param("list") List<Menu> oldMenus);

    @InsertProvider(type = SystemMenuInsertProvider.class, method = "insertNewMenuToMenuTable")
    int insertNewMenuToMenuTable(@Param("list") List<Menu> menus);

    @Select("SELECT menuId, parentId, menuName, menuURL, menuType, icon, menuGroupValue, menuGroupName, editFlag FROM system_menu WHERE isParentMenu = #{value} ORDER BY orderNum DESC")
    @Results({
            @Result(id = true, column = "menuId", property = "menuId"),
            @Result(column = "parentId", property = "parentId"),
            @Result(column = "menuName", property = "menuName"),
            @Result(column = "menuURL", property = "menuURL"),
            @Result(column = "menuType", property = "menuType", javaType = Integer.class, jdbcType = JdbcType.TINYINT),
            @Result(column = "icon", property = "icon"),
            @Result(column = "menuGroupValue", property = "menuGroupValue"),
            @Result(column = "menuGroupName", property = "menuGroupName"),
            @Result(column = "editFlag", property = "editFlag", javaType = Integer.class, jdbcType = JdbcType.TINYINT)
    })
    List<Menu> selectParentMenus(int trueParentMenuFlagValue);

    @Select("SELECT menuId, parentId, menuName, menuURL, menuType, icon, menuGroupName, menuGroupValue, editFlag FROM system_menu WHERE parentId = #{value} AND isParentMenu = 0 ORDER BY orderNum DESC")
    @Results({
            @Result(id = true, column = "menuId", property = "menuId"),
            @Result(column = "parentId", property = "parentId"),
            @Result(column = "menuName", property = "menuName"),
            @Result(column = "menuURL", property = "menuURL"),
            @Result(column = "menuType", property = "menuType", javaType = Integer.class, jdbcType = JdbcType.TINYINT),
            @Result(column = "icon", property = "icon"),
            @Result(column = "menuGroupValue", property = "menuGroupValue"),
            @Result(column = "menuGroupName", property = "menuGroupName"),
            @Result(column = "editFlag", property = "editFlag", javaType = Integer.class, jdbcType = JdbcType.TINYINT)
    })
    List<Menu> selectParentChildMenus(String parentId);

    @Select("SELECT menuId, menuName, menuURL, menuType, icon, menuGroupName, menuGroupValue, editFlag FROM system_menu WHERE parentId = #{value} AND isParentMenu = 0 ORDER BY orderNum DESC")
    @Results({
            @Result(id = true, column = "menuId", property = "menuId"),
            @Result(column = "menuName", property = "menuName"),
            @Result(column = "menuURL", property = "menuURL"),
            @Result(column = "menuType", property = "menuType", javaType = Integer.class, jdbcType = JdbcType.TINYINT),
            @Result(column = "icon", property = "icon"),
            @Result(column = "menuGroupValue", property = "menuGroupValue"),
            @Result(column = "menuGroupName", property = "menuGroupName"),
            @Result(column = "editFlag", property = "editFlag", javaType = Integer.class, jdbcType = JdbcType.TINYINT)
    })
    List<Menu> selectNoParentChildMenus(String parentId);

    @Insert("INSERT INTO system_menu (menuId, menuName, menuURL, menuGroupName, menuGroupValue, icon, orderNum, isParentMenu, editFlag) VALUES (#{menuId}, #{menuName}, #{menuURL}, #{menuGroupName}, #{menuGroupValue}, #{icon}, #{orderNum}, #{isParentMenu}, #{editFlag})")
    int createNewParentMenu(Menu menu);

    @Select("SELECT orderNum FROM system_menu ORDER BY orderNum DESC LIMIT 0,1")
    @Results({
            @Result(column = "orderNum", property = "orderNum")
    })
    Menu selectLastMenuOrderNum();

    @UpdateProvider(type = SystemMenuUpdateProvider.class, method = "updateChildMenuParentId")
    int updateChildMenuParentId(@Param("menuId") String menuId, @Param("list") List<String> childMenuIds);

    @Select("SELECT menuId, menuName, menuURL, icon, menuGroupName, menuGroupValue, isParentMenu, editFlag FROM system_menu WHERE menuId = #{value}")
    @Results({
            @Result(id = true, column = "menuId", property = "menuId"),
            @Result(column = "menuName", property = "menuName"),
            @Result(column = "menuURL", property = "menuURL"),
            @Result(column = "icon", property = "icon"),
            @Result(column = "menuGroupName", property = "menuGroupName"),
            @Result(column = "menuGroupValue", property = "menuGroupValue"),
            @Result(column = "isParentMenu", property = "isParentMenu", jdbcType = JdbcType.TINYINT, javaType = Integer.class),
            @Result(column = "editFlag", property = "editFlag", jdbcType = JdbcType.TINYINT, javaType = Integer.class)
    })
    Menu selectMenuDetail(String id);

    @Update("UPDATE system_menu SET icon = #{icon} WHERE menuId = #{menuId}")
    boolean updateMenuIcon(Menu menu);

    @Update("UPDATE system_menu SET parentId = #{defaultParentId} WHERE parentId = #{parentId}")
    int updateChildMenuNoParent(@Param("parentId") String parentId, @Param("defaultParentId") String defaultParentId);

    @Delete("DELETE FROM system_menu WHERE menuId = #{value} AND editFlag = 1")
    int deleteMenu(String id);

    @Select("SELECT menuId, menuName, menuURL, icon, menuGroupName, menuGroupValue, isParentMenu, editFlag FROM system_menu WHERE menuId = #{value} AND editFlag = 1")
    @Results({
            @Result(id = true, column = "menuId", property = "menuId"),
            @Result(column = "menuName", property = "menuName"),
            @Result(column = "menuURL", property = "menuURL"),
            @Result(column = "icon", property = "icon"),
            @Result(column = "menuGroupName", property = "menuGroupName"),
            @Result(column = "menuGroupValue", property = "menuGroupValue"),
            @Result(column = "isParentMenu", property = "isParentMenu", jdbcType = JdbcType.TINYINT, javaType = Integer.class),
            @Result(column = "editFlag", property = "editFlag", jdbcType = JdbcType.TINYINT, javaType = Integer.class)
    })
    Menu selectEditMenuDetail(String id);

    @Select("SELECT menuId, menuName, menuURL, menuType, icon, menuGroupName, menuGroupValue, editFlag FROM system_menu WHERE isParentMenu = 0 ORDER BY orderNum DESC")
    @Results({
            @Result(id = true, column = "menuId", property = "menuId"),
            @Result(column = "menuName", property = "menuName"),
            @Result(column = "menuURL", property = "menuURL"),
            @Result(column = "menuType", property = "menuType", javaType = Integer.class, jdbcType = JdbcType.TINYINT),
            @Result(column = "icon", property = "icon"),
            @Result(column = "menuGroupValue", property = "menuGroupValue"),
            @Result(column = "menuGroupName", property = "menuGroupName"),
            @Result(column = "editFlag", property = "editFlag", javaType = Integer.class, jdbcType = JdbcType.TINYINT)
    })
    List<Menu> selectAllChildMenus();

    @Select("SELECT menuId, menuName, icon FROM system_menu WHERE menuId IN (SELECT menuId FROM system_role_menu WHERE roleId = #{value})")
    @Results({
            @Result(id = true, column = "menuId", property = "menuId"),
            @Result(id = true, column = "menuName", property = "menuName"),
            @Result(column = "icon", property = "icon")
    })
    List<Menu> selectRoleMenuList(String id);
}

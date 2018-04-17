package com.zhulin.sys.mapper.user;

import com.zhulin.pojo.SystemUser;
import com.zhulin.pojo.SystemUserRole;
import com.zhulin.sys.mapper.user.provider.UserInsertProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface SystemUserMapper {
    @Select("SELECT userId, username, password, salt, userStatus, userAvatar FROM system_user WHERE username = #{username}")
    @Results({
            @Result(id = true, column = "userId", property = "userId"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "salt", property = "salt"),
            @Result(column = "userStatus", property = "userStatus", jdbcType = JdbcType.TINYINT, javaType = Integer.class),
            @Result(column = "userAvatar", property = "userAvatar")
    })
    SystemUser select4Login(SystemUser user);

    @Select("SELECT U.userId, U.username, U.userAvatar, U.editFlag, UI.userRealName, UI.userMobile, UI.userEmail FROM system_user U LEFT JOIN system_userinfo UI ON U.userId = UI.userId ORDER BY username")
    @Results({
            @Result(id = true, column = "userId", property = "userId"),
            @Result(column = "username", property = "username"),
            @Result(column = "userAvatar", property = "userAvatar"),
            @Result(column = "userRealName", property = "userRealName"),
            @Result(column = "userMobile", property = "userMobile"),
            @Result(column = "userEmail", property = "userEmail"),

    })
    List<SystemUser> selectList();

    @Insert("INSERT INTO system_user (userId, username, password, salt) VALUES (#{userId}, #{username}, #{password}, #{salt})")
    int insertNewUser(SystemUser user);

    @Select("SELECT userId, username, userAvatar FROM system_user WHERE userId = #{value}")
    SystemUser selectUserDetail(String id);

    @Update("UPDATE system_user SET username = #{username} WHERE userId = #{userId}")
    int update(SystemUser user);

    @Update("DELETE FROM system_user WHERE userId = #{value}")
    int updateDeleteUser(String id);

    @Update("UPDATE system_user SET password = #{password}, salt = #{salt} WHERE userId = #{userId}")
    int updateUserPass(SystemUser user);
}

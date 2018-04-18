package com.zhulin.sys.mapper.userinfo;

import com.zhulin.sys.pojo.SystemUser;
import com.zhulin.sys.pojo.SystemUserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;

@Mapper
public interface SystemUserInfoMapper {
    @Select("SELECT userId, userMobile, userRealName, userEmail, createTime FROM system_userinfo WHERE userId = #{value}")
    @Results({
            @Result(id = true, column = "userId", property = "userId"),
            @Result(column = "userMobile", property = "userMobile"),
            @Result(column = "userRealName", property = "userRealName"),
            @Result(column = "userEmail", property = "userEmail"),
            @Result(column = "createTime", property = "createTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
    })
    SystemUserInfo selectUserInfoByUserId(String userId);

    @Insert("INSERT INTO system_userinfo (userId, userMobile, userRealName, userEmail) VALUES (#{userId}, #{userMobile}, #{userRealName}, #{userEmail})")
    int insertNewUserInfo(SystemUserInfo userInfo);

    @Update("UPDATE system_userinfo SET userMobile = #{userMobile}, userRealName = #{userRealName}, userEmail = #{userEmail} WHERE userId = #{userId}")
    int update(SystemUser user);

    @Update("DELETE FROM system_userinfo WHERE userId = #{value}")
    int updateDeleteUserinfo(String id);
}

package com.zhulin.sys.mapper.token;

import com.zhulin.sys.pojo.SystemUserToken;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;

@Mapper
public interface SystemUserTokenMapper {
    @Select("SELECT userId, token, expireTime, updateTime FROM system_user_token WHERE token = #{value}")
    @Results({
            @Result(id = true, column = "userId", property = "userId"),
            @Result(column = "token", property = "token"),
            @Result(column = "expireTime", property = "expireTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "updateTime", property = "updateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class)
    })
    SystemUserToken selectTokenInfoByToken(String accessToken);

    @Select("SELECT userId, token, expireTime, updateTime FROM system_user_token WHERE userId = #{value}")
    @Results({
            @Result(id = true, column = "userId", property = "userId"),
            @Result(column = "token", property = "token"),
            @Result(column = "expireTime", property = "expireTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "updateTime", property = "updateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class)
    })
    SystemUserToken selectTokenByUserId(String userId);

    @Insert("INSERT INTO system_user_token (userId, token, expireTime, updateTime) VALUES (#{userId}, #{token}, #{expireTime}, #{updateTime})")
    int insertNewUserToken(SystemUserToken userToken);

    @Update("UPDATE system_user_token SET token = #{token}, updateTime = #{updateTime}, expireTime = #{expireTime} WHERE userId = #{userId}")
    int updateUserToken(SystemUserToken userToken);
}

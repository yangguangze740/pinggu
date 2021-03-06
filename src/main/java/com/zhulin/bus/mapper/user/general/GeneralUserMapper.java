package com.zhulin.bus.mapper.user.general;


import com.zhulin.bus.bean.User;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface GeneralUserMapper extends ArcMapper<User>{

    @Select("SELECT userId,departmentName,userName,userPassword,userAccount,U.lockFlag,U.deleteFlag FROM pinggu_general_user U LEFT JOIN pinggu_department D ON U.departmentId = D.departmentId WHERE U.deleteFlag = 0 ORDER BY departmentName DESC, userName DESC")
    @Results({
            @Result(id = true, column = "userId", property = "userId"),
            @Result(column = "departmentName", property = "departmentName"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "userPassword", property = "userPassword"),
            @Result(column = "userAccount", property = "userAccount"),
            @Result(column = "lockFlag", property = "lockFlag"),
            @Result(column = "deleteFlag", property = "deleteFlag")
    })
    @Override
    List<User> selectList(User user);

    @Update("UPDATE pinggu_general_user SET departmentId = #{departmentId}, userName = #{userName}, userPassword = #{userPassword}, userAccount = #{userAccount}, addUserFlag = #{addUserFlag} WHERE userId = #{userId}")
    @Override
    boolean update(User user);

    @Select("SELECT userId, departmentId, userName, userPassword, userAccount, lockFlag, deleteFlag, addUserFlag FROM pinggu_general_user WHERE userId = #{userId}")
    @Results({
            @Result(id = true, column = "userId", property = "userId"),
            @Result(column = "departmentId", property = "departmentId"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "userPassword", property = "userPassword"),
            @Result(column = "userAccount", property = "userAccount"),
            @Result(column = "lockFlag", property = "lockFlag"),
            @Result(column = "deleteFlag", property = "deleteFlag"),
            @Result(column = "addUserFlag", property = "addUserFlag", jdbcType = JdbcType.TINYINT, javaType = Integer.class)
    })
    @Override
    User selectDetail(String id);

    @Insert("INSERT INTO pinggu_general_user (userId, departmentId, userName, userPassword, userAccount, addUserFlag) VALUES (#{userId}, #{departmentId}, #{userName}, #{userPassword}, #{userAccount}, #{addUserFlag})")
    @Override
    boolean insert(User user);

    @Update("UPDATE pinggu_general_user SET deleteFlag = '1' WHERE userId = #{userId}")
    @Override
    boolean delete(String id);
}

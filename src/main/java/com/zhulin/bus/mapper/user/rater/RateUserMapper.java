package com.zhulin.bus.mapper.user.rater;


import com.zhulin.bus.bean.RateUser;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RateUserMapper extends ArcMapper<RateUser> {


    @Select("SELECT raterUserId,raterUserName,raterUserPassword,raterUserAccount,lockFlag,deleteFlag FROM pinggu_rater_user where deleteFlag = 0")
    @Results({
            @Result(id = true, column = "raterUserId", property = "raterUserId"),
            @Result(column = "raterUserName", property = "raterUserName"),
            @Result(column = "raterUserPassword", property = "raterUserPassword"),
            @Result(column = "raterUserAccount", property = "raterUserAccount"),
            @Result(column = "lockFlag", property = "lockFlag"),
            @Result(column = "deleteFlag", property = "deleteFlag")
    })
    @Override
    List<RateUser> selectList(RateUser rateUser);

    @Update("UPDATE pinggu_rater_user SET raterUserName = #{raterUserName}, raterUserPassword = #{raterUserPassword}, raterUserAccount = #{raterUserAccount} WHERE raterUserId = #{raterUserId}")
    @Override
    boolean update(RateUser rateUser);

    @Select("SELECT raterUserId, raterUserName, raterUserPassword, raterUserAccount,lockFlag,deleteFlag FROM pinggu_rater_user WHERE raterUserId = #{value}")
    @Results({
            @Result(id = true, column = "raterUserId", property = "raterUserId"),
            @Result(column = "raterUserName", property = "raterUserName"),
            @Result(column = "raterUserPassword", property = "raterUserPassword"),
            @Result(column = "raterUserAccount", property = "raterUserAccount"),
            @Result(column = "lockFlag", property = "lockFlag"),
            @Result(column = "deleteFlag", property = "deleteFlag")
    })
    @Override
    RateUser selectDetail(String id);

    @Insert("INSERT INTO pinggu_rater_user (raterUserId, raterUserName,raterUserPassword,raterUserAccount) VALUES (#{raterUserId}, #{raterUserName},#{raterUserPassword},#{raterUserAccount})")
    @Override
    boolean insert(RateUser rateUser);

    @Update("UPDATE pinggu_rater_user SET deleteFlag = '1' WHERE raterUserId = #{raterUserId}")
    @Override
    boolean delete(String id);


}

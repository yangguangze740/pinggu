package com.zhulin.bus.mapper.config;

import com.zhulin.bus.bean.BusConfig;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ConfigMapper extends ArcMapper<BusConfig>{
    @Select("SELECT configId, configReviewStartDay, configReviewEndDay, configFrontReadLevel FROM pinggu_config LIMIT 0,1")
    @Results({
            @Result(id = true, column = "configId", property = "configId"),
            @Result(column = "configReviewStartDay", property = "configReviewStartDay"),
            @Result(column = "configReviewEndDay", property = "configReviewEndDay"),
            @Result(column = "configFrontReadLevel", property = "configFrontReadLevel")
    })
    BusConfig selectConfig();

    @Update("UPDATE pinggu_config SET configReviewStartDay = #{configReviewStartDay}, configReviewEndDay = #{configReviewEndDay}, configFrontReadLevel = #{configFrontReadLevel} WHERE configId = #{configId}")
    boolean updateConfig(BusConfig busConfig);
}

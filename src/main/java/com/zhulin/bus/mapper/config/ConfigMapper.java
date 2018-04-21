package com.zhulin.bus.mapper.config;

import com.zhulin.bus.bean.Config;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ConfigMapper extends ArcMapper<Config>{
    @Select("SELECT configId, configStartTime, configEndTime, configLevel FROM pinggu_config")
    @Results({
            @Result(id = true, column = "configId", property = "configId"),
            @Result(column = "configStartTime", property = "configStartTime"),
            @Result(column = "configEndTime", property = "configEndTime"),
            @Result(column = "configLevel", property = "configLevel")
    })
    Config selectConfig();

    @Update("UPDATE pinggu_config SET configStartTime=#{configStartTime}, configEndTime=#{configEndTime}, configLevel=#{configLevel} WHERE configId=#{configId}")
    boolean updateConfig(Config config);
}

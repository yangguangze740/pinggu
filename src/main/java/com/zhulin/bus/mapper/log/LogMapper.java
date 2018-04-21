package com.zhulin.bus.mapper.log;

import com.zhulin.bus.bean.Log;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface LogMapper extends ArcMapper<Log>{

    @Select("SELECT logId, logAction, logLevel, logContent, logUser, logTime, logIp, logUserId FROM pinggu_log")
    @Results({
            @Result(id = true, column = "logId", property = "logId"),
            @Result(column = "logAction", property = "logAction"),
            @Result(column = "logLevel", property = "logLevel"),
            @Result(column = "logContent", property = "logContent"),
            @Result(column = "logUser", property = "logUser"),
            @Result(column = "logTime", property = "logTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "logIp", property = "logIp"),
            @Result(column = "logUserId", property = "logUserId")
    })
    List<Log> selectList(Log log);
}

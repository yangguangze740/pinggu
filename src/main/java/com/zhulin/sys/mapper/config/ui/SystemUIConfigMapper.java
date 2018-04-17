package com.zhulin.sys.mapper.config.ui;

import com.zhulin.pojo.SystemUIConfig;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SystemUIConfigMapper {
    @Select("SELECT uiConfigId, loginLogo, systemName, titleValue, navTitle, titleIco FROM system_ui_config WHERE uiConfigId = #{value}")
    @Results({
            @Result(id = true, column = "uiConfigId", property = "uiConfigId"),
            @Result(column = "loginLogo", property = "loginLogo"),
            @Result(column = "systemName", property = "systemName"),
            @Result(column = "titleValue", property = "titleValue"),
            @Result(column = "navTitle", property = "navTitle"),
            @Result(column = "titleIco", property = "titleIco")
    })
    SystemUIConfig selectNowUIConfig(String uiConfigId);

    @Update("UPDATE system_ui_config SET loginLogo = #{loginLogo}, systemName = #{systemName}, titleValue = #{titleValue}, navTitle = #{navTitle}, titleIco = #{titleIco} WHERE uiConfigId = #{uiConfigId} ")
    int updateUIConfig(SystemUIConfig uiConfig);
}

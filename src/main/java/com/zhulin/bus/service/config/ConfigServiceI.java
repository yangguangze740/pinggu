package com.zhulin.bus.service.config;

import com.zhulin.bus.bean.Config;
import com.zhulin.framework.service.ArcService;

public interface ConfigServiceI extends ArcService<Config>{
    Config readConfig();

    boolean updateConfig(Config config);
}

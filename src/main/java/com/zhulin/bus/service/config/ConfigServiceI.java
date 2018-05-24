package com.zhulin.bus.service.config;

import com.zhulin.bus.bean.BusConfig;
import com.zhulin.framework.service.ArcService;

public interface ConfigServiceI extends ArcService<BusConfig>{
    BusConfig readConfig();

    boolean updateConfig(BusConfig busConfig);
}

package com.zhulin.sys.service.config.ui;

import com.zhulin.sys.pojo.SystemUIConfig;

public interface SystemUIConfigServiceI {
    SystemUIConfig readNowUIConfig(String uiConfigId);
    boolean updateUIConfig(SystemUIConfig uiConfig);
}

package com.zhulin.sys.service.config.ui;

import com.zhulin.pojo.SystemUIConfig;

public interface SystemUIConfigServiceI {
    SystemUIConfig readNowUIConfig(String uiConfigId);
    boolean updateUIConfig(SystemUIConfig uiConfig);
}

package com.zhulin.sys.service.config.ui.impl;

import com.zhulin.pojo.SystemUIConfig;
import com.zhulin.sys.mapper.config.ui.SystemUIConfigMapper;
import com.zhulin.sys.service.config.ui.SystemUIConfigServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SystemUIConfigServiceImpl implements SystemUIConfigServiceI {

    @Autowired
    private SystemUIConfigMapper uiConfigMapper;

    @Override
    public SystemUIConfig readNowUIConfig(String uiConfigId) {
        return uiConfigMapper.selectNowUIConfig(uiConfigId);
    }

    @Transactional
    @Override
    public boolean updateUIConfig(SystemUIConfig uiConfig) {
        int updateNumber = uiConfigMapper.updateUIConfig(uiConfig);

        return updateNumber == 1;
    }
}

package com.zhulin.sys.service.config.ui.impl;

import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.sys.pojo.SystemUIConfig;
import com.zhulin.sys.mapper.config.ui.SystemUIConfigMapper;
import com.zhulin.sys.service.config.ui.SystemUIConfigServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@ClassRolePermission(group = "system", name = "UI管理角色", value = "ui:m", menuValue = "/admin/ui")
public class SystemUIConfigServiceImpl implements SystemUIConfigServiceI {

    @Autowired
    private SystemUIConfigMapper uiConfigMapper;

    @Override
    @MethodRolePermission(group = "ui", name = "UI查询", value = "ui:ur", groupName = "UI组")
    public SystemUIConfig readNowUIConfig(String uiConfigId) {
        return uiConfigMapper.selectNowUIConfig(uiConfigId);
    }

    @Transactional
    @Override
    @MethodRolePermission(group = "ui", name = "UI更新", value = "ui:", groupName = "UI组")
    public boolean updateUIConfig(SystemUIConfig uiConfig) {
        int updateNumber = uiConfigMapper.updateUIConfig(uiConfig);

        return updateNumber == 1;
    }
}

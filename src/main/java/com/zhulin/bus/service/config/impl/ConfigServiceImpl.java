package com.zhulin.bus.service.config.impl;

import com.zhulin.bus.bean.Config;
import com.zhulin.bus.mapper.config.ConfigMapper;
import com.zhulin.bus.service.config.ConfigServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@ClassRolePermission(group = "config", name = "系统配置", value = "config:m", menuValue = "/admin/config")
@Service
public class ConfigServiceImpl implements ConfigServiceI{

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public List<Config> appReadList(Config config) {
        return null;
    }

    @Override
    public Config appReadDetail(String id) {
        return null;
    }

    @Override
    public boolean appUpdate(Config config) {
        return false;
    }

    @Override
    public boolean appDelete(String id) {
        return false;
    }

    @Override
    public boolean appCreate(Config config) {
        return false;
    }

    @MethodRolePermission(group = "config", name = "配置查看", value = "config:mr", groupName = "配置组")
    @Override
    public Config readConfig() {
        return configMapper.selectConfig();
    }

    @MethodRolePermission(group = "config", name = "配置编辑", value = "config:mr", groupName = "配置组")
    @Transactional
    @Override
    public boolean updateConfig(Config config) {
        //开始评审时间加一天
        Calendar cal = Calendar.getInstance();

        cal.setTime(config.getConfigStartTime());
        cal.add(Calendar.DATE, 1);
        java.util.Date utilStartDate = cal.getTime();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());

        config.setConfigStartTime(sqlStartDate);

        //结束评审时间加一天
        cal.setTime(config.getConfigEndTime());
        cal.add(Calendar.DATE, 1);
        java.util.Date utilEndDate = cal.getTime();
        java.sql.Date sqlEndDate = new java.sql.Date(utilEndDate.getTime());

        config.setConfigEndTime(sqlEndDate);

        return configMapper.updateConfig(config);
    }
}

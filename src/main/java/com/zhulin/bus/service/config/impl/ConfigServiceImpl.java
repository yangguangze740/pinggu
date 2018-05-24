package com.zhulin.bus.service.config.impl;

import com.zhulin.bus.bean.BusConfig;
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
    public List<BusConfig> appReadList(BusConfig busConfig) {
        return null;
    }

    @Override
    public BusConfig appReadDetail(String id) {
        return null;
    }

    @Override
    public boolean appUpdate(BusConfig busConfig) {
        return false;
    }

    @Override
    public boolean appDelete(String id) {
        return false;
    }

    @Override
    public boolean appCreate(BusConfig busConfig) {
        return false;
    }

    @MethodRolePermission(group = "config", name = "配置查看", value = "config:mr", groupName = "配置组")
    @Override
    public BusConfig readConfig() {
        return configMapper.selectConfig();
    }

    @MethodRolePermission(group = "busConfig", name = "配置编辑", value = "busConfig:mr", groupName = "配置组")
    @Transactional
    @Override
    public boolean updateConfig(BusConfig busConfig) {
        //开始评审时间加一天
        Calendar cal = Calendar.getInstance();

        cal.setTime(busConfig.getConfigReviewStartDay());
        cal.add(Calendar.DATE, 1);
        java.util.Date utilStartDate = cal.getTime();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());

        busConfig.setConfigReviewStartDay(sqlStartDate);

        //结束评审时间加一天
        cal.setTime(busConfig.getConfigReviewEndDay());
        cal.add(Calendar.DATE, 1);
        java.util.Date utilEndDate = cal.getTime();
        java.sql.Date sqlEndDate = new java.sql.Date(utilEndDate.getTime());

        busConfig.setConfigReviewEndDay(sqlEndDate);

        return configMapper.updateConfig(busConfig);
    }
}

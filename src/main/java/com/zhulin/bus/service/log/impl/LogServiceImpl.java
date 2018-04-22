package com.zhulin.bus.service.log.impl;

import com.zhulin.bus.bean.Log;
import com.zhulin.bus.mapper.log.LogMapper;
import com.zhulin.bus.service.log.LogServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@ClassRolePermission(group = "config", name = "系统配置", value = "config:m", menuValue = "/admin/log")
@Service
public class LogServiceImpl implements LogServiceI{

    @Autowired
    private LogMapper logMapper;

    @MethodRolePermission(group = "log", name = "日志查看", value = "log:mr", groupName = "日志组")
    @Override
    public List<Log> appReadList(Log log) {
        return logMapper.selectList(log);
    }

    @Override
    public Log appReadDetail(String id) {
        return null;
    }

    @Override
    public boolean appUpdate(Log log) {
        return false;
    }

    @Override
    public boolean appDelete(String id) {
        return false;
    }

    @Override
    public boolean appCreate(Log log) {
        return false;
    }
}

package com.zhulin.sys.service.role;

import com.zhulin.sys.pojo.*;

import java.util.List;

public interface SystemRoleServiceI {
    List<SystemRole> queryUserRolesByUserId(String userId);
    List<SystemRole> appReadList(SystemRole role);
    boolean createNewRole(SystemRole role);
    boolean deleteRole(String id);
    SystemRole readDetail(String id);
    boolean update(SystemRole role);
}

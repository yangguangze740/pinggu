package com.zhulin.sys.service.user;

import com.zhulin.sys.pojo.SystemUser;

import java.util.List;

public interface SystemUserServiceI {
    SystemUser query4Login(SystemUser user);
    List<SystemUser> readList();
    boolean createNewUser(SystemUser user);
    SystemUser readUserDetail(String id);
    boolean update(SystemUser user);
    boolean delete(String id);
    boolean updateUserRoles(SystemUser user);
    boolean updateUserPass(SystemUser user);
}

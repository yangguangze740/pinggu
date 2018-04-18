package com.zhulin.sys.service.user.impl;

import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import com.zhulin.common.shiro.ShiroUtils;
import com.zhulin.sys.pojo.SystemRole;
import com.zhulin.sys.pojo.SystemUser;
import com.zhulin.sys.pojo.SystemUserInfo;
import com.zhulin.sys.pojo.SystemUserRole;
import com.zhulin.sys.mapper.role.SystemRoleMapper;
import com.zhulin.sys.mapper.user.SystemUserMapper;
import com.zhulin.sys.mapper.userinfo.SystemUserInfoMapper;
import com.zhulin.sys.service.user.SystemUserServiceI;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@ClassRolePermission(group = "system", name = "用户管理角色", value = "user:m", menuValue = "/admin/user")
public class SystemUserServiceImpl implements SystemUserServiceI {

    @Autowired
    private SystemUserMapper userMapper;
    @Resource
    private SystemUserInfoMapper userInfoMapper;
    @Resource
    private SystemRoleMapper roleMapper;

    @Override
    public SystemUser query4Login(SystemUser user) {
        return userMapper.select4Login(user);
    }

    @Override
    @MethodRolePermission(group = "user", name = "用户查询", value = "user:ur", groupName = "用户组")
    public List<SystemUser> readList() {
        return userMapper.selectList();
    }

    @Transactional
    @Override
    @MethodRolePermission(group = "user", name = "用户添加", value = "user:ua", groupName = "用户组")
    public boolean createNewUser(SystemUser user) {
        // 保存登陆用户信息
        String salt = ShiroUtils.getSalt();
        String encryptPass = new Sha256Hash(user.getPassword(), salt).toHex();
        String userId = PrimaryKeyUtil.uuidPrimaryKey();

        user.setPassword(encryptPass);
        user.setSalt(salt);
        user.setUserId(userId);
        // 保存用户详细信息
        int insertUserNum = userMapper.insertNewUser(user);

        // 保存用户详细信息
        SystemUserInfo userInfo = new SystemUserInfo();

        userInfo.setUserEmail(user.getUserEmail());
        userInfo.setUserId(userId);
        userInfo.setUserMobile(user.getUserMobile());
        userInfo.setUserRealName(user.getUserRealName());

        int insertUserInfoNum = userInfoMapper.insertNewUserInfo(userInfo);

        // 保存用户和角色关系
        List<SystemUserRole> userRoles = new ArrayList<>();

        for (String roleId : user.getRoleIds()) {
            SystemUserRole userRole = new SystemUserRole();

            userRole.setUserId(userId);
            userRole.setRoleId(roleId);

            userRoles.add(userRole);
        }

        int insertUserRoleNum = roleMapper.insertUserRoles(userRoles);

        return (insertUserNum == 1)
                && (insertUserInfoNum == 1)
                && (insertUserRoleNum == userRoles.size());
    }

    @Override
    @MethodRolePermission(group = "user", name = "用户详细", value = "user:ud", groupName = "用户组")
    public SystemUser readUserDetail(String id) {
        // 1. 查询登陆用户信息system_user
        SystemUser userDetail = userMapper.selectUserDetail(id);
        // 2. 查询用户详细信息system_userinfo
        SystemUserInfo userInfo = userInfoMapper.selectUserInfoByUserId(id);

        userDetail.setUserRealName(userInfo.getUserRealName());
        userDetail.setUserMobile(userInfo.getUserMobile());
        userDetail.setUserEmail(userInfo.getUserEmail());

        // 3. 查询用户角色

        List<SystemRole> userRoles = roleMapper.selectUserRolesByUserId(id);

        userDetail.setRoles(userRoles);

        return userDetail;
    }

    @Transactional
    @Override
    @MethodRolePermission(group = "user", name = "用户更新", value = "user:uu", groupName = "用户组")
    public boolean update(SystemUser user) {
        // 1. 更新用户 system_user
        int updateUserNum = userMapper.update(user);
        // 2. 更新用户信息 system_userinfo
        int updateUserinfoNum = userInfoMapper.update(user);
        // 3. 更新用户角色信息
        int insertUserRoleNum = 1;

        List<String> roleIds = user.getRoleIds();
        String userId = user.getUserId();

        if (null != roleIds && (!roleIds.isEmpty())) {
            // 1. 删除原来的用户角色
            int deleteUserRoleNum = roleMapper.deleteUserRolesByUserId(userId);

            List<SystemUserRole> userRoles = new ArrayList<>();

            for (String roleId : roleIds) {
                SystemUserRole userRole = new SystemUserRole();

                userRole.setRoleId(roleId);
                userRole.setUserId(userId);

                userRoles.add(userRole);
            }

            // 2. 添加新的用户角色
            insertUserRoleNum = roleMapper.insertUserRoles(userRoles);

            return (updateUserNum == 1)
                    && (updateUserinfoNum == 1)
                    && (insertUserRoleNum == roleIds.size())
                    && (deleteUserRoleNum == user.getOldRoleIds().size());
        } else {
            return (updateUserNum == 1)
                    && (updateUserinfoNum == 1);
        }
    }

    @Transactional
    @Override
    @MethodRolePermission(group = "user", name = "用户删除", value = "user:ud", groupName = "用户组")
    public boolean delete(String id) {
        // 1. 逻辑删除用户 system_user
        int deleteUserNum = userMapper.updateDeleteUser(id);
        // 2. 逻辑删除用户信息 system_userinfo
        int deleteUserinfoNum = userInfoMapper.updateDeleteUserinfo(id);
        // 3. 物理删除用户角色
        int deleteUserRoleNum = roleMapper.deleteUserRolesByUserId(id);

        return (deleteUserNum == 1)
                && (deleteUserinfoNum == 1)
                && (deleteUserRoleNum >= 1);
    }

    @Transactional
    @Override
    @MethodRolePermission(group = "user", name = "用户角色更新", value = "user:uru", groupName = "用户组")
    public boolean updateUserRoles(SystemUser user) {
        List<String> roleIds = user.getRoleIds();
        String userId = user.getUserId();
        int oldRoleNums = user.getOldRoleIds() == null ? 0 : user.getOldRoleIds().size();

        if (null != roleIds && (!roleIds.isEmpty())) {
            // 1. 删除原来的用户角色
            int deleteUserRoleNum = roleMapper.deleteUserRolesByUserId(userId);

            List<SystemUserRole> userRoles = new ArrayList<>();

            for (String roleId : roleIds) {
                SystemUserRole userRole = new SystemUserRole();

                userRole.setRoleId(roleId);
                userRole.setUserId(userId);

                userRoles.add(userRole);
            }

            // 2. 添加新的用户角色
            int insertUserRoleNum = roleMapper.insertUserRoles(userRoles);

            return (insertUserRoleNum == roleIds.size())
                    && (deleteUserRoleNum == oldRoleNums);
        }

        return false;
    }

    @Transactional
    @Override
    public boolean updateUserPass(SystemUser user) {
        String pass = user.getPassword();

        String salt = ShiroUtils.getSalt();
        String encryptPass = new Sha256Hash(pass, salt).toHex();

        user.setSalt(salt);
        user.setPassword(encryptPass);

        int updateUserPassNum = userMapper.updateUserPass(user);

        return updateUserPassNum == 1;
    }
}

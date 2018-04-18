package com.zhulin.sys.oauth2;

import com.zhulin.common.oauth2.OAuth2Token;
import com.zhulin.sys.pojo.SystemPermission;
import com.zhulin.sys.pojo.SystemRole;
import com.zhulin.sys.pojo.SystemUserInfo;
import com.zhulin.sys.pojo.SystemUserToken;
import com.zhulin.sys.service.permission.SystemPermissionServiceI;
import com.zhulin.sys.service.role.SystemRoleServiceI;
import com.zhulin.sys.service.token.SystemUserTokenServiceI;
import com.zhulin.sys.service.userinfo.SystemUserInfoServiceI;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("realm")
public class OAuth2Realm extends AuthorizingRealm {

    @Resource
    private SystemUserTokenServiceI systemUserTokenService;
    @Resource
    private SystemUserInfoServiceI systemUserInfoService;
    @Resource
    private SystemRoleServiceI systemRoleService;
    @Resource
    private SystemPermissionServiceI systemPermissionService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SystemUserInfo userInfo = (SystemUserInfo) principals.getPrimaryPrincipal();

        if (userInfo != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

            List<SystemRole> roles = systemRoleService.queryUserRolesByUserId(userInfo.getUserId());

            Set<String> roleNameSet = new HashSet<>();

            for (SystemRole role : roles) {
                roleNameSet.add(role.getRoleValue());

                List<SystemPermission> permissions = systemPermissionService.queryRolePermissionsByRoleId(role.getRoleId());

                for (SystemPermission permission : permissions) {
                    info.addStringPermission(permission.getPermissionValue());
                }
            }

            info.setRoles(roleNameSet);

            return info;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String accessToken = (String) token.getPrincipal();

        SystemUserToken userToken = systemUserTokenService.querySystemUserTokenByToken(accessToken);

        if (userToken == null || userToken.getExpireTime().getTime() < System.currentTimeMillis()) {
            throw new IncorrectCredentialsException("token失效,请重新登录");
        }

        SystemUserInfo userInfo = systemUserInfoService.queryUserInfoByUserId(userToken.getUserId());

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userInfo, accessToken, getName());

        return info;
    }
}

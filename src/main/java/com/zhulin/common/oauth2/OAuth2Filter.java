package com.zhulin.common.oauth2;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.zhulin.common.def.Constants;
import com.zhulin.common.shiro.ShiroUtils;
import com.zhulin.pojo.SystemUserToken;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class OAuth2Filter extends AuthenticatingFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        String token = getShiroSessionToken();

        if (Strings.isNullOrEmpty(token)) {
            WebUtils.issueRedirect(request, response, this.getLoginUrl());

            return false;
        }

        return executeLogin(request, response);
    }

    private String getShiroSessionToken() {
        SystemUserToken userToken = (SystemUserToken) ShiroUtils.getSessionAttr(Constants.TOKEN_KEY);

        if (Optional.fromNullable(userToken).isPresent()) {
            return userToken.getToken();
        }

        return null;
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        String token = getShiroSessionToken();

        if (Strings.isNullOrEmpty(token)) {
            return null;
        }

        return new OAuth2Token(token);
    }
}

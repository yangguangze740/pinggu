package com.zhulin.sys.controller.login;

import com.zhulin.common.def.Constants;
import com.zhulin.common.shiro.ShiroUtils;
import com.zhulin.pojo.SystemUser;
import com.zhulin.pojo.SystemUserToken;
import com.zhulin.sys.service.token.SystemUserTokenServiceI;
import com.zhulin.sys.service.user.SystemUserServiceI;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SystemUserServiceI systemUserService;
    @Autowired
    private SystemUserTokenServiceI systemUserTokenService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String routeLoginPage() {
        return "sys/login/login";
    }

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    public String login(SystemUser user, Model model, HttpSession session) {
        SystemUser resultUser = systemUserService.query4Login(user);

        if (resultUser == null || !resultUser.getPassword()
                .equals(new Sha256Hash(user.getPassword(), resultUser.getSalt()).toHex())
                ) {
            return "redirect:/login";
        }

        SystemUserToken token = systemUserTokenService.createToken(resultUser.getUserId());

        if (token != null) {
            ShiroUtils.setSessionAttr(Constants.TOKEN_KEY, token);
            session.setAttribute(Constants.LOGIN_USER, resultUser);

            return "redirect:/home/index";
        } else {
            return "redirect:/login";
        }
    }
}

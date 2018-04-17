package com.zhulin.sys.controller.logout;

import com.zhulin.common.def.Constants;
import com.zhulin.common.shiro.ShiroUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        ShiroUtils.logout();

        return "redirect:/login";
    }
}

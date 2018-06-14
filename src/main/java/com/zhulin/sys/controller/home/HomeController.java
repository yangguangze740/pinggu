package com.zhulin.sys.controller.home;

import com.zhulin.common.def.Constants;
import com.zhulin.sys.pojo.SystemUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("")
    public String index(HttpServletRequest request) {
        SystemUser user = (SystemUser) request.getSession().getAttribute(Constants.LOGIN_USER);

        if (user == null) {
            return "redirect:/login";
        } else {
            String requestURI = request.getRequestURI();

            System.out.println(requestURI);

            return "redirect:" + requestURI;
        }
    }
}

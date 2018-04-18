package com.zhulin.sys.controller.login;

import com.zhulin.common.def.Constants;
import com.zhulin.common.shiro.ShiroUtils;
import com.zhulin.sys.pojo.Menu;
import com.zhulin.sys.pojo.SystemUser;
import com.zhulin.sys.pojo.SystemUserToken;
import com.zhulin.sys.service.menu.SystemMenuServiceI;
import com.zhulin.sys.service.token.SystemUserTokenServiceI;
import com.zhulin.sys.service.user.SystemUserServiceI;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SystemUserServiceI systemUserService;
    @Autowired
    private SystemUserTokenServiceI systemUserTokenService;
    @Resource
    private SystemMenuServiceI systemMenuService;

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

        String userId = resultUser.getUserId();

        SystemUserToken token = systemUserTokenService.createToken(userId);

        if (token != null) {
            ShiroUtils.setSessionAttr(Constants.TOKEN_KEY, token);
            session.setAttribute(Constants.LOGIN_USER, resultUser);

            // 读取这个用户所拥有的菜单
            // TODO 菜单缓存
            Map<Menu, List<Menu>> userMenus = systemMenuService.readUserMenus(userId);

            Menu noParentMenuMapKey = new Menu();
            noParentMenuMapKey.setMenuId(Constants.IS_NOT_PARENT_MENU_DEFAULT_PARENT_ID);

            List<Menu> noParentMenus = userMenus.get(noParentMenuMapKey);
            userMenus.remove(noParentMenuMapKey);

            session.setAttribute(Constants.USER_MENU_PARENT_LEVEL, userMenus);
            session.setAttribute(Constants.USER_MENU_LEVEL_1, noParentMenus);

            return "redirect:/home/index";
        } else {
            return "redirect:/login";
        }
    }
}

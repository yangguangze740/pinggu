package com.zhulin.sys.controller.config.data;

import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.def.Constants;
import com.zhulin.common.menu.scan.MenuURLLoad;
import com.zhulin.common.permission.preload.SystemPermissionConfigPreload;
import com.zhulin.sys.pojo.ClassRole;
import com.zhulin.sys.pojo.Menu;
import com.zhulin.sys.service.menu.SystemMenuServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/data")
public class MenuAndRoleAndPermissionDataInitController {

    @Autowired
    private SystemMenuServiceI menuService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        return "sys/config/data/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String initMenuAndRoleAndPermissionData(RedirectAttributes message) {
        MenuURLLoad menuLoad = new MenuURLLoad(
                Arrays.asList("com.zhulin.bus.controller", "com.zhulin.sys.controller"), ClassMenuURL.class);
        SystemPermissionConfigPreload configPreload = new SystemPermissionConfigPreload(
                Arrays.asList("com.zhulin.sys.service", "com.zhulin.bus.service"), MethodRolePermission.class, ClassRolePermission.class);

        boolean isMenuInit = false;

        try {
            List<Menu> menus = menuLoad.scanAnnotationMenus();
            List<ClassRole> roles = configPreload.scanAnnotationClasses();
            isMenuInit = menuService.initSystemMenuAndRoleAndPermission(menus, roles);
        } catch (IOException e) {
            // TODO
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO
            e.printStackTrace();
        }

        if (isMenuInit) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "初始化系统菜单和角色和权限成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "初始化系统菜单和角色和权限失败");
        }

        return "redirect:/admin/data";
    }

    // 追加扫面菜单权限角色
    @RequestMapping(value = "/append", method = RequestMethod.POST)
    public String appendMenuAndRoleAndPermission(RedirectAttributes message) {
        MenuURLLoad menuLoad = new MenuURLLoad(
                Arrays.asList("com.zhulin.bus.controller", "com.zhulin.sys.controller"), ClassMenuURL.class);
        SystemPermissionConfigPreload configPreload = new SystemPermissionConfigPreload(
                Arrays.asList("com.zhulin.bus.service", "com.zhulin.sys.service"), MethodRolePermission.class, ClassRolePermission.class);

        boolean isMenuAppendSuccess = false;

        try {
            List<Menu> menus = menuLoad.scanAnnotationMenus();
            List<ClassRole> roles = configPreload.scanAnnotationClasses();

            isMenuAppendSuccess = menuService.appendSystemMenuAndRoleAndPermission(menus, roles);
        } catch (IOException e) {
            // TODO
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO
            e.printStackTrace();
        }

        if (isMenuAppendSuccess) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "系统菜单和角色和权限追加成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "系统菜单和角色和权限追加失败");
        }

        return "redirect:/admin/data";
    }
}

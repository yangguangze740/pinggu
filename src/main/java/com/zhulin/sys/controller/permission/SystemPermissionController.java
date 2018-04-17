package com.zhulin.sys.controller.permission;

import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.pojo.SystemPermission;
import com.zhulin.sys.service.permission.SystemPermissionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/admin/permission")
@ClassMenuURL(value = "/admin/permission", group = "system", name = "系统权限管理", groupName = "系统配置")
public class SystemPermissionController {

    @Autowired
    private SystemPermissionServiceI permissionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        List<SystemPermission> permissions = permissionService.readAllPermissions();

        model.addAttribute("permissions", permissions);

        return "sys/permission/index";
    }
}

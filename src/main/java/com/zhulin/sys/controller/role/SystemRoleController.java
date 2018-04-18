package com.zhulin.sys.controller.role;

import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.common.def.Constants;
import com.zhulin.sys.pojo.Menu;
import com.zhulin.sys.pojo.SystemPermission;
import com.zhulin.sys.pojo.SystemRole;
import com.zhulin.sys.service.menu.SystemMenuServiceI;
import com.zhulin.sys.service.permission.SystemPermissionServiceI;
import com.zhulin.sys.service.role.SystemRoleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/role")
@ClassMenuURL(value = "/admin/role", group = "system", name = "系统角色配置", groupName = "系统配置")
public class SystemRoleController {

    @Autowired
    private SystemRoleServiceI roleService;
    @Autowired
    private SystemMenuServiceI menuService;
    @Autowired
    private SystemPermissionServiceI permissionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(SystemRole role, HttpServletRequest request, Model model) {
        List<SystemRole> roles = roleService.appReadList(role);

        model.addAttribute("roles", roles);

        return "sys/role/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String routeAdd(Model model) {
        Map<String, List<Menu>> menusMap = menuService.readListGroupByParent();
        Map<String, List<SystemPermission>> groupPermissions = permissionService.readAllListGroupByGroupName();

        model.addAttribute("menusMap", menusMap);
        model.addAttribute("groupPermissions", groupPermissions);

        return "sys/role/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAdd(SystemRole role, RedirectAttributes message) {
        boolean isAddSuccess = roleService.createNewRole(role);

        if (isAddSuccess) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加系统角色成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加系统角色失败");
        }

        return "redirect:/admin/role";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id, RedirectAttributes message) {
        boolean isDeleteSuccess = roleService.deleteRole(id);

        if (isDeleteSuccess) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除系统角色成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除系统角色失败");
        }

        return "redirect:/admin/role";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String routeEdit(@PathVariable String id, Model model) {
        // 1. 查询角色信息
        SystemRole role = roleService.readDetail(id);
        // 2. 查询角色已有菜单信息
        List<Menu> menus = menuService.readRoleMenuList(id);
        // 3. 查询角色已有权限信息
        List<SystemPermission> permissions = permissionService.readRolePermissionList(id);

        model.addAttribute("role", role);
        model.addAttribute("menus", menus);
        model.addAttribute("permissions", permissions);

        Map<String, List<Menu>> menusMap = menuService.readListGroupByParent();
        Map<String, List<SystemPermission>> groupPermissions = permissionService.readAllListGroupByGroupName();

        model.addAttribute("menusMap", menusMap);
        model.addAttribute("groupPermissions", groupPermissions);

        return "sys/role/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateEdit(SystemRole role, RedirectAttributes message) {

        if (role.getPermissionIds().isEmpty() || role.getMenuIds().isEmpty()) {

            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑系统角色失败,请选择新的菜单和角色");

            return "redirect:/admin/role";
        }

        boolean isUpdateSuccess = roleService.update(role);

        if (isUpdateSuccess) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑系统角色成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑系统角色失败");
        }

        return "redirect:/admin/role";
    }
}

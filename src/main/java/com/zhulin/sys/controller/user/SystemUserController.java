package com.zhulin.sys.controller.user;

import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.common.def.Constants;
import com.zhulin.sys.pojo.SystemRole;
import com.zhulin.sys.pojo.SystemUser;
import com.zhulin.sys.service.role.SystemRoleServiceI;
import com.zhulin.sys.service.user.SystemUserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
@ClassMenuURL(value = "/admin/user", group = "system", name = "系统用户管理", groupName = "系统配置")
public class SystemUserController {

    @Autowired
    private SystemUserServiceI systemUserService;
    @Autowired
    private SystemRoleServiceI systemRoleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        List<SystemUser> users = systemUserService.readList();

        model.addAttribute("users", users);

        return "sys/user/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String routeAdd(Model model) {
        List<SystemRole> roles = systemRoleService.appReadList(null);

        model.addAttribute("roles", roles);

        return "sys/user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAdd(SystemUser user, RedirectAttributes message) {
        boolean isAddSuccess = systemUserService.createNewUser(user);

        if (isAddSuccess) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加后台用户成功");
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加后台用户失败");
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
        }

        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String routeEdit(@PathVariable String id, Model model) {
        SystemUser detailUser = systemUserService.readUserDetail(id);
        List<SystemRole> roles = systemRoleService.appReadList(null);

        model.addAttribute("user", detailUser);
        model.addAttribute("roles", roles);

        return "sys/user/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEdit(SystemUser user, RedirectAttributes message) {

        boolean isUpdateSuccess = systemUserService.update(user);

        if (isUpdateSuccess) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑系统用户成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑系统用户失败");
        }

        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, RedirectAttributes message) {
        boolean isDeleteSuccess = systemUserService.delete(id);

        if (isDeleteSuccess) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除系统用户成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除系统用户失败");
        }

        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/{id}/role", method = RequestMethod.GET)
    public String routeEditRole(@PathVariable String id, Model model) {
        SystemUser user = systemUserService.readUserDetail(id);
        List<SystemRole> roles = systemRoleService.appReadList(null);

        model.addAttribute("user", user);
        model.addAttribute("roles", roles);

        return "sys/user/editRole";
    }

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public String saveEditRole(SystemUser user, RedirectAttributes message) {
        boolean isEditRoleSuccess = systemUserService.updateUserRoles(user);

        if (isEditRoleSuccess) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑系统用户角色成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑系统用户角色失败");
        }

        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/{id}/pass", method = RequestMethod.GET)
    public String routeEditPass(@PathVariable String id, Model model) {
        SystemUser user = systemUserService.readUserDetail(id);

        model.addAttribute("user", user);

        return "sys/user/editPass";
    }

    @RequestMapping(value = "/pass", method = RequestMethod.POST)
    public String saveEditPass(SystemUser user, RedirectAttributes message) {

        String password = user.getPassword();
        String repass = user.getRepassword();

        if (!password.equals(repass)) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "两次密码不一致");
        }

        boolean isEditPassSuccess = systemUserService.updateUserPass(user);

        if (isEditPassSuccess) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑系统用户密码成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑系统用户密码失败");
        }

        return "redirect:/admin/user";
    }
}

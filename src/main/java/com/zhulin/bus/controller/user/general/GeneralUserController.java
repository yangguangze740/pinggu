package com.zhulin.bus.controller.user.general;

import com.zhulin.bus.bean.Department;
import com.zhulin.bus.bean.User;
import com.zhulin.bus.service.department.DepartmentServiceI;
import com.zhulin.bus.service.user.general.GeneralUserServiceI;
import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.common.def.Constants;
import com.zhulin.framework.controller.ArcController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/user/general")
@ClassMenuURL(value = "/admin/user/general", group = "frontUser", name = "普通用户管理", groupName = "前台用户")
public class GeneralUserController extends ArcController<User>{
    @Autowired
    private GeneralUserServiceI userService;

    @Autowired
    private DepartmentServiceI departmentService;

    @RequestMapping(value = "" , method = RequestMethod.GET )
    @Override
    public String list(User user, HttpServletRequest request, Model model) {
        List<User> users = userService.appReadList(user);
        model.addAttribute("users",users);

        return "bus/user/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @Override
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {

        User user = userService.appReadDetail(id);
        List<Department> departments = departmentService.appReadList(new Department());

        model.addAttribute("user",user);
        model.addAttribute("departments",departments);

        return "bus/user/edit";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST )
    @Override
    public String update(User user, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isUpadate = userService.appUpdate(user);
        if(isUpadate){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改普通用户信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改普通用户信息失败");
        }
        return "redirect:/admin/user/general";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @Override
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = userService.appDelete(id);
        if(isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除普通用户信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除普通用户信息失败");
        }
        return "redirect:/admin/user/general";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @Override
    public String routeAdd(HttpServletRequest request, Model model) {

        List<Department> departments = departmentService.appReadList(new Department());

        model.addAttribute("departments",departments);
        return "bus/user/add";
    }

    @RequestMapping(value ="/add",method = RequestMethod.POST)
    @Override
    public String saveAdd(User user, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isAdded = userService.appCreate(user);
        if(isAdded){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加普通用户信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加普通用户信息失败");
        }
        return "redirect:/admin/user/general";
    }
}

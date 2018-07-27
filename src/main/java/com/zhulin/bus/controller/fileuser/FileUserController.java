package com.zhulin.bus.controller.fileuser;

import com.zhulin.bus.bean.Department;
import com.zhulin.bus.bean.FileUser;
import com.zhulin.bus.bean.Type;
import com.zhulin.bus.service.department.DepartmentServiceI;
import com.zhulin.bus.service.fileuser.FileUserServiceI;
import com.zhulin.bus.service.type.TypeServiceI;
import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.common.def.Constants;
import com.zhulin.framework.controller.ArcController;
import com.zhulin.sys.pojo.SystemUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/file/user")
@ClassMenuURL(value = "/admin/file/user", group = "fileuser", name = "文件阅览用户管理", groupName = "系统配置管理")
public class FileUserController extends ArcController<FileUser>{

    @Resource
    private FileUserServiceI fileUserService;
    @Resource
    private DepartmentServiceI departmentService;
    @Resource
    private TypeServiceI typeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public String list(FileUser fileUser, HttpServletRequest request, Model model) {

        List<FileUser> fileUsers = fileUserService.appReadList(fileUser);

        model.addAttribute("fileUsers",fileUsers);
        return "bus/fileUser/index";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    @Override
    public String detail(@PathVariable String id, HttpServletRequest request, Model model) {

        FileUser fileUser = fileUserService.appReadDetail(id);
        List<Department> haveDepartments = departmentService.readHaveDepartments(id);
        List<Department> haveSupportDepartments = departmentService.readHaveSupportDepartments(id);
        List<Type> haveTypes = departmentService.readHaveTypes(id);

        model.addAttribute("fileUser", fileUser);
        model.addAttribute("haveDepartments", haveDepartments);
        model.addAttribute("haveSupportDepartments",haveSupportDepartments);
        model.addAttribute("haveTypes",haveTypes);

        return "bus/fileUser/detail";
    }

    @Override
    public String query4Edit(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String update(FileUser fileUser, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @Override
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = fileUserService.appDelete(id);
        if(isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除用户信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除用户信息失败");
        }
        return "redirect:/admin/file/user";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @Override
    public String routeAdd(HttpServletRequest request, Model model) {

        List<Department> departments = departmentService.appReadList(new Department());
        List<Type> types = typeService.appReadList(new Type());

        model.addAttribute("departments", departments);
        model.addAttribute("types", types);
        return "bus/fileUser/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public String saveAdd(FileUser fileUser, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user = (SystemUser) request.getSession().getAttribute(Constants.LOGIN_USER);

        fileUser.setCreateUserId(user.getUserId());

        if (fileUser.getTypeIds() == null || fileUser.getTypeIds().isEmpty()){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加用户失败");

            return "redirect:/admin/file/user";
        }

        if (fileUser.getSupportDepartmentIds() == null || fileUser.getSupportDepartmentIds().isEmpty()){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加用户失败");

            return "redirect:/admin/file/user";
        }

        if (fileUser.getDepartmentIds() == null || fileUser.getDepartmentIds().isEmpty()){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加用户失败");

            return "redirect:/admin/file/user";
        }

        boolean isAdded = fileUserService.appCreate(fileUser);

        if (isAdded) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加用户信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加用户信息失败");
        }

        return "redirect:/admin/file/user";
    }
}

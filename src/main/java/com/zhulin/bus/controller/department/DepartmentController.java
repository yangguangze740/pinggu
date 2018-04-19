package com.zhulin.bus.controller.department;

import com.zhulin.bus.bean.Department;
import com.zhulin.bus.bean.Type;
import com.zhulin.bus.service.department.DepartmentServiceI;
import com.zhulin.bus.service.type.TypeServiceI;
import com.zhulin.common.def.Constants;
import com.zhulin.framework.controller.ArcController;
import com.zhulin.sys.pojo.SystemUser;
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
@RequestMapping("/admin/department")
public class DepartmentController extends ArcController<Department>{

    @Autowired
    private DepartmentServiceI departmentServiceI;

    @Autowired
    private TypeServiceI typeServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Department department, HttpServletRequest request, Model model) {
        List<Department> departments = departmentServiceI.appReadList(department);

        model.addAttribute("departments", departments);

        return "bus/department/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {
        List<Type> types = typeServiceI.appReadList(new Type());

        Department department = departmentServiceI.appReadDetail(id);

        List<Type> haveTypes = typeServiceI.readHaveTypes(id);

        model.addAttribute("types", types);
        model.addAttribute("department", department);
        model.addAttribute("haveTypes", haveTypes);

        return "bus/department/edit";
    }

    @Override
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(Department department, HttpServletRequest request, Model model, RedirectAttributes message) {
        if (department.getTypeIds().isEmpty()) {

            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑部门失败,请选择新的部门类别");

            return "redirect:/admin/department";
        }

        boolean isEdit = departmentServiceI.appUpdate(department);

        if (isEdit) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑部门成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑部门失败");
        }

        return "redirect:/admin/department";
    }

    @Override
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = departmentServiceI.appDelete(id);

        if (isDelete) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除部门成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除部门失败");
        }

        return "redirect:/admin/department";
    }

    @Override
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String routeAdd(HttpServletRequest request, Model model) {
        List<Type> types = typeServiceI.appReadList(new Type());

        model.addAttribute("types", types);

        return "bus/department/add";
    }

    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String saveAdd(Department department, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user = (SystemUser)request.getSession().getAttribute(Constants.LOGIN_USER);
        department.setAdminId(user.getUserId());
        boolean isAdd = departmentServiceI.appCreate(department);

        if (isAdd) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加部门成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加部门失败");
        }

        return "redirect:/admin/department";
    }
}

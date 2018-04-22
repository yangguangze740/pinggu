package com.zhulin.bus.controller.department;

import com.zhulin.bus.bean.Department;
import com.zhulin.bus.bean.Problem;
import com.zhulin.bus.bean.Type;
import com.zhulin.bus.service.department.DepartmentServiceI;
import com.zhulin.bus.service.problem.ProblemServiceI;
import com.zhulin.bus.service.type.TypeServiceI;
import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.common.def.Constants;
import com.zhulin.framework.controller.ArcController;
import com.zhulin.sys.pojo.SystemUser;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/department")
@ClassMenuURL(value = "/admin/department", group = "problem", name = "部门管理", groupName = "评审问题")
public class DepartmentController extends ArcController<Department>{

    @Autowired
    private DepartmentServiceI departmentServiceI;

    @Autowired
    private TypeServiceI typeServiceI;

    @Autowired
    private ProblemServiceI problemServiceI;

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
        List<String> typeList = department.getTypeIds();

        if (typeList==null || typeList.isEmpty()) {
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

    @RequestMapping(value = "editPro/{id}", method = RequestMethod.GET)
    public String route2EditPro(@PathVariable String id, HttpServletRequest request, Model model){
        List<Problem> haveProblems = problemServiceI.readDepartmentProblem(id);
        List<Problem> problems = problemServiceI.appReadList(new Problem());
        Department department = departmentServiceI.appReadDetail(id);

        model.addAttribute("haveProblems", haveProblems);
        model.addAttribute("problems", problems);
        model.addAttribute("department", department);

        return "bus/department/editPro";
    }

    @RequestMapping(value = "editPro", method = RequestMethod.POST)
    public String updatePro(Department department, HttpServletRequest request, Model model, RedirectAttributes message){
        List<String> list = department.getProblemIds();

        if (list==null || list.isEmpty()) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑问题失败,请选择新的问题");

            return "redirect:/admin/department";
        }

        boolean isEdit = departmentServiceI.updateProblem(department);

        if (isEdit) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑部门问题成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑部门问题失败");
        }

        return "redirect:/admin/department";
    }
}

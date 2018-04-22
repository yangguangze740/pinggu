package com.zhulin.bus.controller.dutyDepartment;

import com.zhulin.bus.bean.DutyDepartment;
import com.zhulin.bus.service.DutyDepartment.DutyDepartmentServiceI;
import com.zhulin.common.annotation.menu.ClassMenuURL;
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
@RequestMapping("/admin/department/duty")
@ClassMenuURL(value = "/admin/department/duty", group = "supportFile", name = "责任部门管理", groupName = "支撑文件")
public class DutyDepartmentController extends ArcController<DutyDepartment> {

    @Autowired
    private DutyDepartmentServiceI dutyDepartmentService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    @Override
    public String list(DutyDepartment dutyDepartment, HttpServletRequest request, Model model) {

        List<DutyDepartment> dutyDepartments = dutyDepartmentService.appReadList(dutyDepartment);
        model.addAttribute("dutyDepartments",dutyDepartments);

        return "bus/dutyDepartment/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    @Override
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {

        DutyDepartment dutyDepartment = dutyDepartmentService.appReadDetail(id);
        model.addAttribute("dutyDepartment",dutyDepartment);

        return "bus/dutyDepartment/edit";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @Override
    public String update(DutyDepartment dutyDepartment, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isUpadate = dutyDepartmentService.appUpdate(dutyDepartment);
        if(isUpadate){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改责任部门信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改责任部门信息失败");
        }
        return "redirect:/admin/department/duty";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @Override
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = dutyDepartmentService.appDelete(id);
        if(isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除责任部门信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除责任部门信息失败");
        }
        return "redirect:/admin/department/duty";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @Override
    public String routeAdd(HttpServletRequest request, Model model) {
        return "bus/dutyDepartment/add";
    }

    @RequestMapping(value ="/add",method = RequestMethod.POST)
    @Override
    public String saveAdd(DutyDepartment dutyDepartment, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user = (SystemUser)request.getSession().getAttribute(Constants.LOGIN_USER);
        dutyDepartment.setAdminId(user.getUserId());

        boolean isAdded = dutyDepartmentService.appCreate(dutyDepartment);
        if(isAdded){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加责任部门信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加责任部门信息失败");
        }
        return "redirect:/admin/department/duty";
    }
}

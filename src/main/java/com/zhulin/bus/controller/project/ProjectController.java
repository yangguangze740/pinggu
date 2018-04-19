package com.zhulin.bus.controller.project;

import com.zhulin.bus.bean.Project;
import com.zhulin.bus.service.project.ProjectServiceI;
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

@RequestMapping("/admin/project")
@Controller
public class ProjectController extends ArcController<Project>{

    @Autowired
    private ProjectServiceI projectService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    @Override
    public String list(Project project, HttpServletRequest request, Model model) {

        List<Project> projects = projectService.appReadList(project);
        model.addAttribute("projects",projects);

        return "bus/project/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    @Override
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {

        Project project = projectService.appReadDetail(id);
        model.addAttribute("project",project);

        return "bus/project/edit";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @Override
    public String update(Project project, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isUpadate = projectService.appUpdate(project);
        if(isUpadate){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改审核项目信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改审核项目信息失败");
        }
        return "redirect:/admin/project";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @Override
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = projectService.appDelete(id);
        if(isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除审核项目信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除审核项目信息失败");
        }
        return "redirect:/admin/project";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @Override
    public String routeAdd(HttpServletRequest request, Model model) {
        return "bus/project/add";
    }

    @RequestMapping(value ="/add",method = RequestMethod.POST)
    @Override
    public String saveAdd(Project project, HttpServletRequest request, Model model, RedirectAttributes message) {

        SystemUser user = (SystemUser)request.getSession().getAttribute(Constants.LOGIN_USER);
        project.setAdminId(user.getUserId());

        boolean isAdded = projectService.appCreate(project);
        if(isAdded){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加审核项目信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加审核项目信息失败");
        }
        return "redirect:/admin/project";
    }
}

package com.zhulin.bus.controller.point;

import com.zhulin.bus.bean.*;
import com.zhulin.bus.service.DutyDepartment.DutyDepartmentServiceI;
import com.zhulin.bus.service.element.ElementServiceI;
import com.zhulin.bus.service.lead.LeadServiceI;
import com.zhulin.bus.service.point.PointServiceI;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin/point")
public class PointController extends ArcController<Point>{

    @Autowired
    private PointServiceI pointService;

    @Autowired
    private ElementServiceI elementService;

    @Autowired
    private DutyDepartmentServiceI dutyDepartmentService;

    @Autowired
    private ProjectServiceI projectService;

    @Autowired
    private LeadServiceI leadService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public String list(Point point, HttpServletRequest request, Model model) {

        List<Point> points = pointService.appReadList(point);
        model.addAttribute("points",points);

        return "bus/point/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @Override
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {

        List<DutyDepartment> dutyDepartments = dutyDepartmentService.appReadList(new DutyDepartment());
        List<Lead> leads = leadService.appReadList(new Lead());
        List<Project> projects = projectService.appReadList(new Project());
        List<DutyDepartment> haveDutyDepartments = dutyDepartmentService.haveDutyDepartments(id);
        Point point = pointService.appReadDetail(id);

        String projectId = point.getProjectId();
        List<Element> elements = elementService.appReadProjectElements(projectId);

        model.addAttribute("dutyDepartments", dutyDepartments);
        model.addAttribute("leads", leads);
        model.addAttribute("point", point);
        model.addAttribute("projects", projects);
        model.addAttribute("haveDutyDepartments", haveDutyDepartments);
        model.addAttribute("elements", elements);

        return "bus/point/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @Override
    public String update(Point point, HttpServletRequest request, Model model, RedirectAttributes message) {

        boolean isUpadate = pointService.appUpdate(point);
        if(isUpadate){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改审核要点信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改审核要点信息失败");
        }
        return "redirect:/admin/point";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @Override
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = pointService.appDelete(id);

        if(isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除审核要点信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除审核要点信息失败");
        }
        return "redirect:/admin/point";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @Override
    public String routeAdd(HttpServletRequest request, Model model) {

        List<Element> elements = elementService.appReadList(new Element());
        List<DutyDepartment> dutyDepartments = dutyDepartmentService.appReadList(new DutyDepartment());
        List<Lead> leads = leadService.appReadList(new Lead());
        List<Project>projects = projectService.appReadList(new Project());

        model.addAttribute("elements",elements);
        model.addAttribute("dutyDepartments",dutyDepartments);
        model.addAttribute("leads",leads);
        model.addAttribute("projects",projects);

        return "bus/point/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public String saveAdd(Point point, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user = (SystemUser)request.getSession().getAttribute(Constants.LOGIN_USER);
        point.setAdminId(user.getUserId());

        boolean isAdded = pointService.appCreate(point);
        if(isAdded){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加审核要点信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加审核要点信息失败");
        }
        return "redirect:/admin/point";
    }

    @ResponseBody
    @RequestMapping(value = "/element",method = RequestMethod.GET )
    public Map<String,List<Element>> routeAdd(Project project) {
        Map<String,List<Element>> map = new HashMap<>();

        List<Element> elements = pointService.queryElementByProjectId(project.getProjectId());

        map.put("elements", elements);

        return map;
    }
}

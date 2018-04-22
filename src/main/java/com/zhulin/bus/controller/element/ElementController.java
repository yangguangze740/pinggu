package com.zhulin.bus.controller.element;


import com.zhulin.bus.bean.Element;
import com.zhulin.bus.bean.Point;
import com.zhulin.bus.bean.Project;
import com.zhulin.bus.service.element.ElementServiceI;
import com.zhulin.bus.service.project.ProjectServiceI;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/element")
@ClassMenuURL(value = "/admin/point", group = "supportFile", name = "审核要素管理", groupName = "支撑文件")
public class ElementController extends ArcController<Element>{

    @Autowired
    private ElementServiceI elementService;

    @Autowired
    private ProjectServiceI projectService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    @Override
    public String list(Element element, HttpServletRequest request, Model model) {

        List<Element> elements = elementService.appReadList(element);
        model.addAttribute("elements",elements);

        return "bus/element/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    @Override
    public String query4Edit(@PathVariable String id,HttpServletRequest request, Model model) {

        List<Project> projects = projectService.appReadList(new Project());
        Element element = elementService.appReadDetail(id);

        model.addAttribute("element",element);
        model.addAttribute("projects",projects);

        return "bus/element/edit";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @Override
    public String update(Element element, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isUpadate = elementService.appUpdate(element);
        if(isUpadate){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改审核要素信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改审核要素信息失败");
        }
        return "redirect:/admin/element";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @Override
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = elementService.appDelete(id);
        if(isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除审核要素信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除审核要素信息失败");
        }
        return "redirect:/admin/element";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @Override
    public String routeAdd(HttpServletRequest request, Model model) {
        List<Project> projects = projectService.appReadList(new Project());

        model.addAttribute("projects",projects);
        return "bus/element/add";
    }

    @RequestMapping(value ="/add",method = RequestMethod.POST)
    @Override
    public String saveAdd(Element element, HttpServletRequest request, Model model, RedirectAttributes message) {

        SystemUser user = (SystemUser)request.getSession().getAttribute(Constants.LOGIN_USER);
        element.setAdminId(user.getUserId());

        boolean isAdded = elementService.appCreate(element);
        if(isAdded){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加审核要素信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加审核要素信息失败");
        }
        return "redirect:/admin/element";
    }

    @ResponseBody
    @RequestMapping(value = "/points",method = RequestMethod.GET )
    public Map<String,List<Point>> routeAdd(Element element) {
        Map<String, List<Point>> map = new HashMap<>();

        List<Point> points = elementService.queryPointByElementId(element.getElementId());

        map.put("points",points);

        return map;
    }
}

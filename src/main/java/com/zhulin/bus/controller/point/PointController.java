package com.zhulin.bus.controller.point;

import com.zhulin.bus.bean.Point;
import com.zhulin.bus.service.DutyDepartment.DutyDepartmentServiceI;
import com.zhulin.bus.service.element.ElementServiceI;
import com.zhulin.bus.service.point.PointServiceI;
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
public class PointController extends ArcController<Point>{

    @Autowired
    private PointServiceI pointService;

    @Autowired
    private ElementServiceI elementService;

    @Autowired
    private DutyDepartmentServiceI dutyDepartmentService;



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
        return null;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @Override
    public String update(Point point, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @Override
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @Override
    public String routeAdd(HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public String saveAdd(Point point, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }
}

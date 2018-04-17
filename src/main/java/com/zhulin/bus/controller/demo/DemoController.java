package com.zhulin.bus.controller.demo;

import com.zhulin.bus.bean.Demo;
import com.zhulin.bus.service.demo.DemoServiceI;
import com.zhulin.framework.controller.ArcController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/demo")
public class DemoController extends ArcController<Demo> {

    @Autowired
    private DemoServiceI demoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public String list(Demo demo, HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public String detail(@PathVariable String id, HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @Override
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @Override
    public String update(Demo demo, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @Override
    public String delete(String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @Override
    public String routeAdd(HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public String saveAdd(Demo demo, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }
}

package com.zhulin.bus.controller.log;

import com.zhulin.bus.bean.Log;
import com.zhulin.bus.service.log.LogServiceI;
import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.framework.controller.ArcController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/log")
@ClassMenuURL(value = "/admin/log", group = "config", name = "日志", groupName = "系统配置")
public class LogController extends ArcController<Log>{

    @Autowired
    private LogServiceI logServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Log log, HttpServletRequest request, Model model) {
        List<Log> logs = logServiceI.appReadList(log);

        model.addAttribute("logs", logs);

        return "bus/log/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String query4Edit(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String update(Log log, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @Override
    public String delete(String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @Override
    public String routeAdd(HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String saveAdd(Log log, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }
}

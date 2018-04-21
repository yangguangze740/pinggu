package com.zhulin.bus.controller.file.support;

import com.zhulin.bus.bean.SupportFile;
import com.zhulin.bus.service.department.DepartmentServiceI;
import com.zhulin.bus.service.file.support.SupportFileServiceI;
import com.zhulin.bus.service.user.general.GeneralUserServiceI;
import com.zhulin.framework.controller.ArcController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/supportFile")
public class SupportFileController extends ArcController<SupportFile>{

    @Autowired
    private SupportFileServiceI supportFileServiceI;

    @Autowired
    private DepartmentServiceI departmentServiceI;

    @Autowired
    private GeneralUserServiceI generalUserServiceI;


    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(SupportFile supportFile, HttpServletRequest request, Model model) {
        return null;
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
    public String update(SupportFile supportFile, HttpServletRequest request, Model model, RedirectAttributes message) {
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
    public String saveAdd(SupportFile supportFile, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }
}

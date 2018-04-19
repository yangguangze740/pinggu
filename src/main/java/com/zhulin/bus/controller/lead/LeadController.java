package com.zhulin.bus.controller.lead;

import com.zhulin.bus.bean.Lead;
import com.zhulin.bus.service.lead.LeadServiceI;
import com.zhulin.common.def.Constants;
import com.zhulin.framework.controller.ArcController;
import com.zhulin.sys.pojo.SystemUser;
import org.apache.ibatis.annotations.Result;
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
@RequestMapping("/admin/lead")
public class LeadController extends ArcController<Lead>{

    @Autowired
    private LeadServiceI leadServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Lead lead, HttpServletRequest request, Model model) {
        List<Lead> leads = leadServiceI.appReadList(lead);

        model.addAttribute("leads", leads);

        return "bus/lead/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {
        Lead lead = leadServiceI.appReadDetail(id);

        model.addAttribute("lead", lead);

        return "bus/lead/edit";
    }

    @Override
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(Lead lead, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isEdit = leadServiceI.appUpdate(lead);

        if (isEdit){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑牵头单位成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑牵头单位失败");
        }

        return "redirect:/admin/lead";
    }

    @Override
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = leadServiceI.appDelete(id);

        if (isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除牵头单位成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除牵头单位失败");
        }

        return "redirect:/admin/lead";
    }

    @Override
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String routeAdd(HttpServletRequest request, Model model) {
        return "bus/lead/add";
    }

    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String saveAdd(Lead lead, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user =(SystemUser) request.getSession().getAttribute(Constants.LOGIN_USER);
        lead.setAdminId(user.getUserId());

        boolean isAdd = leadServiceI.appCreate(lead);

        if (isAdd){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加牵头单位成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加牵头单位失败");
        }

        return "redirect:/admin/lead";
    }
}

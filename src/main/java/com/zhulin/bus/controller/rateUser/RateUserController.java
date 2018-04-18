package com.zhulin.bus.controller.rateUser;

import com.zhulin.bus.bean.RateUser;
import com.zhulin.bus.service.rateUser.RateUserServiceI;
import com.zhulin.common.def.Constants;
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
@RequestMapping("/admin/rateUser")
public class RateUserController extends ArcController<RateUser> {
    @Autowired
    private RateUserServiceI rateUserService;

    @RequestMapping(value = "" , method = RequestMethod.GET )
    @Override
    public String list(RateUser rateUser, HttpServletRequest request, Model model) {
        List<RateUser> rateUsers = rateUserService.appReadList(rateUser);
        model.addAttribute("rateUsers",rateUsers);

        return "bus/rateUser/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @Override
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {
        RateUser rateUser = rateUserService.appReadDetail(id);
        model.addAttribute("rateUser",rateUser);

        return "bus/rateUser/edit";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST )
    @Override
    public String update(RateUser rateUser, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isUpadate = rateUserService.appUpdate(rateUser);
        if(isUpadate){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改评审用户信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改评审用户信息失败");
        }
        return "redirect:/admin/rateUser";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @Override
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = rateUserService.appDelete(id);
        if(isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除评审用户信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除评审用户信息失败");
        }
        return "redirect:/admin/rateUser";

    }


    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @Override
    public String routeAdd(HttpServletRequest request, Model model) {
        return "bus/rateUser/add";
    }

    @RequestMapping(value ="/add",method = RequestMethod.POST)
    @Override
    public String saveAdd(RateUser rateUser, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isAdded = rateUserService.appCreate(rateUser);
        if(isAdded){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加评审用户信息成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "增加评审用户信息失败");
        }
        return "redirect:/admin/rateUser";
    }
}

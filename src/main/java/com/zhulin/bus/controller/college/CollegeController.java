package com.zhulin.bus.controller.college;

import com.zhulin.bus.bean.College;
import com.zhulin.bus.service.college.CollegeServiceI;
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
@RequestMapping("/admin/college")
public class CollegeController extends ArcController<College>{

    @Autowired
    private CollegeServiceI collegeServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(College college, HttpServletRequest request, Model model) {
        List<College> colleges = collegeServiceI.appReadList(college);

        model.addAttribute("colleges", colleges);

        return "/bus/college/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {
        College college = collegeServiceI.appReadDetail(id);

        model.addAttribute("college", college);

        return "/bus/college/edit";
    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String update(College college, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isEdit = collegeServiceI.appUpdate(college);

        if (isEdit){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑学院成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑学院失败");
        }

        return "redirect:/admin/college";
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = collegeServiceI.appDelete(id);

        if (isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除学院成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除学院失败");
        }

        return "redirect:/admin/college";
    }

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String routeAdd(HttpServletRequest request, Model model) {
        return "/bus/college/add";
    }

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAdd(College college, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user =(SystemUser) request.getSession().getAttribute(Constants.LOGIN_USER);
        college.setCreateUserId(user.getUserId());

        boolean isAdd = collegeServiceI.appCreate(college);

        if (isAdd){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加学院成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加学院失败");
        }

        return "redirect:/admin/college";
    }
}

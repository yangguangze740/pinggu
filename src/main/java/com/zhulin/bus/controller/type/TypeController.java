package com.zhulin.bus.controller.type;

import com.zhulin.bus.bean.Type;
import com.zhulin.bus.service.type.TypeServiceI;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/type")
@ClassMenuURL(value = "/admin/type", group = "problem", name = "类型管理", groupName = "评审问题")
public class TypeController extends ArcController<Type>{

    @Autowired
    private TypeServiceI typeServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Type type, HttpServletRequest request, Model model) {
        List<Type> types = typeServiceI.appReadList(type);

        model.addAttribute("types", types);

        return "bus/type/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {
        Type type = typeServiceI.appReadDetail(id);

        model.addAttribute("type", type);

        return "bus/type/edit";
    }

    @Override
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(Type type, HttpServletRequest request, Model model, RedirectAttributes message) {
        if (typeServiceI.appUpdate(type)){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改部门类别成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改部门类别失败");
        }

        return "redirect:/admin/type";
    }

    @Override
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        if (typeServiceI.appDelete(id)){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除部门类别成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除部门类别失败");
        }

        return "redirect:/admin/type";
    }

    @Override
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String routeAdd(HttpServletRequest request, Model model) {
        return "bus/type/add";
    }

    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String saveAdd(Type type, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user =(SystemUser) request.getSession().getAttribute(Constants.LOGIN_USER);
        type.setAdminId(user.getUserId());

        if (typeServiceI.appCreate(type)){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加部门类别成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加部门类别失败");
        }

        return "redirect:/admin/type";
    }
}

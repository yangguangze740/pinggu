package com.zhulin.bus.controller.discipline;

import com.zhulin.bus.bean.College;
import com.zhulin.bus.bean.Discipline;
import com.zhulin.bus.service.college.CollegeServiceI;
import com.zhulin.bus.service.discipline.DisciplineServiceI;
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
@RequestMapping("/admin/discipline")
@ClassMenuURL(value = "/admin/discipline", group = "paperFile", name = "专业管理", groupName = "试卷文件管理")
public class DisciplineController extends ArcController<Discipline>{

    @Autowired
    private DisciplineServiceI disciplineServiceI;

    @Autowired
    private CollegeServiceI collegeServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Discipline discipline, HttpServletRequest request, Model model) {
        List<Discipline> disciplines = disciplineServiceI.appReadList(discipline);

        model.addAttribute("disciplines", disciplines);

        return "/bus/discipline/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {
        Discipline discipline = disciplineServiceI.appReadDetail(id);
        List<College> colleges = collegeServiceI.appReadList(new College());

        model.addAttribute("discipline", discipline);
        model.addAttribute("colleges", colleges);

        return "/bus/discipline/edit";
    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String update(Discipline discipline, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isEdit = disciplineServiceI.appUpdate(discipline);

        if (isEdit){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑专业成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑专业失败");
        }

        return "redirect:/admin/discipline";
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = disciplineServiceI.appDelete(id);

        if (isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除专业成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除专业失败");
        }

        return "redirect:/admin/discipline";
    }

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String routeAdd(HttpServletRequest request, Model model) {
        List<College> colleges = collegeServiceI.appReadList(new College());

        model.addAttribute("colleges", colleges);

        return "/bus/discipline/add";
    }

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAdd(Discipline discipline, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user =(SystemUser) request.getSession().getAttribute(Constants.LOGIN_USER);
        discipline.setCreateUserId(user.getUserId());

        boolean isAdd = disciplineServiceI.appCreate(discipline);

        if (isAdd){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加专业成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加专业失败");
        }

        return "redirect:/admin/discipline";
    }
}

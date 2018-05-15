package com.zhulin.bus.controller.paper;

import com.zhulin.bus.bean.College;
import com.zhulin.bus.bean.Discipline;
import com.zhulin.bus.bean.Paper;
import com.zhulin.bus.bean.Subject;
import com.zhulin.bus.service.college.CollegeServiceI;
import com.zhulin.bus.service.paper.PaperServiceI;
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
@RequestMapping("/admin/paper")
@ClassMenuURL(value = "/admin/paper", group = "paperFile", name = "试卷管理", groupName = "试卷文件管理")
public class PaperController extends ArcController<Paper>{

    @Autowired
    private PaperServiceI paperServiceI;

    @Autowired
    private CollegeServiceI collegeServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Paper paper, HttpServletRequest request, Model model) {
        List<Paper> papers = paperServiceI.appReadList(paper);

        model.addAttribute("papers", papers);

        return "bus/paper/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {
        List<College> colleges = collegeServiceI.appReadList(new College());
        Paper paper = paperServiceI.appReadDetail(id);

        model.addAttribute("colleges", colleges);
        model.addAttribute("paper", paper);

        return "bus/paper/edit";
    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String update(Paper paper, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isEdit = paperServiceI.appUpdate(paper);

        if (isEdit){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑试卷成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑试卷失败");
        }

        return "redirect:/admin/paper";
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = paperServiceI.appDelete(id);

        if (isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除试卷成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除试卷失败");
        }

        return "redirect:/admin/paper";
    }

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String routeAdd(HttpServletRequest request, Model model) {
        List<College> colleges = collegeServiceI.appReadList(new College());

        model.addAttribute("colleges", colleges);

        return "bus/paper/add";
    }

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAdd(Paper paper, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user =(SystemUser) request.getSession().getAttribute(Constants.LOGIN_USER);
        paper.setCreateUserId(user.getUserId());

        boolean isAdd = paperServiceI.appCreate(paper);

        if (isAdd){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加试卷成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加试卷失败");
        }

        return "redirect:/admin/paper";
    }

    @ResponseBody
    @RequestMapping(value = "/subject",method = RequestMethod.GET )
    public Map<String,List<Subject>> routeAdd(Discipline discipline) {
        Map<String,List<Subject>> map = new HashMap<>();

        List<Subject> subjects = paperServiceI.querySubjectByDisciplineId(discipline.getDisciplineId());

        map.put("subjects", subjects);

        return map;
    }
}

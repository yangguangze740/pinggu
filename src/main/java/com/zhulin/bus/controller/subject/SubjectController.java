package com.zhulin.bus.controller.subject;

import com.zhulin.bus.bean.College;
import com.zhulin.bus.bean.Discipline;
import com.zhulin.bus.bean.Subject;
import com.zhulin.bus.service.college.CollegeServiceI;
import com.zhulin.bus.service.discipline.DisciplineServiceI;
import com.zhulin.bus.service.subject.SubjectServiceI;
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
@RequestMapping("/admin/subject")
public class SubjectController extends ArcController<Subject>{

    @Autowired
    private SubjectServiceI subjectServiceI;

    @Autowired
    private CollegeServiceI collegeServiceI;

    @Autowired
    private DisciplineServiceI disciplineServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Subject subject, HttpServletRequest request, Model model) {
        List<Subject> subjects = subjectServiceI.appReadList(subject);

        model.addAttribute("subjects", subjects);

        return "/bus/subject/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {
        List<College> colleges = collegeServiceI.appReadList(new College());
        List<Discipline> disciplines = disciplineServiceI.appReadList(new Discipline());
        Subject subject = subjectServiceI.appReadDetail(id);

        model.addAttribute("colleges", colleges);
        model.addAttribute("disciplines", disciplines);
        model.addAttribute("subject", subject);

        return "bus/subject/edit";
    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String update(Subject subject, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isEdit = subjectServiceI.appUpdate(subject);

        if (isEdit){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑课程成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑课程失败");
        }

        return "redirect:/admin/subject";
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = subjectServiceI.appDelete(id);

        if (isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除课程成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除课程失败");
        }

        return "redirect:/admin/subject";
    }

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String routeAdd(HttpServletRequest request, Model model) {
        List<College> colleges = collegeServiceI.appReadList(new College());

        model.addAttribute("colleges", colleges);

        return "/bus/subject/add";
    }

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAdd(Subject subject, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user =(SystemUser) request.getSession().getAttribute(Constants.LOGIN_USER);
        subject.setCreateUserId(user.getUserId());

        boolean isAdd = subjectServiceI.appCreate(subject);

        if (isAdd){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加课程成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加课程失败");
        }

        return "redirect:/admin/subject";
    }

    @ResponseBody
    @RequestMapping(value = "/discipline",method = RequestMethod.GET )
    public Map<String,List<Discipline>> routeAdd(College college) {
        Map<String,List<Discipline>> map = new HashMap<>();

        List<Discipline> disciplines = subjectServiceI.queryDisciplineByCollegeId(college.getCollegeId());

        map.put("disciplines", disciplines);

        return map;
    }
}

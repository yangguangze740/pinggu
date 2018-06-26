package com.zhulin.bus.controller.bi.question;

import com.zhulin.bus.bean.Department;
import com.zhulin.bus.bean.Element;
import com.zhulin.bus.bean.Project;
import com.zhulin.bus.bean.Question;
import com.zhulin.bus.bean.bi.QuestionNumber;
import com.zhulin.bus.bean.bi.QuestionNumberBI;
import com.zhulin.bus.service.bi.question.QuestionBiServiceI;
import com.zhulin.bus.service.department.DepartmentServiceI;
import com.zhulin.bus.service.element.ElementServiceI;
import com.zhulin.bus.service.project.ProjectServiceI;
import com.zhulin.framework.controller.ArcController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/bi/question")
public class QuestionBiController extends ArcController<QuestionNumber> {

    @Resource
    private QuestionBiServiceI questionBiServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(QuestionNumber questionNumber, HttpServletRequest request, Model model) {
        return "bus/bi/question/index";
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
    public String update(QuestionNumber questionNumber, HttpServletRequest request, Model model, RedirectAttributes message) {
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
    public String saveAdd(QuestionNumber questionNumber, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/number", method = RequestMethod.GET)
    public Map<String, Object> queryData(QuestionNumber questionNumber, HttpServletRequest request) {
        Map<String, Object> map = questionBiServiceI.queryData(questionNumber);

        return map;
    }
}

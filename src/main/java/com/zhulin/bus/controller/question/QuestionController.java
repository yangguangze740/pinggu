package com.zhulin.bus.controller.question;

import com.zhulin.bus.bean.Question;
import com.zhulin.bus.service.question.QuestionI;
import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.common.def.Constants;
import com.zhulin.framework.controller.ArcController;
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
@RequestMapping("/admin/question")
@ClassMenuURL(value = "/admin/question", group = "frontUser", name = "问题清单管理", groupName = "前台用户")
public class QuestionController extends ArcController<Question>{

    @Autowired
    private QuestionI questionI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Question question, HttpServletRequest request, Model model) {
        List<Question> questions = questionI.appReadList(question);

        model.addAttribute("questions", questions);

        return "bus/question/index";
    }

    @Override
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable String id, HttpServletRequest request, Model model) {
        Question question = questionI.appReadDetail(id);

        model.addAttribute("question", question);

        return "bus/question/detail";
    }

    @Override
    public String query4Edit(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String update(Question question, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = questionI.appDelete(id);

        if (isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除问题成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除问题失败");
        }

        return "redirect:/admin/question";
    }

    @Override
    public String routeAdd(HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String saveAdd(Question question, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }
}

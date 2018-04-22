package com.zhulin.bus.controller.score;

import com.zhulin.bus.bean.Score;
import com.zhulin.bus.service.score.ScoreServiceI;
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
@RequestMapping("/admin/score")
@ClassMenuURL(value = "/admin/score", group = "problem", name = "分数管理", groupName = "评审问题")
public class ScoreController extends ArcController<Score>{

    @Autowired
    private ScoreServiceI scoreServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Score score, HttpServletRequest request, Model model) {
        List<Score> scores = scoreServiceI.appReadList(score);

        model.addAttribute("scores", scores);

        return "bus/score/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {
        Score score = scoreServiceI.appReadDetail(id);

        model.addAttribute("score", score);

        return "bus/score/edit";
    }

    @Override
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(Score score, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isEdit = scoreServiceI.appUpdate(score);

        if (isEdit){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑分数成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑分数失败");
        }

        return "redirect:/admin/score";
    }

    @Override
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = scoreServiceI.appDelete(id);

        if (isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除分数成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除分数失败");
        }

        return "redirect:/admin/score";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    @Override
    public String routeAdd(HttpServletRequest request, Model model) {
        return "bus/score/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @Override
    public String saveAdd(Score score, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isAdd = scoreServiceI.appCreate(score);

        if (isAdd){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加分数成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加分数失败");
        }

        return "redirect:/admin/score";
    }
}

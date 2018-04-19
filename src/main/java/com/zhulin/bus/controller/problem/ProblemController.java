package com.zhulin.bus.controller.problem;

import com.zhulin.bus.bean.Problem;
import com.zhulin.bus.service.problem.ProblemServiceI;
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
@RequestMapping("/admin/problem")
public class ProblemController extends ArcController<Problem>{

    @Autowired
    private ProblemServiceI problemServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Problem problem, HttpServletRequest request, Model model) {
        List<Problem> problems = problemServiceI.appReadList(problem);

        model.addAttribute("problems", problems);

        return "bus/problem/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String query4Edit(@PathVariable String id, HttpServletRequest request, Model model) {
        Problem problem = problemServiceI.appReadDetail(id);

        model.addAttribute("problem", problem);

        return "bus/problem/edit";
    }

    @Override
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(Problem problem, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isEdit = problemServiceI.appUpdate(problem);

        if (isEdit){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑问题成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑问题失败");
        }

        return "redirect:/admin/problem";
    }

    @Override
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isDelete = problemServiceI.appDelete(id);

        if (isDelete){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除问题成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除问题失败");
        }

        return "redirect:/admin/problem";
    }

    @Override
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String routeAdd(HttpServletRequest request, Model model) {
        return "bus/problem/add";
    }

    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String saveAdd(Problem problem, HttpServletRequest request, Model model, RedirectAttributes message) {
        SystemUser user =(SystemUser) request.getSession().getAttribute(Constants.LOGIN_USER);
        problem.setAdminId(user.getUserId());

        if (problemServiceI.appCreate(problem)){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加问题成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加问题失败");
        }

        return "redirect:/admin/problem";
    }
}

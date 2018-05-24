package com.zhulin.bus.controller.config;

import com.zhulin.bus.bean.BusConfig;
import com.zhulin.bus.service.config.ConfigServiceI;
import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.common.def.Constants;
import com.zhulin.framework.controller.ArcController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/config")
@ClassMenuURL(value = "/admin/config", group = "config", name = "系统配置", groupName = "系统配置")
public class ConfigController extends ArcController<BusConfig> {

    @Autowired
    private ConfigServiceI configServiceI;

    @Override
    public String list(BusConfig busConfig, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String query4Edit(String id, HttpServletRequest request, Model model) {
        BusConfig busConfig = configServiceI.readConfig();

        model.addAttribute("config", busConfig);

        return "bus/config/index";
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String update(BusConfig busConfig, HttpServletRequest request, Model model, RedirectAttributes message) {
        boolean isRightDate = busConfig.getConfigReviewEndDay().before(busConfig.getConfigReviewStartDay());

        if (isRightDate){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改失败，请确认结束时间大于修改时间");

            return "redirect:/admin/config";
        }

        boolean isUpdate = configServiceI.updateConfig(busConfig);

        if (isUpdate){
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改配置成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "修改配置失败");
        }

        return "redirect:/admin/config";
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
    public String saveAdd(BusConfig busConfig, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }
}

package com.zhulin.sys.controller.menu;

import com.google.common.base.Optional;
import com.zhulin.common.annotation.menu.ClassMenuURL;
import com.zhulin.common.def.Constants;
import com.zhulin.pojo.Menu;
import com.zhulin.sys.service.menu.SystemMenuServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/menu")
@ClassMenuURL(value = "/admin/menu", group = "system", name = "系统菜单配置", groupName = "系统配置")
public class SystemMenuController {

    @Autowired
    private SystemMenuServiceI menuService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        List<Menu> menus = menuService.readList();

        model.addAttribute("menus", menus);

        return "sys/menu/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String routeAdd(HttpServletRequest request, Model model) {
        Map<String, List<Menu>> menusMap = menuService.readNoParentMenus();

        model.addAttribute("menusMap", menusMap);

        return "sys/menu/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAdd(Menu menu, HttpServletRequest request, Model model, RedirectAttributes message) {
        if (menu.getChildMenuIds().size() <= 0) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "请选择父菜单的子菜单");
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);

            return "redirect:/admin/menu";
        }

        boolean isAddSuccess = menuService.createNewMenu(menu);

        if (isAddSuccess) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加系统父菜单成功");
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "添加系统父菜单失败");
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
        }

        return "redirect:/admin/menu";
    }

    @RequestMapping(value = "/{menuId}/icon", method = RequestMethod.GET)
    public String routeEditMenuIcon(@PathVariable String menuId, Model model) {
        Menu menu = menuService.readDetail(menuId);

        model.addAttribute("menu", menu);

        return "sys/menu/editIcon";
    }

    @RequestMapping(value = "/{menuId}/icon", method = RequestMethod.POST)
    public String saveMenuIcon(@PathVariable String menuId, Menu menu, RedirectAttributes message) {
        menu.setMenuId(menuId);

        boolean isEditSuccess = menuService.updateMenuIcon(menu);

        if (isEditSuccess) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑菜单图标成功");
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑菜单图标失败");
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
        }

        return "redirect:/admin/menu";
    }

    @RequestMapping("/delete/{id}")
    public String deleteMenu(@PathVariable String id, RedirectAttributes message) {
        boolean isDeleted = menuService.delete(id);

        if (isDeleted) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除系统菜单成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "删除系统菜单失败");
        }

        return "redirect:/admin/menu";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String routeEdit(@PathVariable String id, Model model, RedirectAttributes message) {
        Menu menu = menuService.readEditMenuDetail(id);

        if (Optional.fromNullable(menu).isPresent()) {

            Map<String, List<Menu>> menusMap = menuService.readAllChildMenus();

            model.addAttribute("menu", menu);
            model.addAttribute("menusMap", menusMap);

            return "sys/menu/edit";
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "菜单不可编辑");

            return "redirect:/admin/menu";
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEdit(Menu menu, RedirectAttributes message) {
        boolean isEditSuccess = menuService.update(menu);

        if (isEditSuccess) {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 200);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑系统菜单成功");
        } else {
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_CODE, 500);
            message.addFlashAttribute(Constants.REDIRECT_MESSAGE_KEY, "编辑系统菜单失败");
        }

        return "redirect:/admin/menu";
    }
}

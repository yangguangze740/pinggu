package com.zhulin.framework.controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

public abstract class ArcController<T> {
    // list查询
    public abstract String list(T t, HttpServletRequest request, Model model);
    // 详细信息
    public abstract String detail(String id, HttpServletRequest request, Model model);
    // 编辑路由
    public abstract String query4Edit(String id, HttpServletRequest request, Model model);
    // 编辑保存
    public abstract String update(T t, HttpServletRequest request, Model model, RedirectAttributes message);
    // 删除操作
    public abstract String delete(String id, HttpServletRequest request, Model model, RedirectAttributes message);
    // 添加路由
    public abstract String routeAdd(HttpServletRequest request, Model model);
    // 添加保存
    public abstract String saveAdd(T t, HttpServletRequest request, Model model, RedirectAttributes message);
}

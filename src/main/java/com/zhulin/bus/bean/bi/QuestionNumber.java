package com.zhulin.bus.bean.bi;

import java.util.List;

public class QuestionNumber {
    private String name;
    private String stack;
    private List<Integer> data;

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}

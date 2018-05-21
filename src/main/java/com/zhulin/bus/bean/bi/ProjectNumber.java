package com.zhulin.bus.bean.bi;


import java.util.List;

public class ProjectNumber {

    private String name;
    private String stack;
    private List<SupportFileNumber> supportFileNumbers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public List<SupportFileNumber> getSupportFileNumbers() {
        return supportFileNumbers;
    }

    public void setSupportFileNumbers(List<SupportFileNumber> supportFileNumbers) {
        this.supportFileNumbers = supportFileNumbers;
    }

}

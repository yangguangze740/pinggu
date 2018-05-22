package com.zhulin.bus.bean.bi;

import java.util.List;

public class DepartmentNumber {
    private String name;
    private String stack = "总数";
    private String type = "bar";
    private List<SupportFileNumber> supportFileNumbers;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<SupportFileNumber> getSupportFileNumbers() {
        return supportFileNumbers;
    }

    public void setSupportFileNumbers(List<SupportFileNumber> supportFileNumbers) {
        this.supportFileNumbers = supportFileNumbers;
    }

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
}

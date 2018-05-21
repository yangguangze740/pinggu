package com.zhulin.bus.bean.bi;

import java.util.List;

public class DepartmentNumber {
    private String name;
    private String stack;
    private List<ElementNumber> elementNumbers;
    private List<ProjectNumber> projectNumbers;
    private List<SupportFileNumber>supportFileNumbers;

    public List<ProjectNumber> getProjectNumbers() {
        return projectNumbers;
    }

    public void setProjectNumbers(List<ProjectNumber> projectNumbers) {
        this.projectNumbers = projectNumbers;
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

    public List<ElementNumber> getElementNumbers() {
        return elementNumbers;
    }

    public void setElementNumbers(List<ElementNumber> elementNumbers) {
        this.elementNumbers = elementNumbers;
    }


}

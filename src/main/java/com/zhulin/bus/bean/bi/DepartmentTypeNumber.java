package com.zhulin.bus.bean.bi;

import java.util.List;

public class DepartmentTypeNumber {
    private String name;
    private int number;
    private List<TypeNumber> typeNumbers;
    private List<TempTypeNumber> tempTypeNumbers;

    public List<TempTypeNumber> getTempTypeNumbers() {
        return tempTypeNumbers;
    }

    public void setTempTypeNumbers(List<TempTypeNumber> tempTypeNumbers) {
        this.tempTypeNumbers = tempTypeNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<TypeNumber> getTypeNumbers() {
        return typeNumbers;
    }

    public void setTypeNumbers(List<TypeNumber> typeNumbers) {
        this.typeNumbers = typeNumbers;
    }
}

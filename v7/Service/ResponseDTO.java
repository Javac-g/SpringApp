package com.MAX.v7.Service;

import com.MAX.v7.Controller.Tool;

public class ResponseDTO {
    private String name;
    private Integer id;
    private Tool tool;
    private CarEnum carEnum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public CarEnum getCarEnum() {
        return carEnum;
    }

    public void setCarEnum(CarEnum carEnum) {
        this.carEnum = carEnum;
    }
}

package com.MAX.v8.Service;

import com.MAX.v8.Controller.Car;
import com.MAX.v8.Controller.RequestDTO;
import com.MAX.v8.Controller.Tool;

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
    public void setEnum(ResponseDTO user, RequestDTO json){
        for (Car car:json.getCarlist()){
            switch (car.getValue()){
                case"F":
                    user.setCarEnum(CarEnum.Ford);
                    break;
                case"A":
                    user.setCarEnum(CarEnum.Aston_Martin);
                    break;
                default:
                    user.setCarEnum(CarEnum.Bicycle);
                    break;
            }
        }
    }
}

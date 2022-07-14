package com.MAX.v8.Configuration;

import com.MAX.v8.Controller.Controller;
import com.MAX.v8.Controller.ControllerRight;
import com.MAX.v8.Controller.sideController;
import com.MAX.v8.Service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {
    @Bean(name = "Main")
    public Service_Main serviceMain(){
        return new Service_Main();
    }

    @Bean("One")
    public ServiceOne serviceOne(){
        return new ServiceOne();
    }

    @Bean("A")
    @Scope(value = "prototype")
    public ServiceA serviceA(){
        return new ServiceA();
    }


    @Bean("B")
    @Scope(value = "prototype")
    public ServiceB serviceB(){
        return new ServiceB();
    }


    @Bean(name = "Controller")
    @Scope(value = "prototype")
    public Controller controller(){
        Controller controller = new Controller(serviceMain());

        return controller;
    }
    @Bean(name = "sideController")
    @Scope(value = "prototype")
    public sideController sideController(){
        sideController sideController = new sideController();
        sideController.setServiceA(serviceA());
        sideController.setServiceB(serviceB());
        return sideController;
    }
    @Bean(name = "ControllerRight")
    @Scope(value = "prototype")
    public ControllerRight controllerRight(){
        ControllerRight controllerRight = new ControllerRight();
        controllerRight.setServiceOne(serviceOne());
        return controllerRight;
    }

}

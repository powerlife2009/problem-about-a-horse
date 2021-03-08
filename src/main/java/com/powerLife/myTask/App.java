package com.powerLife.myTask;

import com.powerLife.myTask.config.ApplicationConfig;
import com.powerLife.myTask.controller.Controller;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        var controller = context.getBean(Controller.class);
        controller.launch();
    }
}

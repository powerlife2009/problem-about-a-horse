package com.horse.problem;

import com.horse.problem.config.ApplicationConfig;
import com.horse.problem.controller.Controller;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        var controller = context.getBean(Controller.class);
        controller.launch();
    }
}

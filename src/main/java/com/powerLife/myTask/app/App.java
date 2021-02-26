package com.powerLife.myTask.app;

import com.powerLife.myTask.controller.Controller;
import com.powerLife.myTask.logic.Decision;
import com.powerLife.myTask.view.MainView;


public class App {

    public static void main(String[] args) {

        var mainView = new MainView();
        var decision = new Decision();
        var controller = new Controller(decision, mainView);
        controller.initController();

    }
}

package com.powerLife.myTask;

import com.powerLife.myTask.controller.Controller;
import com.powerLife.myTask.logic.Logics;
import com.powerLife.myTask.view.MainView;

public class App {

    public static void main(String[] args) {

        var mainView = new MainView();
        var logics = new Logics();
        var controller = new Controller(logics, mainView);
        controller.launch();
    }
}

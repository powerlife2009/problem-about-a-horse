package com.powerLife.myTask;

import com.powerLife.myTask.controller.Controller;
import com.powerLife.myTask.logic.Decision;
import com.powerLife.myTask.view.MainView;


public class App {

    public static void main(String[] args) throws InterruptedException {

        var chess2 = new MainView();
        var decision = new Decision();
        var controller = new Controller(decision, chess2);
        //controller.setHorseStartPosition(1,1);
        controller.setHorseOnBoard();
        controller.initController();

    }
}

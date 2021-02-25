package com.powerLife.myTask.listeners;

import com.powerLife.myTask.controller.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopListener implements ActionListener {

    private final Controller controller;

    public StopListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.newBoard();
    }
}

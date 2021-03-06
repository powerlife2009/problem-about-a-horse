package com.powerLife.myTask.listeners;

import com.powerLife.myTask.controller.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartListener implements ActionListener {

    private final Controller controller;

    public StartListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.getMainView().buttonActivityAtStart();
        controller.getTimer().restart();
    }
}

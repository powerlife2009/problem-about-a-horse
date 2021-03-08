package com.powerLife.myTask.listeners;

import com.powerLife.myTask.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class StartListener implements ActionListener {

    private final Controller controller;

    @Autowired
    public StartListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.getMainView().buttonActivityAtStart();
        controller.getTimer().restart();
    }
}

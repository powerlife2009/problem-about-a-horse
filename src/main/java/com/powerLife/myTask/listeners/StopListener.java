package com.powerLife.myTask.listeners;

import com.powerLife.myTask.controller.Controller;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
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

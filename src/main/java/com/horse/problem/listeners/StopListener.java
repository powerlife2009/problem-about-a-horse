package com.horse.problem.listeners;

import com.horse.problem.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class StopListener implements ActionListener {

    private final Controller controller;

    @Autowired
    public StopListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.newBoard();
    }
}

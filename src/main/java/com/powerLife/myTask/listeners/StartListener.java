package com.powerLife.myTask.listeners;

import com.powerLife.myTask.controller.Controller;
import com.powerLife.myTask.view.MainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class StartListener implements ActionListener {

    private final Controller controller;
    private final MainView mainView;

    @Autowired
    public StartListener(MainView mainView, Controller controller) {
        this.mainView = mainView;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainView.buttonActivityAtStart();
        controller.restartTimer();
    }
}

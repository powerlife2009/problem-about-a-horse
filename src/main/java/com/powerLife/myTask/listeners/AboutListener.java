package com.powerLife.myTask.listeners;

import com.powerLife.myTask.view.AboutView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        new AboutView();
    }
}

package com.horse.problem.listeners;

import com.horse.problem.view.AboutView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class AboutListener implements ActionListener {

    private final AboutView aboutView;

    @Autowired
    public AboutListener(AboutView aboutView) {
        this.aboutView = aboutView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        aboutView.initAboutView();
    }
}

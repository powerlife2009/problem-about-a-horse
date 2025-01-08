package com.horse.problem.listeners;

import com.horse.problem.view.MainView;
import com.horse.problem.view.SetHorse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class SetHorListener implements ActionListener {

    private final MainView mainView;
    private final SetHorse setHorse;

    @Autowired
    public SetHorListener(MainView mainView, SetHorse setHorse) {
        this.mainView = mainView;
        this.setHorse = setHorse;
        setListeners();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setHorse.initSetHorView();
        mainView.setEnabled(false);
    }

    public void setListeners() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                setHorse.setHorseOnCell(i, j);
            }
        }
    }
}

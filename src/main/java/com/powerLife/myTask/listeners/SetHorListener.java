package com.powerLife.myTask.listeners;

import com.powerLife.myTask.controller.Controller;
import com.powerLife.myTask.view.SetHorse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class SetHorListener implements ActionListener {

    private final Controller controller;
    private final SetHorse setHorse;

    @Autowired
    public SetHorListener(Controller controller, SetHorse setHorse) {
        this.controller = controller;
        this.setHorse = setHorse;
        setListeners();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setHorse.initSetHorView();
        controller.getMainView().setEnabled(false);
    }

    public void setListeners() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int finalI = i;
                int finalJ = j;
                setHorse.getChessBoard()[i][j].addActionListener(e1 -> {
                    controller.newBoard();
                    controller.getMainView().removeHorse(controller.getLogics().getHorse().getNowPosH(),
                            controller.getLogics().getHorse().getNowPosV());
                    controller.getMainView().getStart().setEnabled(true);
                    controller.setHorseStartPosition(finalI, finalJ);
                    controller.setHorseOnBoard();
                    setHorse.dispose();
                    controller.getMainView().setEnabled(true);
                });
            }
        }
    }
}

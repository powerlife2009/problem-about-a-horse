package com.powerLife.myTask.listeners;

import com.powerLife.myTask.controller.Controller;
import com.powerLife.myTask.view.SetHorse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SetHorListener implements ActionListener {

    private final Controller controller;

    public SetHorListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var setHorse = new SetHorse();
        controller.getMainView().setEnabled(false);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int finalI = i;
                int finalJ = j;
                setHorse.getChessBoard()[i][j].addActionListener(e1 -> {
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

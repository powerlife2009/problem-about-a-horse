package com.powerLife.myTask.controller;

import com.powerLife.myTask.logic.Decision;
import com.powerLife.myTask.view.AboutView;
import com.powerLife.myTask.view.MainView;
import com.powerLife.myTask.view.SetHorse;


public class Controller {

    private final Decision decision;
    private final MainView chess2;

    public Controller(Decision d, MainView c) {
        this.decision = d;
        this.chess2 = c;
    }

    public void run() {

        while (decision.getField().getQuantityCells() != 0) {
            chess2.killCell(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());

            decision.goHorse();

            chess2.setHorse(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());

            decision.getField().decrementQuantityCells();
        }

    }

    public void setHorseStartPosition(int h, int v) {
        decision.getField().removeHorse(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());
        decision.getHorse().setHorseOnStartPosition(h, v);
    }

    public void setHorseOnBoard() {
        decision.getField().setHorse(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());
        chess2.setHorse(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());
    }

    public void initController() { // TODO: 20.02.2021 Все листенеры вынести в отдельный класс
        chess2.getStart().addActionListener(e -> run());
        chess2.getSetHor().addActionListener(e -> {
            SetHorse setHorse = new SetHorse();
            chess2.setEnabled(false); // делает основное окно неактивным
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    int finalI = i;
                    int finalJ = j;
                    setHorse.getChessBoard()[i][j].addActionListener(q -> {
                        chess2.removeHorse(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());
                        setHorseStartPosition(finalI, finalJ);
                        setHorseOnBoard();
                        setHorse.dispose(); //закрывает окно выбора позиции
                        chess2.setEnabled(true); // делает основное окно активным
                    });
                }
            }
        });
        chess2.getAbout().addActionListener(e -> new AboutView()); // TODO: 20.02.2021 Релизовать содержимое окна
        chess2.getStop().addActionListener(e -> new MainView()); // TODO: 20.02.2021 Продумать как создать новое поле
    }
}

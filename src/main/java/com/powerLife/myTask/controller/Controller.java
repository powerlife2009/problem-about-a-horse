package com.powerLife.myTask.controller;

import com.powerLife.myTask.logic.Logics;
import com.powerLife.myTask.view.MainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class Controller {

    private final Logics logic;
    private final MainView mainView;
    private final Timer timer;

    @Autowired
    public Controller(Logics decision, MainView mainView) {
        this.logic = decision;
        this.mainView = mainView;
        this.timer = new Timer(500, e -> run());
    }

    public Logics getLogics() {
        return logic;
    }

    public void restartTimer() {
        timer.restart();
    }

    public void setHorseStartPosition(int h, int v) {
        logic.removeHorse();
        logic.setHorseOnStartPosition(h, v);
    }

    public void setHorseOnBoard() {
        logic.occupyCell();
        mainView.setHorse(logic.nowHorsePositionH(), logic.nowHorsePositionV());
    }

    public void run() {
        if (logic.quantityCellsOnField() != 0) {
            // Установка маркера на настоящую позицию фигуры в представлении
            mainView.markCell(logic.nowHorsePositionH(), logic.nowHorsePositionV());
            // Вычисление новой позиции для фигуры
            logic.moveOfKnight();
            // Установка label фигуры на новую позицию в представлении
            mainView.setHorse(logic.nowHorsePositionH(), logic.nowHorsePositionV());
        } else {
            timer.stop();
            mainView.buttonActivityAtStop();
        }
    }

    public void newBoard() {
        timer.stop();
        mainView.getNewBoard();
        logic.removeHorse();
    }

    public void launch() {
        mainView.initView();
    }
}

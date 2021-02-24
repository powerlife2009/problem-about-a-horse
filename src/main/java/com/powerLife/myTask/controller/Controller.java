package com.powerLife.myTask.controller;

import com.powerLife.myTask.listeners.AboutListener;
import com.powerLife.myTask.listeners.SetHorListener;
import com.powerLife.myTask.listeners.StartListener;
import com.powerLife.myTask.listeners.StopListener;
import com.powerLife.myTask.logic.Decision;
import com.powerLife.myTask.view.MainView;

import javax.swing.*;


public class Controller {

    private final Decision decision;
    private final MainView mainView;
    private final Timer timer;

    public Controller(Decision d, MainView c) {
        this.decision = d;
        this.mainView = c;
        this.timer = new Timer(100, e -> eee());
    }

    public Decision getDecision() {
        return decision;
    }

    public MainView getChess2() {
        return mainView;
    }

    public void run() {
        timer.restart();
        mainView.getSetHor().setEnabled(false);
        mainView.getStart().setEnabled(false);
        mainView.getStop().setEnabled(true);
    }

    public void setHorseStartPosition(int h, int v) {
        decision.getField().removeHorse(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());
        decision.getHorse().setHorseOnStartPosition(h, v);
    }

    public void setHorseOnBoard() {
        decision.getField().occupyCell(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());
        mainView.setHorse(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());
    }

    public void initController() {
        mainView.getStart().addActionListener(new StartListener(this));
        mainView.getSetHor().addActionListener(new SetHorListener(this));
        mainView.getStop().addActionListener(new StopListener(this));
        mainView.getAbout().addActionListener(new AboutListener());
    }

    public void eee() { // TODO: 22.02.2021 Придумать название для метода
        if (decision.getField().getQuantityCells() != 0) {
            mainView.markCell(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());

            decision.goHorse();

            mainView.setHorse(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());
        } else {
            timer.stop();
            mainView.getSetHor().setEnabled(true);
            mainView.getStop().setEnabled(false);
        }
    }

    public void newBoard() {
        mainView.getNewBoard();
        decision.getField().resetField();
        timer.stop();
        mainView.getSetHor().setEnabled(true);
        mainView.getStop().setEnabled(false);
    }
}

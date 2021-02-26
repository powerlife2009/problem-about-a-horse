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

    public Controller(Decision decision, MainView mainView) {
        this.decision = decision;
        this.mainView = mainView;
        this.timer = new Timer(500, e -> run());
    }

    public Decision getDecision() {
        return decision;
    }

    public MainView getMainView() {
        return mainView;
    }

    public Timer getTimer() {
        return timer;
    }

    /**
     * Удаляю коня с поля, присваивая клетке значение 0 и увеличивая количество свободных клеток,
     * затем присваиваю коню новые позиции
     *
     * @param h по горизонтали
     * @param v по вертикали
     */
    public void setHorseStartPosition(int h, int v) {
        decision.getField().removeHorse(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());
        decision.getHorse().setHorseOnStartPosition(h, v);
    }

    /**
     * Занимаю клетку на поле, присваивая ей значение 1,
     * затем устанавливаю коня на поле в VIEW
     */
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

    public void run() {
        mainView.buttonActivityAtStart();
        if (decision.getField().getQuantityCells() != 0) {

            mainView.markCell(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());

            decision.moveOfKnight();

            mainView.setHorse(decision.getHorse().getNowPosH(), decision.getHorse().getNowPosV());
        } else {
            timer.stop();
            mainView.buttonActivityAtStop();
        }
    }

    public void newBoard() {
        timer.stop();                          // останавливаю визуализацию
        mainView.getNewBoard();                // получаю новое поле в VIEW
        decision.getField().resetField();      // очищяю поле
    }
}

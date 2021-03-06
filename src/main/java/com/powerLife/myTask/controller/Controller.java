package com.powerLife.myTask.controller;

import com.powerLife.myTask.listeners.AboutListener;
import com.powerLife.myTask.listeners.SetHorListener;
import com.powerLife.myTask.listeners.StartListener;
import com.powerLife.myTask.listeners.StopListener;
import com.powerLife.myTask.logic.Logics;
import com.powerLife.myTask.view.MainView;

import javax.swing.*;


public class Controller {

    private final Logics logics;
    private final MainView mainView;
    private final Timer timer;

    public Controller(Logics decision, MainView mainView) {
        this.logics = decision;
        this.mainView = mainView;
        this.timer = new Timer(500, e -> run());
        initListeners();
    }

    public Logics getLogics() {
        return logics;
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
        logics.getField().removeHorse(logics.getHorse().getNowPosH(), logics.getHorse().getNowPosV());
        logics.getHorse().setHorseOnStartPosition(h, v);
    }

    /**
     * Занимаю клетку на поле, присваивая ей значение 1,
     * затем устанавливаю коня на поле в VIEW
     */
    public void setHorseOnBoard() {
        logics.getField().occupyCell(logics.getHorse().getNowPosH(), logics.getHorse().getNowPosV());
        mainView.setHorse(logics.getHorse().getNowPosH(), logics.getHorse().getNowPosV());
    }

    /**
     * Инициализация слушателей кнопок
     */
    public void initListeners() {
        mainView.getStart().addActionListener(new StartListener(this));
        mainView.getSetHor().addActionListener(new SetHorListener(this));
        mainView.getStop().addActionListener(new StopListener(this));
        mainView.getAbout().addActionListener(new AboutListener());
    }

    /**
     * Данный Метод осуществляет взимодействие логики и представления (в виде перемещения фигуры).
     * Метод не запустится, если количество свободных клеток = 0.
     * Запускается при нажатии на кнопку старт, и работает в таймере(Swing).
     */
    public void run() {
        if (logics.getField().getQuantityCells() != 0) {
            // Установка маркера на настоящую позицию фигуры в представлении
            mainView.markCell(logics.getHorse().getNowPosH(), logics.getHorse().getNowPosV());
            // Вычисление новой позиции для фигуры
            logics.moveOfKnight();
            // Установка label фигуры на новую позицию в представлении
            mainView.setHorse(logics.getHorse().getNowPosH(), logics.getHorse().getNowPosV());
        } else {
            timer.stop();
            mainView.buttonActivityAtStop();
        }
    }

    /**
     * При нажатии кнопки stop производится остановка таймера визуализации,
     * отображение нового поля в окне(view) и сброс данных о клетках (model)
     */
    public void newBoard() {
        timer.stop();
        mainView.getNewBoard();
        logics.getField().resetField();
    }

    public void launch() {
        mainView.initView();
    }
}

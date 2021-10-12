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
        logic.removeHorse();
        logic.setHorseOnStartPosition(h, v);
    }

    /**
     * Занимаю клетку на поле, присваивая ей значение 1,
     * затем устанавливаю коня на поле в VIEW
     */
    public void setHorseOnBoard() {
        logic.occupyCell();
        mainView.setHorse(logic.nowHorsePositionH(), logic.nowHorsePositionV());
    }

    /**
     * Данный Метод осуществляет взаимодействие логики и представления (в виде перемещения фигуры).
     * Метод не запустится, если количество свободных клеток = 0.
     * Запускается при нажатии на кнопку старт, и работает в таймере(Swing).
     */
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

    /**
     * При нажатии кнопки stop производится остановка таймера визуализации,
     * отображение нового поля в окне(view) и сброс данных о клетках (model)
     */
    public void newBoard() {
        timer.stop();
        mainView.getNewBoard();
        logic.removeHorse();
    }

    public void launch() {
        mainView.initView();
    }
}

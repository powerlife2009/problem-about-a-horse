package com.powerLife.myTask.logic;

import com.powerLife.myTask.model.Field;
import com.powerLife.myTask.model.Horse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Logics {

    private final Field field;
    private final Horse horse;
    private final Map<Integer, Integer> moveRecords;

    public Logics() {
        this.field = new Field();
        this.horse = new Horse();
        this.moveRecords = new HashMap<>();
    }

    public Field getField() {
        return field;
    }

    public Horse getHorse() {
        return horse;
    }

    /**
     *  Метод вызываемый из контроллера, вся логика пееремещения фигуры здесь
     */
    public void moveOfKnight() {
        enumOfMovesAndSaveInMemory();
        moveSelection();
        newPosForHorse();
    }

    /**
     * Метод возвращает true если возможный ход находится в пределах поля,
     * и клетка не занималась ранее.
     *
     * @param checkHorPos горизонтальная позиция
     * @param checkVerPos вертикальная позиция
     * @return true or false
     */
    public boolean threeIfCheck(int checkHorPos, int checkVerPos) {
        boolean check = false;
        if (checkHorPos >= 0 && checkHorPos <= 7) {
            if (checkVerPos >= 0 && checkVerPos <= 7) {
                if (field.getField()[checkHorPos][checkVerPos] == 0) {
                    check = true;
                }
            }
        }
        return check;
    }

    /**
     * Метод подсчитывает количество возможных ходов, проверяя каждый методом threeIfCheck
     * Локальные переменные horPos и verPos для сохранения позиции коня, и возврате его на место
     * после проверки хода
     *
     * @return количество count
     */
    public int enumOfFutureMoves() {
        int horPos;
        int verPos;
        int count = 0;
        for (Horse.Position position : Horse.Position.values()) {
            horPos = Horse.getTmpPosH();
            verPos = Horse.getTmpPosV();
            position.setPosition();
            if (threeIfCheck(Horse.getTmpPosH(), Horse.getTmpPosV())) {
                count++;
            }
            Horse.setTmpPos(horPos, verPos);
        }
        return count;
    }

    /**
     * Метод работает с HashMap, итерируясь по ней, встретив ключ с минимальнм значением(Как предполагает Метод
     * Варнсдорфа, который предполагает выбирать первый попавшийся ход у которого минимальное количество возможных
     * ходов в будующем) передает его в метод setFuturePosition(numOfFuturePos).
     * После этого HashMap стирает свое содержимое методом clear()
     */
    public void moveSelection() {
        int numOfFuturePos;
        for (Map.Entry<Integer, Integer> item : moveRecords.entrySet()) {
            if (item.getValue().equals(Collections.min(moveRecords.values()))) {
                numOfFuturePos = item.getKey();
                Horse.Position.setFuturePosition(numOfFuturePos);
                break;
            }
        }
        moveRecords.clear();
    }

    /**
     * Здесь производится запись в HashMap номера возможного хода фигуры в качестве ключа, и количества возможных ходов
     * в будующем в качестве значения. Каждый ход проверяется метдом threeIfCheck.
     */
    public void enumOfMovesAndSaveInMemory() {
        int numberOfFutureMoves;
        for (Horse.Position position : Horse.Position.values()) {
            position.setPosition();
            if (threeIfCheck(Horse.getTmpPosH(), Horse.getTmpPosV())) {
                numberOfFutureMoves = enumOfFutureMoves();
                moveRecords.put(position.getNumberPos(), numberOfFutureMoves);
            }
            horse.returnHorseOnNowPosition();
        }
    }

    /**
     * Присвоение фигуре новых постоянных координат, и вместе с этим клетка, на которой тепер находится конь,
     * помечается как 1(запрещающая постановку фигуры в будущем)
     */
    public void newPosForHorse() {
        horse.moveHorseOnNewPosition();
        field.occupyCell(horse.getNowPosH(), horse.getNowPosV());
    }
}


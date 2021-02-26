package com.powerLife.myTask.logic;

import com.powerLife.myTask.model.Field;
import com.powerLife.myTask.model.Horse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Decision {

    private final Field field;
    private final Horse horse;
    private final Map<Integer, Integer> moveRecords;

    public Decision() {
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

    public void newPosForHorse() {
        horse.moveHorseOnNewPosition();
        field.occupyCell(horse.getNowPosH(), horse.getNowPosV());
    }
}


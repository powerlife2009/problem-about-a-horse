package com.powerLife.myTask.logic;

import com.powerLife.myTask.model.Field;
import com.powerLife.myTask.model.Horse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



public class Decision {

    private final Field field;
    private final Horse horse;

    public Decision() {
        this.field = new Field();
        this.horse = new Horse();
    }

    public Field getField() {
        return field;
    }

    public Horse getHorse() {
        return horse;
    }

    public void goHorse() {
        Map<Integer, Integer> moveRecords = new HashMap<>();
            for (Horse.Position position : Horse.Position.values()) {
                position.setPosition();
                if (threeIfCheck(Horse.getTmpPosH(), Horse.getTmpPosV())) {
                    moveRecords.put(position.getNumberPos(), numberOfFutureMoves());
                }
                horse.returnHorseOnNowPosition();
            }

            hatTrick(moveRecords);
            moveRecords.clear();
            field.occupyCell(horse.getNowPosH(), horse.getNowPosV());
            field.show();
    }

    /**
     * Метод возвращает true если возможный ход находится в пределах поля,
     * и клетка не занималась ранее.
     * @param checkedHorPos горизонтальная позиция
     * @param checkedVerPos вертикальная позиция
     * @return true or false
     */
    public boolean threeIfCheck(int checkedHorPos, int checkedVerPos) {
        boolean check = false;
        if (checkedHorPos >= 0 && checkedHorPos <= 7) {
            if (checkedVerPos >= 0 && checkedVerPos <= 7) {
                if (field.getField()[checkedHorPos][checkedVerPos] == 0) {
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
    public int numberOfFutureMoves() {
        int count = 0;
        for (Horse.Position position : Horse.Position.values()) {
            int horPos = Horse.getTmpPosH();
            int verPos = Horse.getTmpPosV();
            position.setPosition();
            if (threeIfCheck(Horse.getTmpPosH(), Horse.getTmpPosV())) {
                count++;
            }
            Horse.setTmpPos(horPos,verPos);
        }
        return count;
    }

    public void hatTrick(Map<Integer, Integer> moves) {
        int move;
        for (Map.Entry<Integer, Integer> item : moves.entrySet()) {
            if (item.getValue().equals(Collections.min(moves.values()))) {
                move = item.getKey();
                Horse.Position.go(move);
                horse.moveHorseOnNewPosition();
                break;
            }
        }
    }
}


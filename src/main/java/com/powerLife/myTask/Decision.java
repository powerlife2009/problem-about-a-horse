package com.powerLife.myTask;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Decision {

    private final Field field;
    private final Horse horse;

    public Decision(Field field, Horse horse) {
        this.field = field;
        this.horse = horse;
    }

    // TODO: 16.02.2021 Пересмотреть и доработать красоту данного ужаса
    public void goHorse() {
        Map<Integer, Integer> moveRecords = new HashMap<>();
        while (field.getQuantityCells() != 0) {
            for (Horse.Position position : Horse.Position.values()) {
                position.setPosition();
                if (threeIfCheck(Horse.getTmpHorPos(), Horse.getTmpVerPos())) {
                    moveRecords.put(position.getNumberPos(), checkTwoLevel());
                }
                horse.returnHorseOnNowPosition();
            }

            Horse.Position.horseMove(rightMoving(moveRecords));
            horse.setNowHorPos(Horse.getTmpHorPos());
            horse.setNowVerPos(Horse.getTmpVerPos());
            field.getField()[horse.getNowHorPos()][horse.getNowVerPos()] = 1;
            System.out.println("Позиция коня: " + "горизонталь: " + horse.getNowHorPos() + " " + "вертикаль: " + horse.getNowVerPos());
            field.showField();

            moveRecords.clear();
            field.setQuantityCells(field.getQuantityCells() - 1);
        }
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
     * после поиска ходов
     * @return количество count
     */
    public int checkTwoLevel() {
        int count = 0;
        for (Horse.Position position : Horse.Position.values()) {
            int horPos = Horse.getTmpHorPos();
            int verPos = Horse.getTmpVerPos();
            position.setPosition();
            if (threeIfCheck(Horse.getTmpHorPos(), Horse.getTmpVerPos())) {
                count++;
            }
            Horse.setTmpHorPos(horPos);
            Horse.setTmpVerPos(verPos);
        }
        return count;
    }

    public int rightMoving(Map<Integer, Integer> moves) {
        int move = 0;
        for (Map.Entry<Integer, Integer> item : moves.entrySet()) {
            if (item.getValue().equals(Collections.min(moves.values()))) {
                move = item.getKey();
                break;
            }
        }
        return move;
    }
}


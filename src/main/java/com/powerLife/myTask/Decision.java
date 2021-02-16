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

    public Field getField() {
        return field;
    }

    public Horse getHorse() {
        return horse;
    }

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

            int move = rightMoving(moveRecords);
            // Наконец-то конь пошёл
            Horse.Position.horseMove(move);
            horse.setNowHorPos(Horse.getTmpHorPos());
            horse.setNowVerPos(Horse.getTmpVerPos());
            field.getField()[horse.getNowHorPos()][horse.getNowVerPos()] = 1;
            moveRecords.clear();
            System.out.println("Позиция коня: " + "горизонталь: " + horse.getNowHorPos() + " " + "вертикаль: " + horse.getNowVerPos());
            System.out.println("------------------------");
            System.out.println("Осталось пустых клеток: " + field.getQuantityCells());
            field.showField();
            field.setQuantityCells(field.getQuantityCells() - 1);
        }
    }

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


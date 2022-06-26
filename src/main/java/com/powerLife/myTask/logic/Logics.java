package com.powerLife.myTask.logic;

import com.powerLife.myTask.model.Field;
import com.powerLife.myTask.model.Horse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class Logics {

    private final Field field;
    private final Horse horse;
    private final Map<Integer, Integer> moveRecords;

    @Autowired
    public Logics(Field field, Horse horse) {
        this.field = field;
        this.horse = horse;
        this.moveRecords = new HashMap<>();
    }

    public void removeHorse() {
        field.resetField();
    }

    public Horse getHorse() {
        return horse;
    }

    public void moveOfKnight() {
        enumOfMovesAndSaveInMemory();
        moveSelection();
        newPosForHorse();
    }

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

    public void setHorseOnStartPosition(int h, int v) {
        horse.setHorseOnStartPosition(h, v);
    }

    public void occupyCell() {
        field.occupyCell(horse.getNowPosH(), horse.getNowPosV());
    }

    public int nowHorsePositionH() {
        return horse.getNowPosH();
    }

    public int nowHorsePositionV() {
        return horse.getNowPosV();
    }

    public int quantityCellsOnField() {
        return field.getQuantityCells();
    }
}


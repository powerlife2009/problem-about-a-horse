package com.powerLife.myTask;

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
        for (Horse.Position position : Horse.Position.values()) {
            position.setPosition();
            if (threeIfCheck(Horse.getTmpHorPos(), Horse.getTmpVerPos())) {
                // клетка находится в пределах поля и не занята
                System.out.println("Пустая клетка");
                Horse.setTmpHorPos(horse.getNowHorPos());
                Horse.setTmpVerPos(horse.getNowVerPos());
            } else {
                Horse.setTmpHorPos(horse.getNowHorPos());
                Horse.setTmpVerPos(horse.getNowVerPos());
                System.out.println("Мимо");
            }
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
}


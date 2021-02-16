package com.powerLife.myTask;

public class Horse {

    /**
     * Временные статические переменные, для поиска верного хода
     */
    private static int tmpHorPos;
    private static int tmpVerPos;
    /**
     * Стартовые позиции коня, задаются на старте программы
     */
    private final int horStartPos;
    private final int verStartPos;
    /**
     * Позиции на которых находится конь
     */
    private int nowHorPos;
    private int nowVerPos;

    public Horse(int horStartPos, int verStartPos) {
        this.horStartPos = horStartPos;
        this.verStartPos = verStartPos;
        this.nowHorPos = horStartPos;
        this.nowVerPos = verStartPos;
        Horse.setTmpHorPos(nowHorPos);
        Horse.setTmpVerPos(nowVerPos);
    }

    public static int getTmpHorPos() {
        return tmpHorPos;
    }

    public static void setTmpHorPos(int tmpHorPos) {
        Horse.tmpHorPos = tmpHorPos;
    }

    public static int getTmpVerPos() {
        return tmpVerPos;
    }

    public static void setTmpVerPos(int tmpVerPos) {
        Horse.tmpVerPos = tmpVerPos;
    }

    public int getHorStartPos() {
        return horStartPos;
    }

    public int getVerStartPos() {
        return verStartPos;
    }

    public int getNowHorPos() {
        return nowHorPos;
    }

    public void setNowHorPos(int nowHorPos) {
        this.nowHorPos = nowHorPos;
    }

    public int getNowVerPos() {
        return nowVerPos;
    }

    public void setNowVerPos(int nowVerPos) {
        this.nowVerPos = nowVerPos;
    }

    /**
     * Возвращает коня, на место в случаях неудачных проверок
     */
    public void returnHorseOnNowPosition() {
        setTmpHorPos(getNowHorPos());
        setTmpVerPos(getNowVerPos());
    }


    public enum Position {
        ONE(1) {
            @Override
            public void setPosition() {
                System.out.println("Начало с позиции " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
                //System.out.println("=============================");
                Horse.setTmpHorPos(Horse.getTmpHorPos() + 1);
                Horse.setTmpVerPos(Horse.getTmpVerPos() + 2);
                //System.out.println("Ход первый " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        TWO(2) {
            @Override
            public void setPosition() {
                Horse.setTmpHorPos(Horse.getTmpHorPos() + 1);
                Horse.setTmpVerPos(Horse.getTmpVerPos() - 2);
                //System.out.println("Ход второй " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        THREE(3) {
            @Override
            public void setPosition() {
                Horse.setTmpHorPos(Horse.getTmpHorPos() - 1);
                Horse.setTmpVerPos(Horse.getTmpVerPos() + 2);
                //System.out.println("Ход третий " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        FOUR(4) {
            @Override
            public void setPosition() {
                Horse.setTmpHorPos(Horse.getTmpHorPos() - 1);
                Horse.setTmpVerPos(Horse.getTmpVerPos() - 2);
                //System.out.println("Ход четвертый " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        FIVE(5) {
            @Override
            public void setPosition() {
                Horse.setTmpHorPos(Horse.getTmpHorPos() + 2);
                Horse.setTmpVerPos(Horse.getTmpVerPos() + 1);
                //System.out.println("Ход пятый " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        SIX(6) {
            @Override
            public void setPosition() {
                Horse.setTmpHorPos(Horse.getTmpHorPos() + 2);
                Horse.setTmpVerPos(Horse.getTmpVerPos() - 1);
                //System.out.println("Ход шестой " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        SEVEN(7) {
            @Override
            public void setPosition() {
                Horse.setTmpHorPos(Horse.getTmpHorPos() - 2);
                Horse.setTmpVerPos(Horse.getTmpVerPos() + 1);
                //System.out.println("Ход седьмой " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        EIGHT(8) {
            @Override
            public void setPosition() {
                Horse.setTmpHorPos(Horse.getTmpHorPos() - 2);
                Horse.setTmpVerPos(Horse.getTmpVerPos() - 1);
                //System.out.println("Ход восьмой " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        };
        private final Integer numberPos;

        Position(int numberPos) {
            this.numberPos = numberPos;
        }

        public Integer getNumberPos() {
            return numberPos;
        }

        abstract void setPosition();

        public static void horseMove(int numberMove) {
            for(Position position : values()){
                if(position.numberPos.equals(numberMove)) {
                    position.setPosition();
                }
            }
        }
    }
}


package com.powerLife.myTask.model;

public class Horse {

    /**
     * Временные статические переменные, для поиска верного хода
     */
    private static int tmpPosH;
    private static int tmpPosV;

    /**
     * Позиции на которых находится конь
     */
    private int nowPosH;
    private int nowPosV;


    public static int getTmpPosH() {
        return tmpPosH;
    }

    public static void setTmpPosH(int posH) {
        Horse.tmpPosH = posH;
    }

    public static int getTmpPosV() {
        return tmpPosV;
    }

    public static void setTmpPosV(int posV) {
        Horse.tmpPosV = posV;
    }

    public int getNowPosH() {
        return nowPosH;
    }

    public void setNowPosH(int nowHorPos) {
        this.nowPosH = nowHorPos;
    }

    public int getNowPosV() {
        return nowPosV;
    }

    public void setNowPosV(int nowVerPos) {
        this.nowPosV = nowVerPos;
    }

    public void setNowPos(int h, int v) {
        setNowPosH(h);
        setNowPosV(v);
    }

    public static void setTmpPos(int tmpPosH, int tmpPosV) {
        setTmpPosH(tmpPosH);
        setTmpPosV(tmpPosV);
    }

    /**
     * Возвращает коня, на место после проверок
     */
    public void returnHorseOnNowPosition() {
        setTmpPos(getNowPosH(),getNowPosV());
    }

    /**
     * Перемещает коня на новое место
     */
    public void moveHorseOnNewPosition() {
        setNowPos(getTmpPosH(), getTmpPosV());
    }

    /**
     * Стартовые позиции коню
     * @param h по горизонтали
     * @param v по вертикали
     */
    public void setHorseOnStartPosition(int h, int v) {
        setNowPos(h, v);
        setTmpPos(h, v);
    }

    public enum Position {
        ONE(1) {
            @Override
            public void setPosition() {
                Horse.setTmpPos(Horse.getTmpPosH() + 1, Horse.getTmpPosV() + 2);
            }
        },
        TWO(2) {
            @Override
            public void setPosition() {
                Horse.setTmpPos(Horse.getTmpPosH() + 1, Horse.getTmpPosV() - 2);
            }
        },
        THREE(3) {
            @Override
            public void setPosition() {
                Horse.setTmpPos(Horse.getTmpPosH() - 1, Horse.getTmpPosV() + 2);
            }
        },
        FOUR(4) {
            @Override
            public void setPosition() {
                Horse.setTmpPos(Horse.getTmpPosH() - 1, Horse.getTmpPosV() - 2);
            }
        },
        FIVE(5) {
            @Override
            public void setPosition() {
                Horse.setTmpPos(Horse.getTmpPosH() + 2, Horse.getTmpPosV() + 1);
            }
        },
        SIX(6) {
            @Override
            public void setPosition() {
                Horse.setTmpPos(Horse.getTmpPosH() + 2, Horse.getTmpPosV() - 1);
            }
        },
        SEVEN(7) {
            @Override
            public void setPosition() {
                Horse.setTmpPos(Horse.getTmpPosH() - 2, Horse.getTmpPosV() + 1);
            }
        },
        EIGHT(8) {
            @Override
            public void setPosition() {
                Horse.setTmpPos(Horse.getTmpPosH() - 2, Horse.getTmpPosV() - 1);
            }
        };
        private final Integer numberPos;

        Position(int numberPos) {
            this.numberPos = numberPos;
        }

        public static void setFuturePosition(int numPos) {
            for (Position position : values()) {
                if (position.numberPos.equals(numPos)) {
                    position.setPosition();
                }
            }
        }

        public Integer getNumberPos() {
            return numberPos;
        }

        public abstract void setPosition();
    }
}


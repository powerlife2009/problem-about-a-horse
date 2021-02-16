package com.powerLife.myTask;

public class Horse {

    private final int horStartPos;
    private final int verStartPos;
    private int nowHorPos;
    private int nowVerPos;
    private static int tmpHorPos = 0;
    private static int tmpVerPos = 0;

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

    public void setNowVerPos(int nowVerPos) {
        this.nowVerPos = nowVerPos;
    }

    public int getNowVerPos() {
        return nowVerPos;
    }



    public enum Position {
        ONE{
            @Override
            public void setPosition(){
                System.out.println("Начало с позиции " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
                System.out.println("=============================");
                Horse.setTmpHorPos(Horse.getTmpHorPos() + 1);
                Horse.setTmpVerPos(Horse.getTmpVerPos() + 2);
                System.out.println("Ход первый " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        TWO{
            @Override
            public void setPosition(){
                Horse.setTmpHorPos(Horse.getTmpHorPos() + 1);
                Horse.setTmpVerPos(Horse.getTmpVerPos() - 2);
                System.out.println("Ход второй " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        THREE{
            @Override
            public void setPosition(){
                Horse.setTmpHorPos(Horse.getTmpHorPos() - 1);
                Horse.setTmpVerPos(Horse.getTmpVerPos() + 2);
                System.out.println("Ход третий " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        FOUR{
            @Override
            public void setPosition(){
                Horse.setTmpHorPos(Horse.getTmpHorPos() - 1);
                Horse.setTmpVerPos(Horse.getTmpVerPos() - 2);
                System.out.println("Ход четвертый " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        FIVE{
            @Override
            public void setPosition(){
                Horse.setTmpHorPos(Horse.getTmpHorPos() + 2);
                Horse.setTmpVerPos(Horse.getTmpVerPos() + 1);
                System.out.println("Ход пятый " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        SIX{
            @Override
            public void setPosition(){
                Horse.setTmpHorPos(Horse.getTmpHorPos() + 2);
                Horse.setTmpVerPos(Horse.getTmpVerPos() - 1);
                System.out.println("Ход шестой " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        SEVEN{
            @Override
            public void setPosition(){
                Horse.setTmpHorPos(Horse.getTmpHorPos() - 2);
                Horse.setTmpVerPos(Horse.getTmpVerPos() + 1);
                System.out.println("Ход седьмой " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        },
        EIGHT{
            @Override
            public void setPosition(){
                Horse.setTmpHorPos(Horse.getTmpHorPos() - 2);
                Horse.setTmpVerPos(Horse.getTmpVerPos() - 1);
                System.out.println("Ход восьмой " + Horse.getTmpHorPos() + " " + Horse.getTmpVerPos());
            }
        };

        abstract void setPosition();
    }
}


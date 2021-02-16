package com.powerLife.myTask;

public class Field {

    private final int[][] field = new int[8][8];
    private Horse horse;
    private int quantityCells = 63;

    public int[][] getField() {
        return field;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
        this.field[horse.getHorStartPos()][horse.getVerStartPos()] = 1;
    }

    public int getQuantityCells() {
        return quantityCells;
    }

    public void setQuantityCells(int quantityCells) {
        this.quantityCells = quantityCells;
    }

    public void showField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}

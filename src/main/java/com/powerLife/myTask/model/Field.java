package com.powerLife.myTask.model;

public class Field {

    /**
     * Поле 8 х 8
     */
    private int[][] field = new int[8][8];

    /**
     * Количество ранее не занятых клеток,
     * 64-я = конь
     */
    private int quantityCells = 64;

    public int[][] getField() {
        return field;
    }

    public void occupyCell(int hor, int ver) {
        this.field[hor][ver] = 1;
        this.quantityCells--;
    }

    public void removeHorse(int h, int v) {
        if(this.quantityCells < 64) {
            this.quantityCells++;
        }
        this.field[h][v] = 0;

    }

    public int getQuantityCells() {
        return quantityCells;
    }

    public void resetField() {
        this.field = new int[8][8];
        this.quantityCells = 64;
    }

    public void show() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}

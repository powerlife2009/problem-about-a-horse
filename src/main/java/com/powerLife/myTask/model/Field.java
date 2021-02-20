package com.powerLife.myTask.model;

public class Field {

    /**
     * Поле 8 х 8
     */
    private final int[][] field = new int[8][8];

    /**
     * Количество ранее не занятых клеток,
     * 64-я = конь
     */
    private int quantityCells = 63;

    public int[][] getField() {
        return field;
    }

    public void occupyCell(int hor, int ver) {
        getField()[hor][ver] = 1;
    }

    public void decrementQuantityCells() {
        this.quantityCells--;
    }

    public void setHorse(int h, int v) {
        this.field[h][v] = 1;
    }

    public void removeHorse(int h, int v) {
        this.field[h][v] = 0;
    }

    public int getQuantityCells() {
        return quantityCells;
    }


    public void showField() {
        for (int[] ints : field) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}

package com.powerLife.myTask.model;

public class Field {

    /**
     * Поле 8 х 8
     */
    private int[][] field = new int[8][8];

    /**
     * Количество ранее не занятых клеток,
     */
    private int quantityCells = 64;

    public int[][] getField() {
        return field;
    }

    /**
     * Занимает клетку на поле, обозначая её как 1. Вместе
     * с этим уменьшая количество свободных клеток
     * @param hor по горизонтали
     * @param ver по вертикали
     */
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
}

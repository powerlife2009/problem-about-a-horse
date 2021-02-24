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

    public int getQuantityCells() {
        return quantityCells;
    }

    /**
     * Занимает клетку на поле, обозначая её как 1. Вместе
     * с этим уменьшая количество свободных клеток
     * @param h по горизонтали
     * @param v по вертикали
     */
    public void occupyCell(int h, int v) {
        this.field[h][v] = 1;
        this.quantityCells--;
    }

    /**
     * Освобождает клетку на поле, обозначая её как 0. Вместе
     * с этим увеличивая количество свободных клеток
     * Проверка, на выход за пределы количества
     * @param h по горизонтали
     * @param v по вертикали
     */
    public void removeHorse(int h, int v) {
        if(this.quantityCells < 64) {
            this.quantityCells++;
        }
        this.field[h][v] = 0;

    }

    /**
     * Новое чистое поле
     */
    public void resetField() {
        this.field = new int[8][8];
        this.quantityCells = 64;
    }
}

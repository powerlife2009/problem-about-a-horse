package com.horse.problem.model;

import org.springframework.stereotype.Component;

@Component
public class Field {

    private int[][] field = new int[8][8];

    private int quantityCells = 64;

    public int[][] getField() {
        return field;
    }

    public int getQuantityCells() {
        return quantityCells;
    }

    public void occupyCell(int h, int v) {
        this.field[h][v] = 1;
        this.quantityCells--;
    }

    public void resetField() {
        this.field = new int[8][8];
        this.quantityCells = 64;
    }
}

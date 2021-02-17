package com.powerLife.myTask;

public class Field {

    /**
     * Поле 8 х 8
     */
    private final int[][] field = new int[8][8];

    /**
     * Тот самый виновник торжества
     */
    private Horse horse;

    /**
     * Количество ранее не занятых клеток,
     * 64-я = конь
     */
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
        for (int[] ints : field) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}

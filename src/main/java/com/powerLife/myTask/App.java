package com.powerLife.myTask;

public class App {

    public static void main(String[] args) {

        Horse horse = new Horse(0, 0);
        Field field = new Field();
        field.setHorse(horse);
        Decision decision = new Decision(field, horse);
        decision.goHorse();
    }
}

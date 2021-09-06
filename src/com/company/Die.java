package com.company;

import java.util.ArrayList;

public class Die {

    private int sides;
    private int value;

    public Die() {
        this.sides = sides;
        this.value = getValue();
    }
    public ArrayList<Integer> rollDie(int rolls) {
        int currentRoll = 0;
        ArrayList<Integer> rollScores = new ArrayList<Integer>();

        if (currentRoll < rolls){
            value = (int) (Math.random() * 6 + 1);
            rollScores.add(value);
            currentRoll++;

        }
        return rollScores;

    }

    public int getValue() {
        return value;
    }
}

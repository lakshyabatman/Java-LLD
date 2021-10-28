package com.lakshyabatman.snakeladder.models;

import com.lakshyabatman.snakeladder.DicePolicy.DicePolicy;

public class Dice<Integer> {

    DicePolicy<Integer> dicePolicy;

    public Dice(DicePolicy<Integer> dicePolicy) {
        this.dicePolicy = dicePolicy;
    }

    public Integer roll() {
        return dicePolicy.rollDice();
    }

}

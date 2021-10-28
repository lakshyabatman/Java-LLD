package com.lakshyabatman.snakeladder.DicePolicy;

public class RandomValueDicePolicy extends DicePolicy<Integer> {
    @Override
    public Integer rollDice() {
        return (int) (Math.random() * 7);
    }
}

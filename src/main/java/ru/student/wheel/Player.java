package ru.student.wheel;

public class Player {

    private int coins = 5;

    public int getCoins() {
        return coins;
    }

    public void addCoins(int value) {
        coins += value;
    }

    public void removeCoin() {
        coins--;
    }

    public void reset() {
        coins = 5;
    }
}
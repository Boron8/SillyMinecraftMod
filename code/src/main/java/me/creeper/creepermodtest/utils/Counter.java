package me.creeper.creepermodtest.utils;

public class Counter {
    private int count = 1;
    private int max_count = 20;

    public int getCount() {
        return count;
    }

    public void increment() {
        if (count < max_count) {
            count++;
        } else {
            count = 1;
        }
    }

    public void reset() {
        count = 1;
    }
}

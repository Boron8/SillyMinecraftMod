package me.creeper.creepermodtest.utils;

public class Counter {
    private int count = 1;

    public void increment() {
        if (count < 20) {
            count++;
        } else {
            count = 1;
        }
    }

    public int     getCount() { return count; }
    public void    reset()    { count = 1; }
    public boolean isSecond() { return count == 1; }
}

package me.creeper.creepermodtest.utils;

import cpw.mods.fml.common.FMLCommonHandler;

public class Counter {
    private int count = 0; // int = 3.4 years of runtime
    private int seconds = 0;
    private boolean isSecond = false; // Store isSecond instead of calculating modulus twice

    public void increment() {
        count++;
        if ((count % 20) == 0) {
            seconds++;
            isSecond = true;
        } else {
            isSecond = false;
        }
    }

    public int     getCount()   { return count;    }
    public boolean isSecond()   { return isSecond; }
    public int     getSeconds() { return seconds;  }


    public static Counter getCounter() {
        if (FMLCommonHandler.instance().getSide().isClient()) {
            return Counter.getClientCounter();
        } else {
            return Counter.getServerCounter();
        }
    }



    private static final Counter globalServerCounter = new Counter();
    private static final Counter globalClientCounter = new Counter();

    public static Counter getServerCounter() { return globalServerCounter; }
    public static Counter getClientCounter() { return globalClientCounter; }
}

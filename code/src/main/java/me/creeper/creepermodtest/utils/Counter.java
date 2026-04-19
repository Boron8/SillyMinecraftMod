package me.creeper.creepermodtest.utils;

import cpw.mods.fml.common.FMLCommonHandler;
import me.creeper.creepermodtest.ExampleMod;

public class Counter {
    private int count = 1;
    private int seconds = 1;

    public void increment() {
        count++;
        if ((count % 20) == 0) {
            seconds++;
        }
    }

    public int     getCount()      { return count; }
    public boolean isSecond()      { return (count % 20) == 0; }
    public int     getSeconds()    { return seconds; }


    public static Counter getCounter() {
        if (FMLCommonHandler.instance().getSide().isClient()) {
            return ExampleMod.getClientCounter();
        } else {
            return ExampleMod.getServerCounter();
        }
    }
}

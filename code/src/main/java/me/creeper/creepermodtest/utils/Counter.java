package me.creeper.creepermodtest.utils;

import cpw.mods.fml.common.FMLCommonHandler;
import me.creeper.creepermodtest.ExampleMod;

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


    public static Counter getCounter() {
        if (FMLCommonHandler.instance().getSide().isClient()) {
            return ExampleMod.getClientCounter();
        } else {
            return ExampleMod.getServerCounter();
        }
    }
}

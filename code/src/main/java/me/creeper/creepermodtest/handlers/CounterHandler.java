package me.creeper.creepermodtest.handlers;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import me.creeper.creepermodtest.ExampleMod;

public class CounterHandler {
    private int tickCounter = 0;

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        tickCounter++;

        if (event.phase == TickEvent.Phase.END) {
            if (tickCounter >= 20) {
                tickCounter = 0;

                ExampleMod.globalCounter.increment();
                FMLLog.info("YES");
            }
        }
    }
}

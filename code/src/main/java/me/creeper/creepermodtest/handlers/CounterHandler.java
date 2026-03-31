package me.creeper.creepermodtest.handlers;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.creeper.creepermodtest.ExampleMod;

public class CounterHandler {
    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            ExampleMod.globalServerCounter.increment();
            if (ExampleMod.globalServerCounter.isSecond()) FMLLog.info("SERVERSERVER");
        }
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            ExampleMod.globalClientCounter.increment();
            if (ExampleMod.globalClientCounter.isSecond()) FMLLog.info("CLIENT");
        }
    }
}

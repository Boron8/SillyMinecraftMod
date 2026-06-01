package me.creeper.creepermodtest.magic;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import me.creeper.creepermodtest.packets.PacketHandler;
import me.creeper.creepermodtest.packets.PacketRequestUnlocks;

public class MagicHandlers {
    @SubscribeEvent
    public void onClientDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        MagicCache.clear();
    }

    @SubscribeEvent
    public void onWorldLoad(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        PacketHandler.INSTANCE.sendToServer(new PacketRequestUnlocks());
    }
}

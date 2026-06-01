package me.creeper.creepermodtest.packets;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import me.creeper.creepermodtest.ExampleMod;

public class PacketHandler {
    public static final SimpleNetworkWrapper INSTANCE =
            NetworkRegistry.INSTANCE.newSimpleChannel(ExampleMod.MODID);

    public static void registerPackets() {
        int id = 0;
        INSTANCE.registerMessage(PacketRequestUnlocks.Handler.class, PacketRequestUnlocks.class, id++, Side.SERVER);
        INSTANCE.registerMessage(PacketSyncUnlocks.Handler.class, PacketSyncUnlocks.class, id++, Side.CLIENT);
        INSTANCE.registerMessage(PacketUnlockUpdate.Handler.class, PacketUnlockUpdate.class, id++, Side.CLIENT);
    }
}

package me.creeper.creepermodtest.screens;

import cpw.mods.fml.common.network.NetworkRegistry;
import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.handlers.GuiHandler;

public class ModGuis {
    public static void registerAllGuis() {
        NetworkRegistry.INSTANCE.registerGuiHandler(ExampleMod.getInstance(), new GuiHandler());
    }
}

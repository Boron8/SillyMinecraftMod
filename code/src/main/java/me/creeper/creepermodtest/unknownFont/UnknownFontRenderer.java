package me.creeper.creepermodtest.unknownFont;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class UnknownFontRenderer extends FontRenderer {
    private static final ResourceLocation fontLocation = new ResourceLocation(ExampleMod.MODID, "textures/font/unknown.png");

    public UnknownFontRenderer() {
        super(
                ExampleMod.mc.gameSettings,
                fontLocation,
                ExampleMod.mc.renderEngine,
                false
        );
        onResourceManagerReload(ExampleMod.mc.getResourceManager());
    }
}

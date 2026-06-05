package me.creeper.creepermodtest.items.templates;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.unknownFont.UnknownFontConverter;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class MagicItem extends Item {
    @Override
    @SideOnly(Side.CLIENT)
    public FontRenderer getFontRenderer(ItemStack stack) {
        return ExampleMod.unknownFontRenderer;
    }

    public String getItemStackDisplayNameOriginal(ItemStack stack) {
        return ("" + StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return UnknownFontConverter.stringToUnknown(getItemStackDisplayNameOriginal(stack));
    }
}

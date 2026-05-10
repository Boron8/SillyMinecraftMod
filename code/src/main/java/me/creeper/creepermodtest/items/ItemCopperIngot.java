package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemCopperIngot extends Item {
    public ItemCopperIngot() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setUnlocalizedName("itemCopperIngot");
        this.setTextureName(ExampleMod.MODID + ":item_copper_ingot");
    }
}

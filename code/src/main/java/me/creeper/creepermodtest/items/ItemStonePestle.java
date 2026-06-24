package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemStonePestle extends Item {
    public ItemStonePestle() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(4);

        this.setUnlocalizedName("stone_pestle");
        this.setTextureName(ExampleMod.MODID+":item_stone_pestle");
    }
}

package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemStoneMortar extends Item {
    public ItemStoneMortar() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(8);

        this.setUnlocalizedName("itemStoneMortar");
        this.setTextureName(ExampleMod.MODID+":item_stone_mortar");
    }
}

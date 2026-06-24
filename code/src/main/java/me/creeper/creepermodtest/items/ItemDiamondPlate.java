package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemDiamondPlate extends Item {
    public ItemDiamondPlate() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setUnlocalizedName("diamond_plate");
        this.setTextureName("minecraft:diamond");
    }
}

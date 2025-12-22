package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class itemDiamondPlate extends Item {
    public itemDiamondPlate() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setUnlocalizedName("itemDiamondPlate");
        this.setTextureName("minecraft:diamond");
    }
}

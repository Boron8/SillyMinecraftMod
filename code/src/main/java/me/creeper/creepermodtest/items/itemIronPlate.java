package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class itemIronPlate extends Item {
    public itemIronPlate() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setUnlocalizedName("itemIronPlate");
        this.setTextureName("minecraft:iron_ingot");
    }
}

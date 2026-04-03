package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemIronPlate extends Item {
    public ItemIronPlate() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setUnlocalizedName("itemIronPlate");
        this.setTextureName("minecraft:iron_ingot");
    }
}

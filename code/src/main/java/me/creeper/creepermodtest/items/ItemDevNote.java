package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemDevNote extends Item {
    public ItemDevNote() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setUnlocalizedName("itemDevNote");
        this.setTextureName("minecraft:paper");
    }
}

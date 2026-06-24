package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemDevNote extends Item {
    public ItemDevNote() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setUnlocalizedName("dev_note");
        this.setTextureName("minecraft:paper"); // Now that's intentional
    }
}

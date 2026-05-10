package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemInsulator extends Item {
    public ItemInsulator() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(64);

        this.setUnlocalizedName("itemInsulator");
        this.setTextureName(ExampleMod.MODID+":item_insulator");
    }
}

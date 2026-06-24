package me.creeper.creepermodtest.items.crushed;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemCrushedFineQuartz extends Item {
    public ItemCrushedFineQuartz() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(64);

        this.setUnlocalizedName("crushed_fine_quartz");
        this.setTextureName(ExampleMod.MODID+":item_crushed_fine_quartz");
    }
}

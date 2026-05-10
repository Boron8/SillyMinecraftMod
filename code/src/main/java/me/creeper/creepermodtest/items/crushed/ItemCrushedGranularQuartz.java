package me.creeper.creepermodtest.items.crushed;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemCrushedGranularQuartz extends Item {
    public ItemCrushedGranularQuartz() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(64);

        this.setUnlocalizedName("itemCrushedGranularQuartz");
        this.setTextureName(ExampleMod.MODID+":item_crushed_granular_quartz");
    }
}

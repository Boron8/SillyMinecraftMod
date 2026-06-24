package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemDenseCopper extends Item {
    public ItemDenseCopper() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setUnlocalizedName("dense_copper");
        this.setTextureName(ExampleMod.MODID + ":item_dense_copper");
    }
}

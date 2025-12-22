package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemMallirusGem extends Item {
    public ItemMallirusGem() {
        super();
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(16);

        this.setUnlocalizedName("itemMallirusGem");
        this.setTextureName(ExampleMod.MODID+":item_mallirus_gem");
    }
}

package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemTungstenIngot extends Item {
    public ItemTungstenIngot() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setUnlocalizedName("tungsten_ingot");
        this.setTextureName(ExampleMod.MODID + ":item_tungsten_ingot");
    }
}

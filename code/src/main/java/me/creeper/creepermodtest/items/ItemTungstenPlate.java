package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemTungstenPlate extends Item {
    public ItemTungstenPlate() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setUnlocalizedName("itemTungstenPlate");
        this.setTextureName(ExampleMod.MODID + ":item_tungsten_plate");
    }
}

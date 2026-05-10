package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;

public class ItemRedstoneWire extends Item {
    public ItemRedstoneWire() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(64);

        this.setUnlocalizedName("itemRedstoneWire");
        this.setTextureName(ExampleMod.MODID+":item_redstone_wire");
    }
}

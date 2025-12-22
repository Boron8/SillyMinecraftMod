package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.ItemFood;

public class ItemCheese extends ItemFood {
    static int food = 1;
    static float saturation = 0.0F;

    public ItemCheese() {
        super(food, saturation, false);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(32);
    }
}

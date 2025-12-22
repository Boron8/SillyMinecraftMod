package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.ItemFood;

public class ItemGrilledCheese extends ItemFood {
    static int food = 2;
    static float saturation = 0.5F;

    public ItemGrilledCheese() {
        super(food, saturation, false);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(32);
    }
}

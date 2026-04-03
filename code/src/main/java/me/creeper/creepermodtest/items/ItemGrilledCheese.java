package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.ItemFood;

public class ItemGrilledCheese extends ItemFood {
    static int food = 2;
    static float saturation = 0.5F;

    public ItemGrilledCheese() {
        // hunger saturation can_be_eaten_by_wolf
        super(food, saturation, false);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(32);

        this.setUnlocalizedName("itemGrilledCheese");
        this.setTextureName(ExampleMod.MODID+":item_grilled_cheese");
    }
}

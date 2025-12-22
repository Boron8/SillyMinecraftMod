package me.creeper.creepermodtest.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeWitherSkull {
    static ItemStack output_item = new ItemStack(Items.skull, 1, 1);
    static Object[] recipe = new Object[]{
            "CCC",
            "CSC",
            "CCC",
            'S', new ItemStack(Items.skull, 1, 0),
            'C', new ItemStack(Items.coal)
    };
}

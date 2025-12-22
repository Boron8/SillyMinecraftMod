package me.creeper.creepermodtest.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeNetherstar {
    static ItemStack output_item = new ItemStack(Items.nether_star);
    static Object[] recipe = new Object[]{
            "WWW",
            "SSS",
            "DSB",
            'W', new ItemStack(Items.skull, 1, 1), // 1x Wither skull
            'S', new ItemStack(Blocks.soul_sand),
            'D', new ItemStack(Items.diamond_sword),
            'B', new ItemStack(Items.bow)
    };
}

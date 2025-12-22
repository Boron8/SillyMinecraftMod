package me.creeper.creepermodtest.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeSkeletonSkull {
    static ItemStack output_item = new ItemStack(Items.skull, 1, 0); // 1x Skeleton skull
    static Object[] recipe = new Object[]{
            "MBM",
            "BBB",
            "MBM",
            'M', new ItemStack(Items.dye, 1, 15), // 1x Bone meal
            'B', new ItemStack(Items.bone)
    };
}

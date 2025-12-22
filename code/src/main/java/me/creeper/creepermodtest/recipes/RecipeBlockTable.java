package me.creeper.creepermodtest.recipes;

import me.creeper.creepermodtest.blocks.RegisterBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class RecipeBlockTable {
    static ItemStack output_item = new ItemStack(RegisterBlocks.blockTable);
    static Object[] recipe = new Object[]{"WWW",
                                          "W W",
                                          "W W",
                                          'W', new ItemStack(Blocks.planks)
    };
}

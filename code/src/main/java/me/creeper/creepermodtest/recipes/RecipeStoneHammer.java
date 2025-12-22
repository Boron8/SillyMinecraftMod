package me.creeper.creepermodtest.recipes;

import me.creeper.creepermodtest.blocks.RegisterBlocks;
import me.creeper.creepermodtest.items.RegisterItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeStoneHammer {
    static ItemStack output_item = new ItemStack(RegisterItems.itemStoneHammer);
    static Object[] recipe = new Object[]{
            "SSS",
            "SWS",
            " W ",
            'S', new ItemStack(Blocks.cobblestone),
            'W', new ItemStack(Items.stick)
    };
}

package me.creeper.creepermodtest.recipes;

import me.creeper.creepermodtest.blocks.RegisterBlocks;
import me.creeper.creepermodtest.items.RegisterItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeIronPlate {
    static ItemStack output_item = new ItemStack(RegisterItems.itemIronPlate);
    static Object[] recipe = new Object[]{
            new ItemStack(Items.iron_ingot),
            new ItemStack(RegisterItems.itemStoneHammer)
    };
}

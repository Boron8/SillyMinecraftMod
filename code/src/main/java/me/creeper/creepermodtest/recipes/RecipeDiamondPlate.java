package me.creeper.creepermodtest.recipes;

import me.creeper.creepermodtest.items.RegisterItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeDiamondPlate {
    static ItemStack output_item = new ItemStack(RegisterItems.itemDiamondPlate);
    static Object[] recipeIronHammer = new Object[]{
            new ItemStack(Items.diamond),
            new ItemStack(RegisterItems.itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)
    };
    static Object[] recipeDiamondHammer = new Object[]{
            new ItemStack(Items.diamond),
            new ItemStack(RegisterItems.itemDiamondHammer, 1, OreDictionary.WILDCARD_VALUE)
    };
}

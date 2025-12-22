package me.creeper.creepermodtest.recipes;

import me.creeper.creepermodtest.items.RegisterItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeDiamondPlate {
    static ItemStack output_item = new ItemStack(RegisterItems.itemDiamondPlate);
    static Object[] recipe = new Object[]{
            new ItemStack(Items.diamond),
            new ItemStack(RegisterItems.itemIronHammer)
    };
}

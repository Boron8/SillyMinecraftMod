package me.creeper.creepermodtest.recipes;

import me.creeper.creepermodtest.items.RegisterItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeDiamondHammer {
    static ItemStack output_item = new ItemStack(RegisterItems.itemDiamondHammer);
    static Object[] recipe = new Object[]{
            "DDD",
            "DSD",
            " S ",
            'D', new ItemStack(RegisterItems.itemDiamondPlate),
            'S', new ItemStack(Items.stick)
    };
}

package me.creeper.creepermodtest.recipes;

import me.creeper.creepermodtest.items.RegisterItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeCheese {
    static ItemStack output_item = new ItemStack(RegisterItems.itemCheese, 8);
    static Object[] recipe = new Object[]{"MMM",
                                          "MSM",
                                          "MMM",
                                          'M', new ItemStack(Items.milk_bucket),
                                          'S', new ItemStack(Items.sugar)
    };
}

package me.creeper.creepermodtest.recipes;

import me.creeper.creepermodtest.items.RegisterItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeIronHammer {
    static ItemStack output_item = new ItemStack(RegisterItems.itemIronHammer);
    static Object[] recipe = new Object[]{
            "III",
            "ISI",
            " S ",
            'I', new ItemStack(RegisterItems.itemIronPlate),
            'S', new ItemStack(Items.stick)
    };
}

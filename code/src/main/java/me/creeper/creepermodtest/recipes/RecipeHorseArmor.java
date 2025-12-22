package me.creeper.creepermodtest.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeHorseArmor {
    static class IronHorseArmor {
        static ItemStack output_item = new ItemStack(Items.iron_horse_armor);
        static Object[] recipe = new Object[]{
                "  I",
                "III",
                "I I",
                'I', new ItemStack(Items.iron_ingot)
        };
    }

    static class GoldHorseArmor {
        static ItemStack output_item = new ItemStack(Items.golden_horse_armor);
        static Object[] recipe = new Object[]{
                "  G",
                "GGG",
                "G G",
                'G', new ItemStack(Items.gold_ingot)
        };
    }

    static class DiamondHorseArmor {
        static ItemStack output_item = new ItemStack(Items.diamond_horse_armor);
        static Object[] recipe = new Object[]{
                "  D",
                "DDD",
                "D D",
                'D', new ItemStack(Items.diamond)
        };
    }
}

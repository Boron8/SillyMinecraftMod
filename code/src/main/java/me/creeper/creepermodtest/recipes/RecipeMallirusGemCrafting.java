package me.creeper.creepermodtest.recipes;

import me.creeper.creepermodtest.items.RegisterItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeMallirusGemCrafting {
    static class XP {
        static ItemStack output_item = new ItemStack(Items.experience_bottle, 8);
        static Object[] recipe = new Object[]{
                new ItemStack(RegisterItems.itemMallirusGem)
        };
    }

    static class Diamond {
        static ItemStack output_item = new ItemStack(Items.diamond, 1);
        static Object[] recipe = new Object[]{
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem)
        };
    }

    static class Enderpearl {
        static ItemStack output_item = new ItemStack(Items.ender_pearl, 4);
        static Object[] recipe = new Object[]{
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem)
        };
    }

    static class Skull {
        static ItemStack output_item = new ItemStack(Items.skull, 1);
        static Object[] recipe = new Object[]{
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem)
        };
    }

    static class Blazerod {
        static ItemStack output_item = new ItemStack(Items.blaze_rod, 8);
        static Object[] recipe = new Object[]{
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),

                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem)
        };
    }

    static class Sponge {
        static ItemStack output_item = new ItemStack(Blocks.sponge, 2);
        static Object[] recipe = new Object[]{
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),

                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem)
        };
    }

    static class Saddle {
        static ItemStack output_item = new ItemStack(Items.saddle, 1);
        static Object[] recipe = new Object[]{
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),

                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),

                new ItemStack(RegisterItems.itemMallirusGem)
        };
    }

    static class Nametag {
        static ItemStack output_item = new ItemStack(Items.name_tag, 1);
        static Object[] recipe = new Object[]{
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),

                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),

                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem)
        };
    }
    static class EGap {
        static ItemStack output_item = new ItemStack(Items.golden_apple, 1, 1);
        static Object[] recipe = new Object[]{
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),

                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),

                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem),
                new ItemStack(RegisterItems.itemMallirusGem)
        };
    }

}

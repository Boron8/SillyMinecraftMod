package me.creeper.creepermodtest.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class TestMultiRecipes {
    public static Map<Item, TestMultiRecipe> recipes = new HashMap<>();

    public static void registerAllRecipes() {
        //             In Item                  In-Amount                  Out Item         Out-Amount
        recipes.put(Items.coal,        new TestMultiRecipe((byte)6,    Items.iron_ingot,     (byte)1));
        recipes.put(Items.iron_ingot,  new TestMultiRecipe((byte)4,    Items.gold_ingot,     (byte)1));
        recipes.put(Items.gold_ingot,  new TestMultiRecipe((byte)3,    Items.emerald,        (byte)1));
        recipes.put(Items.emerald,     new TestMultiRecipe((byte)2,    Items.diamond,        (byte)1));
    }
}

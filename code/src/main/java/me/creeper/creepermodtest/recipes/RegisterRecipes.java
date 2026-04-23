package me.creeper.creepermodtest.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import me.creeper.creepermodtest.ExampleMod;

public class RegisterRecipes {
    public static void registerAllCrafting() {
        for (RecipeData recipe : ModRecipes.craftingRecipes) {
            if (recipe.shapeless) {
                GameRegistry.addShapelessRecipe(recipe.output, recipe.inputs);
            } else {
                GameRegistry.addShapedRecipe(recipe.output, recipe.inputs);
            }
        }
    }

    public static void registerAllSmelting() {
        for (RecipeData recipe : ModRecipes.smeltingRecipes) {
            GameRegistry.addSmelting(recipe.smeltInput, recipe.output, recipe.xp);
        }
    }

    public static void registerRecipes() {
        ExampleMod.debugLog("Registering recipes...");

        TestMultiRecipes.registerAllRecipes();

        ModRecipes.init();
        registerAllCrafting();
        registerAllSmelting();

        ExampleMod.debugLog("Registering recipes done.");
    }
}

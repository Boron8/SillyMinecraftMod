package me.creeper.creepermodtest.recipes;

import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterRecipes {
    public static class RegisterRecipesHandler {
        // Crafting
        public static void registerRecipeBlockTable() {
            GameRegistry.addShapedRecipe(RecipeBlockTable.output_item, RecipeBlockTable.recipe);
        }

        public static void registerRecipeCheese() {
            GameRegistry.addShapedRecipe(RecipeCheese.output_item, RecipeCheese.recipe);
        }

        public static void registerMallirusGemCrafting() {
            // XP
            GameRegistry.addShapelessRecipe(RecipeMallirusGemCrafting.XP.output_item, RecipeMallirusGemCrafting.XP.recipe);
            // Diamond
            GameRegistry.addShapelessRecipe(RecipeMallirusGemCrafting.Diamond.output_item, RecipeMallirusGemCrafting.Diamond.recipe);
            // Enderpearl
            GameRegistry.addShapelessRecipe(RecipeMallirusGemCrafting.Enderpearl.output_item, RecipeMallirusGemCrafting.Enderpearl.recipe);
            // Skull
            GameRegistry.addShapelessRecipe(RecipeMallirusGemCrafting.Skull.output_item, RecipeMallirusGemCrafting.Skull.recipe);
            // Blazerod
            GameRegistry.addShapelessRecipe(RecipeMallirusGemCrafting.Blazerod.output_item, RecipeMallirusGemCrafting.Blazerod.recipe);
            // Sponge
            GameRegistry.addShapelessRecipe(RecipeMallirusGemCrafting.Sponge.output_item, RecipeMallirusGemCrafting.Sponge.recipe);
            // Saddle
            GameRegistry.addShapelessRecipe(RecipeMallirusGemCrafting.Saddle.output_item, RecipeMallirusGemCrafting.Saddle.recipe);
            // Nametag
            GameRegistry.addShapelessRecipe(RecipeMallirusGemCrafting.Nametag.output_item, RecipeMallirusGemCrafting.Nametag.recipe);
            // EGap
            GameRegistry.addShapelessRecipe(RecipeMallirusGemCrafting.EGap.output_item, RecipeMallirusGemCrafting.EGap.recipe);
        }

        public static void registerWitherSkull() {
            GameRegistry.addShapedRecipe(RecipeWitherSkull.output_item, RecipeWitherSkull.recipe);
        }

        public static void registerSkeletonSkull() {
            GameRegistry.addShapedRecipe(RecipeSkeletonSkull.output_item, RecipeSkeletonSkull.recipe);
        }

        public static void registerRecipeNetherstar() {
            GameRegistry.addShapedRecipe(RecipeNetherstar.output_item, RecipeNetherstar.recipe);
        }

        public static void registerHorseArmor() {
            GameRegistry.addShapedRecipe(RecipeHorseArmor.IronHorseArmor.output_item, RecipeHorseArmor.IronHorseArmor.recipe);
            GameRegistry.addShapedRecipe(RecipeHorseArmor.GoldHorseArmor.output_item, RecipeHorseArmor.GoldHorseArmor.recipe);
            GameRegistry.addShapedRecipe(RecipeHorseArmor.DiamondHorseArmor.output_item, RecipeHorseArmor.DiamondHorseArmor.recipe);
        }

        public static void registerRecipeStoneHammer() {
            GameRegistry.addShapedRecipe(RecipeStoneHammer.output_item, RecipeStoneHammer.recipe);
        }

        public static void registerRecipeIronPlate() {
            GameRegistry.addShapelessRecipe(RecipeIronPlate.output_item, RecipeIronPlate.recipe);
        }

        public static void registerRecipeIronHammer() {
            GameRegistry.addShapedRecipe(RecipeIronHammer.output_item, RecipeIronHammer.recipe);
        }

        public static void registerRecipeDiamondPlate() {
            GameRegistry.addShapelessRecipe(RecipeDiamondPlate.output_item, RecipeDiamondPlate.recipe);
        }

        public static void registerRecipeDiamondHammer() {
            GameRegistry.addShapedRecipe(RecipeDiamondHammer.output_item, RecipeDiamondHammer.recipe);
        }





        // Smelting
        public static void registerRecipeGrilledCheese() {
            GameRegistry.addSmelting(RecipeGrilledCheese.input_item, RecipeGrilledCheese.output_item, RecipeGrilledCheese.xp);
        }

        public static void registerRecipeMallirusGem() {
            GameRegistry.addSmelting(RecipeMallirusGem.input_item, RecipeMallirusGem.output_item, RecipeMallirusGem.xp);
        }


        public static void registerAllRecipes() {
            // Crafting
            registerRecipeBlockTable();
            registerRecipeCheese();
            registerMallirusGemCrafting();
            registerWitherSkull();
            registerSkeletonSkull();
            registerRecipeNetherstar();
            registerHorseArmor();
            registerRecipeStoneHammer();
            registerRecipeIronPlate();
            registerRecipeIronHammer();
            registerRecipeDiamondPlate();
            registerRecipeDiamondHammer();


            // Smelting
            registerRecipeGrilledCheese();
            registerRecipeMallirusGem();
        }
    }
}

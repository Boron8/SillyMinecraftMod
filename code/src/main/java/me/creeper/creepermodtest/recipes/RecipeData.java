package me.creeper.creepermodtest.recipes;

import net.minecraft.item.ItemStack;

public class RecipeData {
    public ItemStack output;
    public Object[] inputs;
    public boolean shapeless;

    public ItemStack smeltInput;
    public float xp;

    public RecipeData(ItemStack output, Object[] inputs, boolean shapeless) {
        this.output = output;
        this.inputs = inputs;
        this.shapeless = shapeless;
    }
    public RecipeData(ItemStack output, Object[] inputs) {
        this.output = output;
        this.inputs = inputs;
        this.shapeless = false;
    }

    public RecipeData(ItemStack output, ItemStack input, float xp) {
        this.output = output;
        this.smeltInput = input;
        this.xp = xp;
    }
}

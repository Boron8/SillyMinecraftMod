package me.creeper.creepermodtest.recipes;

import net.minecraft.item.Item;

public class TestMultiRecipe {
    public final int inputAmount; // Don't do byte, we prefer to save tiny cpu over tiny mem
    public final Item outputItem;
    public final int outputAmount;


    public TestMultiRecipe(int inputAmount, Item outputItem, int outputAmount) {
        this.inputAmount = inputAmount;
        this.outputItem = outputItem;
        this.outputAmount = outputAmount;
    }
}

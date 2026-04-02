package me.creeper.creepermodtest.items.tools;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class itemStoneHammer extends Item {
    public itemStoneHammer() {
        super();
        this.setMaxStackSize(1);
        this.setMaxDamage(64);

        this.setUnlocalizedName("stoneHammer");
        this.setTextureName(ExampleMod.MODID+":item_stone_hammer");

        this.setCreativeTab(ExampleMod.tabCreepermodtest);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        stack.setItemDamage(stack.getItemDamage() + 1);

        if (stack.getItemDamage() < 0) { return new ItemStack(Blocks.air); }

        return stack;
    }

    @Override
    public boolean hasContainerItem() {
        return true;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack item) {
        return false;
    }
}

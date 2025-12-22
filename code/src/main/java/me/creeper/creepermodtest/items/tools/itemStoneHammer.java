package me.creeper.creepermodtest.items.tools;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class itemStoneHammer extends Item {
    public itemStoneHammer() {
        super();
        this.setMaxStackSize(1);
        this.setMaxDamage(64);
        this.setUnlocalizedName("stoneHammer");
        this.setTextureName("minecraft:stone_pickaxe");
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        stack.setItemDamage(1);
        return stack;
    }

    @Override
    public boolean hasContainerItem() {
        return true;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack p_77630_1_) {
        return false;
    }
}

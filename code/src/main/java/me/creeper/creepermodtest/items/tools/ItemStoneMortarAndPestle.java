package me.creeper.creepermodtest.items.tools;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemStoneMortarAndPestle extends Item {
    public ItemStoneMortarAndPestle() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(1);
        this.setMaxDamage(127);

        this.setUnlocalizedName("stone_mortar_and_pestle");
        this.setTextureName(ExampleMod.MODID+":item_stone_mortar_and_pestle");
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        stack.setItemDamage(stack.getItemDamage() + 1);

        if (stack.getItemDamage() < 0) { return new ItemStack(Blocks.air); }

        return stack;
    }

    @Override
    public boolean hasContainerItem() { return true; }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack item) { return false; }
}

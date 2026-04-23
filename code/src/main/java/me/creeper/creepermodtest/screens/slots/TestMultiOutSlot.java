package me.creeper.creepermodtest.screens.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class TestMultiOutSlot extends Slot {
    private EntityPlayer player;

    public TestMultiOutSlot(EntityPlayer player, IInventory playerInv, int ID, int xpos, int ypos) {
        super(playerInv, ID, xpos, ypos);
        this.player = player;
    }

    @Override
    public boolean isItemValid(ItemStack item) { return false; }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack item) {
        this.onCrafting(item);
        super.onPickupFromSlot(player, item);
    }

    @Override
    protected void onCrafting(ItemStack item, int amount) { this.onCrafting(item); }

    @Override
    protected void onCrafting(ItemStack itemStack) {
        itemStack.onCrafting(player.worldObj, player, itemStack.stackSize);
    }
}

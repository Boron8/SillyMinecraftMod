package me.creeper.creepermodtest.multiblocks.testMulti;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.creeper.creepermodtest.screens.slots.TestMultiOutSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTestMulti extends Container {
    private TileEntityTestMultiController tile;
    private InventoryPlayer playerInv;

    public ContainerTestMulti(InventoryPlayer playerInv, TileEntityTestMultiController tile) {
        this.tile = tile;
        this.playerInv = playerInv;

        // 6 - 5

        this.addSlotToContainer(new Slot(tile, 0, 56-18, 35));
        this.addSlotToContainer(new TestMultiOutSlot(playerInv.player, tile, 1, 116, 35));


        // Inv
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlotToContainer(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // Hotbar
        for (int col = 0; col < 9; col++) {
            addSlotToContainer(new Slot(playerInv, col, 8 + col * 18, 142));
        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting crafter) {
        super.addCraftingToCrafters(crafter);

        crafter.sendProgressBarUpdate(this, 0, tile.recipeTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            icrafting.sendProgressBarUpdate(this, 0, tile.recipeTime);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        if (id == 0) {
            tile.recipeTime = value;
        }
    }


    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tile.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack remainder = null;
        Slot slot = (Slot)this.inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            remainder = stack.copy();

            if (slotIndex < 2) {
                if (!this.mergeItemStack(stack, 2, this.inventorySlots.size(), true)) {
                    return null;
                }
            } else {
                if (!this.mergeItemStack(stack, 0, 1, false)) {
                    return null;
                }
            }

            if (stack.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChange(stack, remainder);
            }
        }

        return remainder;
    }
}

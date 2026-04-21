package me.creeper.creepermodtest.multiblocks.testMulti;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTestMultiController extends TileEntity implements IInventory {
    private ItemStack[] inventory = new ItemStack[2]; // In+Out

    public int recipeTime;
    public static final int maxRecipeTime = 100;

    private boolean isFormed = false;

    public boolean checkStructure() {
        Block blockAbove = worldObj.getBlock(xCoord, yCoord + 1, zCoord);
        if (blockAbove == Blocks.stone) {
            isFormed = true;
            return true;
        } else {
            invalidateStructure();
            return false;
        }
    }

    public void invalidateStructure() {
        isFormed = false;
    }

    @Override
    public void updateEntity() {
        if (worldObj.isRemote) { // Client side
            // Client logic...
            return;
        }

        // server Side
        if (ExampleMod.getServerCounter().getCount() % 100 == 0) {
            checkStructure();
        }

        if (isFormed) {
            boolean wasProcessing = this.recipeTime > 0;
            boolean changed = false;

            if (canProcessRecipe()) {
                recipeTime++;
                if (recipeTime >= maxRecipeTime) {
                    recipeTime = 0;
                    processRecipe();
                    changed = true;
                }
            } else {
                recipeTime = 0;
            }
            if (wasProcessing != (recipeTime > 0)) {
                changed = true;
            }
            if (changed) {
                this.markDirty();
            }
        } else if (recipeTime > 0) {
            // Decrease by 2 | 1 if 1 left
            if (recipeTime > 1) recipeTime -= 1;
            recipeTime -= 1;

            markDirty();
        }
    }

    private boolean canProcessRecipe() {
        if (inventory[0] == null) return false;

        ItemStack result = getRecipeResult(inventory[0]);
        if (result == null) return false;

        if (inventory[1] == null) return true;

        if (!inventory[1].isItemEqual(result)) return false;

        int combined = inventory[1].stackSize + result.stackSize;
        return combined <= inventory[1].getMaxStackSize();
    }

    private void processRecipe() {
        if (!canProcessRecipe()) return;

        ItemStack result = getRecipeResult(inventory[0]);
        if (result == null) return;

        if (inventory[1] == null) {
            inventory[1] = result.copy();
        } else if (inventory[1].isItemEqual(result)){
            inventory[1].stackSize += result.stackSize;
        }

        inventory[0].stackSize--;

        if (inventory[0].stackSize <= 0) {
            inventory[0] = null;
        }
    }

    private ItemStack getRecipeResult(ItemStack input) {
        if (input.getItem() == Items.iron_ingot) {
            return new ItemStack(Items.gold_ingot);
        }
        return null;
    }











    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if (inventory[slot] != null) {
            ItemStack itemstack;

            if (inventory[slot].stackSize <= amount) {
                itemstack = inventory[slot];
                inventory[slot] = null;
                markDirty();
                return itemstack;
            } else {
                itemstack = inventory[slot].splitStack(amount);

                if (inventory[slot].stackSize == 0) {
                    inventory[slot] = null;
                }

                markDirty();
                return itemstack;
            }
        } else {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int slot) {
        if (inventory[slot] != null) {
            ItemStack itemstack = inventory[slot];
            inventory[slot] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory[slot] = stack;

        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }

        markDirty();
    }

    @Override
    public String getInventoryName() {
        return "container.testmulticontroller";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
                player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64.0;
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return slot == 0;
    }





    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        inventory = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < inventory.length) {
                inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        recipeTime = nbt.getShort("RecipeTime");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < inventory.length; ++i) {
            if (inventory[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                inventory[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbt.setTag("Items", nbttaglist);

        nbt.setShort("RecipeTime", (short)this.recipeTime);
    }
}

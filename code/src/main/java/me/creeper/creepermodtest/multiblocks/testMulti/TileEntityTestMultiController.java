package me.creeper.creepermodtest.multiblocks.testMulti;

import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.recipes.TestMultiRecipe;
import me.creeper.creepermodtest.recipes.TestMultiRecipes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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
        int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        int xOffset = 0;
        int zOffset = 0;
        switch (meta) {
            case 0:
                zOffset = 1;
                break;
            case 1:
                xOffset = -1;
                break;
            case 2:
                zOffset = -1;
                break;
            case 3:
                xOffset = 1;
                break;
        }

        Block blockBehind = worldObj.getBlock(xCoord+xOffset, yCoord, zCoord+zOffset);

        if (blockBehind == Blocks.gold_block) {
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
            recipeTime = Math.max(0, recipeTime - 2);

            markDirty();
        }
    }

    private boolean canProcessRecipe() {
        if (inventory[0] == null) return false;

        TestMultiRecipe recipe = getRecipe(inventory[0]);
        if (recipe == null) return false;

        if (inventory[0].stackSize < recipe.inputAmount) return false;

        if (inventory[1] == null) return true;

        ItemStack result = new ItemStack(recipe.outputItem, recipe.outputAmount);
        if (!inventory[1].isItemEqual(result)) return false;

        return inventory[1].stackSize + recipe.outputAmount <= inventory[1].getMaxStackSize();
    }

    private void processRecipe() {
        if (!canProcessRecipe()) return;

        TestMultiRecipe recipe = getRecipe(inventory[0]);
        if (recipe == null) return;

        inventory[0].stackSize -= recipe.inputAmount;
        if (inventory[0].stackSize <= 0) inventory[0] = null;

        if (inventory[1] == null)  {
            inventory[1] = new ItemStack(recipe.outputItem, recipe.outputAmount);
        } else {
            inventory[1].stackSize += recipe.outputAmount;
        }

        this.markDirty();
    }

    private TestMultiRecipe getRecipe(ItemStack input) {
        if (input == null) return null;
        return TestMultiRecipes.recipes.get(input.getItem());
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

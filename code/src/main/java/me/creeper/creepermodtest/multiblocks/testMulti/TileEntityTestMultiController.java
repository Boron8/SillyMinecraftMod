package me.creeper.creepermodtest.multiblocks.testMulti;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;

public class TileEntityTestMultiController extends TileEntity {
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
        if (worldObj.isRemote) return;

        if (ExampleMod.getServerCounter().getCount()%100 == 0) {
            checkStructure();
        }

        if (isFormed) {
            if (ExampleMod.getServerCounter().getCount()%100 == 0) {
                try {
                    ((EntityPlayerMP)MinecraftServer.getServer().getConfigurationManager().playerEntityList.get(0)).addChatMessage(new ChatComponentText("Something happens now."));
                } catch (Exception e) {}
            }
        }
    }
}

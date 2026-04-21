package me.creeper.creepermodtest.handlers;

import cpw.mods.fml.common.network.IGuiHandler;
import me.creeper.creepermodtest.multiblocks.testMulti.ContainerTestMulti;
import me.creeper.creepermodtest.multiblocks.testMulti.GuiTestMulti;
import me.creeper.creepermodtest.multiblocks.testMulti.TileEntityTestMultiController;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    public static final int TEST_MULTI_ID = 0;


    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == TEST_MULTI_ID) {
            TileEntity tile = world.getTileEntity(x, y, z);
            if (tile instanceof TileEntityTestMultiController) {
                return new ContainerTestMulti(player.inventory, (TileEntityTestMultiController)tile);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == TEST_MULTI_ID) {
            TileEntity tile = world.getTileEntity(x, y, z);
            if (tile instanceof TileEntityTestMultiController) {
                return new GuiTestMulti(new ContainerTestMulti(player.inventory, (TileEntityTestMultiController)tile), (TileEntityTestMultiController) tile);
            }
        }
        return null;
    }
}

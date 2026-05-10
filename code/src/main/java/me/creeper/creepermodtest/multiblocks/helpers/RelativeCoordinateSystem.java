package me.creeper.creepermodtest.multiblocks.helpers;

import me.creeper.creepermodtest.multiblocks.BlockMeta;
import net.minecraft.world.World;

public class RelativeCoordinateSystem {
    public static BlockMeta getRelativeBlock(
                                             int relX, int relY, int relZ,
                                             int xCoord, int yCoord, int zCoord,
                                             World worldObj) {

        int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

        int worldX = xCoord;
        int worldY = yCoord + relY;
        int worldZ = zCoord;

        int forwardX = 0, forwardZ = 0;
        int rightX = 0, rightZ = 0;

        switch (meta) {
            case 2: // NORTH
                forwardZ = 1;
                rightX = 1;
                break;
            case 3: // EAST
                forwardX = -1;
                rightZ = 1;
                break;
            case 4: // SOUTH
                forwardZ = -1;
                rightX = -1;
                break;
            case 5: // WEST
                forwardX = 1;
                rightZ = -1;
                break;
        }

        int offsetX = rightX * relX + forwardX * relZ;
        int offsetZ = rightZ * relX + forwardZ * relZ;

        worldX += offsetX;
        worldZ += offsetZ;

        return new BlockMeta(worldObj.getBlock(worldX, worldY, worldZ), worldObj.getBlockMetadata(worldX, worldY, worldZ));
    }
}

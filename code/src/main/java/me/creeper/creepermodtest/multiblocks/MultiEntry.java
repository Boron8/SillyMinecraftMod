package me.creeper.creepermodtest.multiblocks;

import net.minecraft.block.Block;

public class MultiEntry {
    public final int x, y, z;
    public final Block block;
    public final int meta;

    public MultiEntry(int x, int y, int z, Block block, int meta) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.block = block;
        this.meta = meta;
    }
}

package me.creeper.creepermodtest.energy.network;

import me.creeper.creepermodtest.energy.api.TEEnergyHandler;
import net.minecraft.block.Block;

public class NetworkBlock {
    private final TEEnergyHandler TEEnergyHandler;
    private final Block block;
    public final int x;
    public final int y;
    public final int z;

    public NetworkBlock(TEEnergyHandler TEEnergyHandler, Block block, int x, int y, int z) {
        this.TEEnergyHandler = TEEnergyHandler;
        this.block = block;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public TEEnergyHandler getTEEnergyHandler() { return this.TEEnergyHandler; }
    public Block getBlock() { return this.block; }
}

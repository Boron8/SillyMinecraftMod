package me.creeper.creepermodtest.generation;

import cpw.mods.fml.common.IWorldGenerator;
import me.creeper.creepermodtest.blocks.RegisterBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class MallirusOreGeneration implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 1:
                generateEnd(world, random, chunkX, chunkZ);
                break;
            case 0:
                generateOverworld(world, random, chunkX, chunkZ);
                break;
            case -1:
                generateNether(world, random, chunkX, chunkZ);
                break;
        }
    }

    public void generateEnd(World world, Random rand, int x, int z) {
        // ID:1
    }

    public void generateOverworld(World world, Random rand, int x, int z) {
        // ID:0
        GenerateOre.generateOre(RegisterBlocks.blockMallirusOre, world, rand, x, z, 2, 10, 98, 0, 70, Blocks.stone);
    }

    public void generateNether(World world, Random rand, int x, int z) {
        // ID:-1
    }
}

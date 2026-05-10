package me.creeper.creepermodtest.blocks;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDenseCopperTube extends Block {
    public BlockDenseCopperTube() {
        super(Material.iron);

        this.setHardness(3F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setBlockName("blockDenseCopperTube");
        this.setBlockTextureName(ExampleMod.MODID+":block_dense_copper_tube");
    }
}

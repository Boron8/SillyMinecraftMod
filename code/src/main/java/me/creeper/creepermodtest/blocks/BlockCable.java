package me.creeper.creepermodtest.blocks;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCable extends Block {
    protected BlockCable() {
        super(Material.iron);

        this.setHardness(1.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setBlockName("blockCable");
        this.setBlockTextureName(ExampleMod.MODID+":block_cable");
    }
}

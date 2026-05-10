package me.creeper.creepermodtest.blocks;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCopperOre extends Block {
    public BlockCopperOre() {
        super(Material.rock);

        this.setHardness(2.5F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setBlockName("blockCopperOre");
        this.setBlockTextureName(ExampleMod.MODID+":block_copper_ore");
    }
}

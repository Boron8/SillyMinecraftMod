package me.creeper.creepermodtest.blocks;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTestMultiCasing extends Block {
    public BlockTestMultiCasing() {
        super(Material.iron);

        this.setHardness(4.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setBlockName("test_multi_casing");
        this.setBlockTextureName(ExampleMod.MODID+":block_test_multi_controller_side");
    }

    @Override
    public boolean isOpaqueCube() { return false; }
}

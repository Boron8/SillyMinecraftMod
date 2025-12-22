package me.creeper.creepermodtest.blocks;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTable extends Block {
    protected BlockTable() {
        super(Material.wood);

        this.setHardness(2.0F);
        this.setHarvestLevel("axe", 1);
        this.setLightLevel(0.1F);
        this.setStepSound(soundTypeWood);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}

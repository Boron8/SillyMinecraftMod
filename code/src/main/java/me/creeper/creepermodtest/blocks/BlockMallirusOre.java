package me.creeper.creepermodtest.blocks;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMallirusOre extends Block {
    protected BlockMallirusOre() {
        super(Material.rock);

        this.setHardness(2.5F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
    }
}

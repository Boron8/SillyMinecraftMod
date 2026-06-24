package me.creeper.creepermodtest.blocks;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTungstenOre extends Block {
    public BlockTungstenOre() {
        super(Material.rock);

        this.setHardness(4F);
        this.setHarvestLevel("pickaxe", 3);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setBlockName("tungsten_ore");
        this.setBlockTextureName(ExampleMod.MODID+":block_tungsten_ore");
    }
}

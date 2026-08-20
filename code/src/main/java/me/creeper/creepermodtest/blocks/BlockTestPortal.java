package me.creeper.creepermodtest.blocks;

import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.blocks.tileEntities.TETestPortal;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTestPortal extends BlockContainer {
    public BlockTestPortal() {
        super(Material.portal);

        //this.setHardness(0.0F);
        //this.setHarvestLevel("pickaxe", 1);
        this.setLightLevel(1.0F);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setBlockName("test_portal");
        this.setBlockTextureName("minecraft:air"); // TODO: fully transparent texture
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TETestPortal();
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }
}

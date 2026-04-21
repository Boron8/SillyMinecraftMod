package me.creeper.creepermodtest.multiblocks.testMulti;

import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.handlers.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTestMultiController extends BlockContainer {
    public BlockTestMultiController() {
        super(Material.iron);

        this.setHardness(3.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setBlockName("blockTestMultiController");
        this.setBlockTextureName(ExampleMod.MODID+":block_test_multi_controller");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityTestMultiController();
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
        super.onBlockPlacedBy(world, x, y, z, player, stack);

        if (world.isRemote) return;

        TileEntity te = world.getTileEntity(x, y, z);
        if (te instanceof  TileEntityTestMultiController) {
            ((TileEntityTestMultiController) te).checkStructure();
        }
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta)  {
        TileEntity te = world.getTileEntity(x, y, z);
        if (te instanceof  TileEntityTestMultiController) {
            ((TileEntityTestMultiController) te).invalidateStructure();
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        TileEntity te = world.getTileEntity(x, y, z);
        if (te instanceof  TileEntityTestMultiController) {
            ((TileEntityTestMultiController) te).checkStructure();
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            player.openGui(ExampleMod.getInstance(), GuiHandler.TEST_MULTI_ID, world, x, y, z);
            // register + fix, Bye,
        }
        return true;
    }
}

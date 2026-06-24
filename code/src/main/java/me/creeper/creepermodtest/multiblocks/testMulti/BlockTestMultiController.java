package me.creeper.creepermodtest.multiblocks.testMulti;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.handlers.GuiHandler;
import me.creeper.creepermodtest.multiblocks.helpers.FacingHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockTestMultiController extends BlockContainer {
    @SideOnly(Side.CLIENT)
    private IIcon frontIcon;
    @SideOnly(Side.CLIENT)
    private IIcon sideIcon;


    public BlockTestMultiController() {
        super(Material.iron);

        this.setHardness(3.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setBlockName("test_multi_controller");
        this.setBlockTextureName(ExampleMod.MODID+":block_test_multi_controller_side");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityTestMultiController();
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
        super.onBlockPlacedBy(world, x, y, z, player, stack);

        int direction = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, direction, 2);

        if (world.isRemote) return;

        TileEntity te = world.getTileEntity(x, y, z);
        if (te instanceof  TileEntityTestMultiController) {
            ((TileEntityTestMultiController) te).checkStructure();
        }
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        return meta;
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

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            player.openGui(ExampleMod.getInstance(), GuiHandler.TEST_MULTI_ID, world, x, y, z);
            // register + fix, Bye, <-- uh, forgot to delete lol
        }
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {
        this.sideIcon        = reg.registerIcon(ExampleMod.MODID + ":block_test_multi_controller_side" );
        this.frontIcon       = reg.registerIcon(ExampleMod.MODID + ":block_test_multi_controller_front");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {  // TODO active meta/state thing  texture tile
        int facing = FacingHelper.getFacingFromMeta(meta);

        if (side == facing) {
            return frontIcon;
        }

        return sideIcon;
    }
}

package me.creeper.creepermodtest.blocks;

import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBerryBush extends Block {

    public static final int EMPTY = 6;
    public static final int EARLY = 7;
    public static final int OPTIMAL = 8;
    public static final int LATE = 9;

    public static final int MIN_EXTRA = 1;
    public static final int MAX_EXTRA = 3;
    public static final int BASE_DROP = 2;


    public BlockBerryBush() {
        super(Material.plants);

        this.setHardness(0.2F);
        this.setStepSound(soundTypeGlass);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);

        this.setBlockName("berry_bush");
        this.setBlockTextureName(ExampleMod.MODID+":block_berry_bush");
        this.setTickRandomly(true);
    }

    @Override
    public boolean isOpaqueCube() { return false; }

    @Override
    public boolean renderAsNormalBlock() { return false; }

    @Override
    public int getRenderType() {
        return 1;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        int meta = world.getBlockMetadata(x, y, z);

        // 0-5 growing
        // 6 empty
        // 7 early harvest
        // 8 optimal harvest
        // 9 late harvest
        if (meta <= 9) {
            world.setBlockMetadataWithNotify(x, y, z, meta + 1, 2);
        }
    }

    @Override
    public Item getItemDropped(int meta, Random rand, int fortune) {
        if (meta >= EARLY) {
            return ModItems.itemGoldBerry;
        }

        return null;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random rand) {
        int extra = 0;
        if (meta == OPTIMAL) {
            extra = rand.nextInt(MAX_EXTRA - MIN_EXTRA + 1) + MAX_EXTRA;
        }

        return BASE_DROP + extra + fortune;
    }

    @Override
    public boolean onBlockActivated(World world,
                                    int x, int y, int z,
                                    EntityPlayer player,
                                    int side,
                                    float hitX, float hitY, float hitZ) {

        int meta = world.getBlockMetadata(x, y, z);

        if (!world.isRemote && meta > EARLY) {
            int count = this.quantityDropped(meta, 0, world.rand);

            if (count > 0) {
                Item item = this.getItemDropped(meta, world.rand, 0);
                world.spawnEntityInWorld(new EntityItem(
                        world, x + 0.5, y + 1, x + 0.5,
                        new ItemStack(item, count)
                ));

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean getTickRandomly() {
        return true;
    }
}

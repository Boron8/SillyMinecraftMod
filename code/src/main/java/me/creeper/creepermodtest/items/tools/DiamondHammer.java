package me.creeper.creepermodtest.items.tools;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class DiamondHammer extends ItemPickaxe {
    public static final ToolMaterial DIAMOND_HAMMER = EnumHelper.addToolMaterial(
            "DIAMOND_HAMMER",
            3,
            2000,
            9.0f,
            4.0f,
            12
    );

    public DiamondHammer(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName("diamondHammer");
        this.setTextureName("minecraft:diamond_pickaxe");
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase player) {
        if (world.isRemote) return true;
        if (player.isSneaking()) return true;

        MovingObjectPosition movingObjectPosition = this.getMovingObjectPositionFromPlayer(world, (EntityPlayer) player, false);
        if (movingObjectPosition == null) return true;

        int sideHit = movingObjectPosition.sideHit;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int blockX = x;
                int blockY = y;
                int blockZ = z;

                if (sideHit == 0 || sideHit == 1) {
                    blockX += dx;
                    blockZ += dy;
                } else if (sideHit == 2 || sideHit == 3) {
                    blockX += dx;
                    blockY += dy;
                } else if (sideHit == 4 || sideHit == 5) {
                    blockZ += dx;
                    blockY += dy;
                }

                Block target = world.getBlock(blockX, blockY, blockZ);

                if (target == null || target.isAir(world, blockX, blockY, blockZ)) continue;

                // func_147480_a = Break and Drop block
                world.func_147480_a(blockX, blockY, blockZ, true);
                stack.damageItem(1, player);
            }
        }
        return true;
    }
}

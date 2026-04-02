package me.creeper.creepermodtest.items.tools;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.server.management.ItemInWorldManager;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class DiamondHammer extends ItemPickaxe {
    public static boolean isBreaking = false;

    // Same as default diamond (EMERALD internally), but *9 maxUses
    public static final ToolMaterial DIAMOND_HAMMER = EnumHelper.addToolMaterial(
            "DIAMOND_HAMMER",
            3,
            14049,
            8.0f,
            3.0f,
            10
    );

    public DiamondHammer() {
        super(DIAMOND_HAMMER);
        this.setUnlocalizedName("diamondHammer");
        this.setTextureName(ExampleMod.MODID+":item_diamond_hammer");
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
        if (isBreaking) return true;

        if (!(entity instanceof EntityPlayer)) return true;
        EntityPlayer player = (EntityPlayer) entity;

        if (world.isRemote) return true;
        if (player.isSneaking()) {
            stack.damageItem(1, player);
            return true;
        };


        isBreaking = true;

        MovingObjectPosition movingObjectPosition = this.getMovingObjectPositionFromPlayer(world, (EntityPlayer) player, false);
        if (movingObjectPosition == null) return true;

        int sideHit = movingObjectPosition.sideHit;

        ItemInWorldManager itemInWorldManager = ((EntityPlayerMP) player).theItemInWorldManager;

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

                if (target.getBlockHardness(world, blockX, blockY, blockZ) < 0) continue;

                // func_147480_a = Break and Drop block naturally
                //world.func_147480_a(blockX, blockY, blockZ, true);

                itemInWorldManager.tryHarvestBlock(blockX, blockY, blockZ);

                stack.damageItem(1, player);
            }
        }
        isBreaking = false;
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        stack.setItemDamage(stack.getItemDamage() + 1);

        if (stack.getItemDamage() < 0) { return new ItemStack(Blocks.air); }

        return stack;
    }

    @Override
    public boolean hasContainerItem() { return true; }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack item) { return false; }
}

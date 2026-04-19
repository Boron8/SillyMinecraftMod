package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemExplodingBallSummoner extends Item {
    public ItemExplodingBallSummoner() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(1);

        this.setUnlocalizedName("itemExplodingBallSummoner");
        this.setTextureName("minecraft:blaze_rod");

        this.setMaxDamage(3); // 4
    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        for (int i = 0; i < 5; i++) {
            world.playSound(player.posX, player.posY, player.posZ, "random.pop", 1.0f, 0.0f, false);
        }
        for (int i = 0; i < 5; i++) {
            world.playSound(player.posX, player.posY, player.posZ, "random.pop", 1.0f, 1f, false);
        }
        for (int i = 0; i < 5; i++) {
            world.playSound(player.posX, player.posY, player.posZ, "random.pop", 1.0f, 2f, false);
        }

        if (!world.isRemote) { // SERVER-SIDE
            player.addChatMessage(new ChatComponentText("Summoning exploding balls..."));

            double x = ExampleMod.mc.thePlayer.rayTrace(1000, 0.0f).hitVec.xCoord;
            double y = world.getHeight() - 2;
            double z = ExampleMod.mc.thePlayer.rayTrace(1000, 0.0f).hitVec.zCoord;

            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 4; j++) {
                    EntityLargeFireball fireball = new EntityLargeFireball(world, player, 0, 0, 0);
                    fireball.accelerationX = 0;
                    fireball.accelerationY = -0.05;
                    fireball.accelerationZ = 0;
                    fireball.motionX = 0;
                    fireball.motionY = 0;
                    fireball.motionZ = 0;
                    double xOffset = -15 + (15 - (-15)) * ExampleMod.random.nextDouble();
                    double zOffset = -15 + (15 - (-15)) * ExampleMod.random.nextDouble();
                    fireball.setPosition(x + xOffset, y-j*3, z + zOffset);
                    fireball.field_92057_e = 3; // Explosion power

                    world.spawnEntityInWorld(fireball);
                }
            }

            item.damageItem(1, player);
        }
        return item;
    }
}

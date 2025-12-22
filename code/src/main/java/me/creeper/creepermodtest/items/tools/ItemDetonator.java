package me.creeper.creepermodtest.items.tools;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemDetonator extends Item {
    public ItemDetonator() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("itemDetonator");
        this.setTextureName("minecraft:stick");
        this.setMaxDamage(7);
    }



    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        for (int i = 0; i < 5; i++) {
            world.playSound(player.posX, player.posY, player.posZ, "random.pop", 1.0f, 0.0f, false);
        }
        for (int i = 0; i < 5; i++) {
            world.playSound(player.posX, player.posY, player.posZ, "random.pop", 1.0f, 1f, false);
        }
        for (int i = 0; i < 5; i++) {
            world.playSound(player.posX, player.posY, player.posZ, "random.pop", 1.0f, 2f, false);
        }

        if (!world.isRemote) {
            player.addChatMessage(new ChatComponentText("Detonated"));

            Minecraft mc = Minecraft.getMinecraft();

            double x = mc.thePlayer.rayTrace(1000, 0.0f).hitVec.xCoord;
            double y = mc.thePlayer.rayTrace(1000, 0.0f).hitVec.yCoord;
            double z = mc.thePlayer.rayTrace(1000, 0.0f).hitVec.zCoord;

            for (int i = 0; i < 20; i++) {
                int xOffset = ExampleMod.random.nextInt(21)-10;
                int yOffset = ExampleMod.random.nextInt(21)-10;
                int zOffset = ExampleMod.random.nextInt(21)-10;

                world.createExplosion(player, x+xOffset, y+yOffset, z+zOffset, 5f, true);
            }

            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 2; j++) {
                    int xOffset = ExampleMod.random.nextInt(2); // 0 1
                    int zOffset = ExampleMod.random.nextInt(2); // 0 1

                    float strengthOffset = ExampleMod.random.nextFloat() * 2.0f;


                    world.createExplosion(player, x+xOffset, y-i*3, z+zOffset, 5f+strengthOffset, true);
                }
            }

            itemStack.damageItem(1, player);
        }

        return itemStack;
    }
}

package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.renderers.CloudRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTest extends Item {
    public ItemTest() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(64);
    }

    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        return false;
    }
}

package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTest extends Item {
    public ItemTest() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(64);

        this.setUnlocalizedName("test");
        this.setTextureName(ExampleMod.MODID+":item_test");
    }

    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        return false;
    }
}

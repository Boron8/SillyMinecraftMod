package me.creeper.creepermodtest.items;

import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.items.templates.MagicItem;
import me.creeper.creepermodtest.unknownFont.UnknownFontConverter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemEntrance extends MagicItem {
    public ItemEntrance() {
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(1);

        this.setUnlocalizedName("entrance");
        this.setTextureName(ExampleMod.MODID+":item_entrance");
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (!world.isRemote) return false;
        player.addChatMessage(new ChatComponentText(UnknownFontConverter.stringToUnknown("526")+" = Entrance" + "  -U"));
        return true;
    }
}

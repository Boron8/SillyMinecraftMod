package me.creeper.creepermodtest.items.food;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemGoldBerry extends ItemFood {
    static int food = 2;
    static float saturation = 3.0F;

    public ItemGoldBerry() {
        super(food, saturation, false);

        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(64);

        this.setUnlocalizedName("gold_berry");
        this.setTextureName(ExampleMod.MODID+":item_gold_berry");
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        int speed = Math.round(((float)stack.stackSize)/2 *4);

        if (speed <= 0) {
            speed = 1;
        }

        return speed;
    }
}

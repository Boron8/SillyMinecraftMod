package me.creeper.creepermodtest.items.tools;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ItemTungstenSword extends ItemSword {

    public static final ToolMaterial TUNGSTEN_SWORD = EnumHelper.addToolMaterial(
            "TUNGSTEN_SWORD",
            3,
            2000,
            8.0f,
            5.0f,
            5
    );

    public ItemTungstenSword() {
        super(TUNGSTEN_SWORD);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("tungsten_sword");
        this.setTextureName("minecraft:stick");
        this.setMaxDamage(2000);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        NBTTagCompound root = stack.getTagCompound();
        if (root != null && root.hasKey("ctm")) {
            NBTTagCompound ctm = root.getCompoundTag("ctm");

            if (ctm != null) {
                if (ctm.getBoolean("lifesteal")) {
                    if (ExampleMod.random.nextFloat() < 0.25F) { // 25%
                        attacker.heal(1.0F);
                    }
                }
                if (ctm.getBoolean("nightlight")) {
                    attacker.addPotionEffect(new PotionEffect(
                            Potion.nightVision.id,
                            10*20,
                            0
                    ));
                }
            }
        }

        return super.hitEntity(stack, target, attacker);
    }
}

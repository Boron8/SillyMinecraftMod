package me.creeper.creepermodtest.items.armor;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class MallirusArmor extends ItemArmor {
    public static ItemArmor.ArmorMaterial MALLIRUS_ARMOR_MATERIAL =
            EnumHelper.addArmorMaterial(
                    "MALLIRUS_ARMOR",
                    25,
                    new int[]{2, 5, 7, 2},
                    15
            );

    public MallirusArmor(ItemArmor.ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
        this.setCreativeTab(ExampleMod.tabCreepermodtest);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (this.armorType == 2) {
            return "creepertestmod:textures/models/armor/mallirus_armor_layer_2.png";
        }
        return "creepertestmod:textures/models/armor/mallirus_armor_layer_1.png";
    }
}

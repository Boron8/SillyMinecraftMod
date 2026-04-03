package me.creeper.creepermodtest.items;

import cpw.mods.fml.common.registry.GameRegistry;
import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.items.armor.MallirusArmor;
import me.creeper.creepermodtest.items.tools.ItemDiamondHammer;
import me.creeper.creepermodtest.items.tools.ItemDetonator;
import me.creeper.creepermodtest.items.tools.ItemIronHammer;
import me.creeper.creepermodtest.items.tools.ItemStoneHammer;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {
    public static Item registerItem(Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        return item;
    }

    public static Item itemTest;
    public static Item itemCheese;
    public static Item itemGrilledCheese;
    public static Item itemMallirusGem;
    public static Item itemDiamondHammer;
    public static Item itemStoneHammer;
    public static Item itemIronPlate;
    public static Item itemIronHammer;
    public static Item itemDiamondPlate;
    public static Item itemDetonator;
    public static Item itemMallirusHelmet;
    public static Item itemMallirusChestplate;
    public static Item itemMallirusLeggings;
    public static Item itemMallirusBoots;

    public static void registerItems() {
        ExampleMod.debugLog("Registering items...");

        itemTest = registerItem(new ItemTest());
        itemCheese = registerItem(new ItemCheese());
        itemGrilledCheese = registerItem(new ItemGrilledCheese());
        itemMallirusGem = registerItem(new ItemMallirusGem());
        itemDiamondHammer = registerItem(new ItemDiamondHammer());
        itemStoneHammer = registerItem(new ItemStoneHammer());
        itemIronPlate = registerItem(new ItemIronPlate());
        itemIronHammer = registerItem(new ItemIronHammer());
        itemDiamondPlate = registerItem(new ItemDiamondPlate());
        itemDetonator = registerItem(new ItemDetonator());

        itemMallirusHelmet = new MallirusArmor(MallirusArmor.MALLIRUS_ARMOR_MATERIAL, 0, 0);
        itemMallirusChestplate = new MallirusArmor(MallirusArmor.MALLIRUS_ARMOR_MATERIAL, 0, 1);
        itemMallirusLeggings = new MallirusArmor(MallirusArmor.MALLIRUS_ARMOR_MATERIAL, 0, 2);
        itemMallirusBoots = new MallirusArmor(MallirusArmor.MALLIRUS_ARMOR_MATERIAL, 0, 3);
        GameRegistry.registerItem(itemMallirusHelmet, "mallirusHelmet");
        GameRegistry.registerItem(itemMallirusChestplate, "mallirusChestplate");
        GameRegistry.registerItem(itemMallirusLeggings, "mallirusLeggings");
        GameRegistry.registerItem(itemMallirusBoots, "mallirusBoots");

        OreDictionary.registerOre("listAllfood", itemCheese);   // Pams standards
        OreDictionary.registerOre("listAllmilk", itemCheese);   // Pams standards
        OreDictionary.registerOre("foodCheese", itemCheese);    // Pams standards
        OreDictionary.registerOre("listAllfood", itemGrilledCheese);
        OreDictionary.registerOre("listAllmilk", itemGrilledCheese);
        OreDictionary.registerOre("foodGrilledCheese", itemGrilledCheese);
        OreDictionary.registerOre("gemMallirus", itemMallirusGem);
        OreDictionary.registerOre("toolHammer", itemDiamondHammer);
        OreDictionary.registerOre("toolDiamondHammer", itemDiamondHammer);
        OreDictionary.registerOre("toolHammer", itemStoneHammer);
        OreDictionary.registerOre("toolStoneHammer", itemStoneHammer);
        OreDictionary.registerOre("plateIron", itemIronPlate);
        OreDictionary.registerOre("toolHammer", itemIronHammer);
        OreDictionary.registerOre("toolIronHammer", itemIronHammer);
        OreDictionary.registerOre("plateDiamond", itemDiamondPlate);

        ExampleMod.debugLog("Registering items done.");
    }
}

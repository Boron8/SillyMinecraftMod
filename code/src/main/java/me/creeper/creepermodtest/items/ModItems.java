package me.creeper.creepermodtest.items;

import cpw.mods.fml.common.registry.GameRegistry;
import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.items.armor.MallirusArmor;
import me.creeper.creepermodtest.items.crushed.ItemCrushedFineQuartz;
import me.creeper.creepermodtest.items.crushed.ItemCrushedGranularQuartz;
import me.creeper.creepermodtest.items.food.ItemCheese;
import me.creeper.creepermodtest.items.food.ItemGoldBerry;
import me.creeper.creepermodtest.items.food.ItemGrilledCheese;
import me.creeper.creepermodtest.items.tools.*;
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
    public static Item itemExplodingBallSummoner;
    public static Item itemDenseCopper;
    public static Item itemCopperIngot;
    public static Item itemRedstoneWire;
    public static Item itemInsulator;
    public static Item itemStoneMortar;
    public static Item itemStonePestle;
    public static Item itemStoneMortarAndPestle;
    public static Item itemCrushedGranularQuartz;
    public static Item itemCrushedFineQuartz;
    public static Item itemTungstenIngot;
    public static Item itemTungstenPlate;
    public static Item itemDevNote;
    public static Item itemEntrance;
    public static Item itemGoldBerry;


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
        itemExplodingBallSummoner = registerItem(new ItemExplodingBallSummoner());
        itemDenseCopper = registerItem(new ItemDenseCopper());
        itemCopperIngot = registerItem(new ItemCopperIngot());
        itemRedstoneWire = registerItem(new ItemRedstoneWire());
        itemInsulator = registerItem(new ItemInsulator());
        itemStoneMortar = registerItem(new ItemStoneMortar());
        itemStonePestle = registerItem(new ItemStonePestle());
        itemStoneMortarAndPestle = registerItem(new ItemStoneMortarAndPestle());
        itemCrushedGranularQuartz = registerItem(new ItemCrushedGranularQuartz());
        itemCrushedFineQuartz = registerItem(new ItemCrushedFineQuartz());
        itemTungstenIngot = registerItem(new ItemTungstenIngot());
        itemTungstenPlate = registerItem(new ItemTungstenPlate());
        itemDevNote = registerItem(new ItemDevNote());
        itemEntrance = registerItem(new ItemEntrance());
        itemGoldBerry = registerItem(new ItemGoldBerry());


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
        OreDictionary.registerOre("ingotCopper", itemCopperIngot);
        OreDictionary.registerOre("denseCopper", itemDenseCopper);
        OreDictionary.registerOre("ingotTungsten", itemTungstenIngot);
        OreDictionary.registerOre("plateTungsten", itemTungstenPlate);

        ExampleMod.debugLog("Registering items done.");
    }
}

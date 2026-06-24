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

    public static Item registerItem(Item item, String... oreDicts) {
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        for (String oreDict : oreDicts) {
            OreDictionary.registerOre(oreDict, item);
        }
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
    public static Item itemTungstenSword;


    public static void registerItems() {
        ExampleMod.debugLog("Registering items...");

        itemTest = registerItem(new ItemTest());
        itemCheese = registerItem(new ItemCheese(), "listAllfood", "listAllFood", "listAllmilk", "listAllMilk", "foodCheese");
        itemGrilledCheese = registerItem(new ItemGrilledCheese(), "listAllfood", "listAllFood", "listAllmilk", "listAllMilk", "foodGrilledCheese", "foodCheese");
        itemMallirusGem = registerItem(new ItemMallirusGem(), "gemMallirus");
        itemDiamondHammer = registerItem(new ItemDiamondHammer(), "toolHammer", "toolDiamondHammer");
        itemStoneHammer = registerItem(new ItemStoneHammer(), "toolHammer", "toolStoneHammer");
        itemIronPlate = registerItem(new ItemIronPlate(), "plateIron");
        itemIronHammer = registerItem(new ItemIronHammer(), "toolHammer", "toolIronHammer");
        itemDiamondPlate = registerItem(new ItemDiamondPlate(), "plate", "plateDiamond");
        itemDetonator = registerItem(new ItemDetonator());
        itemExplodingBallSummoner = registerItem(new ItemExplodingBallSummoner());
        itemDenseCopper = registerItem(new ItemDenseCopper(), "denseCopper");
        itemCopperIngot = registerItem(new ItemCopperIngot(), "ingot", "ingotCopper");
        itemRedstoneWire = registerItem(new ItemRedstoneWire());
        itemInsulator = registerItem(new ItemInsulator());
        itemStoneMortar = registerItem(new ItemStoneMortar());
        itemStonePestle = registerItem(new ItemStonePestle());
        itemStoneMortarAndPestle = registerItem(new ItemStoneMortarAndPestle());
        itemCrushedGranularQuartz = registerItem(new ItemCrushedGranularQuartz(), "crushed", "crushedQuartz");
        itemCrushedFineQuartz = registerItem(new ItemCrushedFineQuartz(), "crushed", "crushedQuartz");
        itemTungstenIngot = registerItem(new ItemTungstenIngot(), "ingotTungsten");
        itemTungstenPlate = registerItem(new ItemTungstenPlate(), "plate", "plateTungsten");
        itemDevNote = registerItem(new ItemDevNote());
        itemEntrance = registerItem(new ItemEntrance(), "magic");
        itemGoldBerry = registerItem(new ItemGoldBerry(), "listAllfood", "listAllFood", "listAllberry", "listAllBerry", "foodGoldBerry", "foodBerry");
        itemTungstenSword = registerItem(new ItemTungstenSword(), "swordTungsten");


        itemMallirusHelmet = new MallirusArmor(MallirusArmor.MALLIRUS_ARMOR_MATERIAL, 0, 0);
        itemMallirusChestplate = new MallirusArmor(MallirusArmor.MALLIRUS_ARMOR_MATERIAL, 0, 1);
        itemMallirusLeggings = new MallirusArmor(MallirusArmor.MALLIRUS_ARMOR_MATERIAL, 0, 2);
        itemMallirusBoots = new MallirusArmor(MallirusArmor.MALLIRUS_ARMOR_MATERIAL, 0, 3);
        GameRegistry.registerItem(itemMallirusHelmet, "mallirusHelmet");
        GameRegistry.registerItem(itemMallirusChestplate, "mallirusChestplate");
        GameRegistry.registerItem(itemMallirusLeggings, "mallirusLeggings");
        GameRegistry.registerItem(itemMallirusBoots, "mallirusBoots");


        ExampleMod.debugLog("Registering items done.");
    }
}

package me.creeper.creepermodtest.items;

import cpw.mods.fml.common.registry.GameRegistry;
import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.items.tools.DiamondHammer;
import me.creeper.creepermodtest.items.tools.ItemDetonator;
import me.creeper.creepermodtest.items.tools.itemIronHammer;
import me.creeper.creepermodtest.items.tools.itemStoneHammer;
import net.minecraft.item.Item;

public class RegisterItems {
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

    public static class RegisterItemsHandler {
        //Item Testz<<
        public static void registerItemTest() {
            itemTest = new ItemTest().setUnlocalizedName("itemTest").setTextureName(ExampleMod.MODID+":item_test");
            GameRegistry.registerItem(itemTest, itemTest.getUnlocalizedName().substring(5));
        }

        //Item Cheese
        public static void registerItemCheese() {
            // hunger saturation can_be_eaten_by_wolf
            itemCheese = new ItemCheese().setUnlocalizedName("itemCheese").setTextureName(ExampleMod.MODID+":item_cheese");
            GameRegistry.registerItem(itemCheese, itemCheese.getUnlocalizedName().substring(5));
        }

        //Item Grilled Cheese
        public static void registerItemGrilledCheese() {
            // hunger saturation can_be_eaten_by_wolf
            itemGrilledCheese = new ItemGrilledCheese().setUnlocalizedName("itemGrilledCheese").setTextureName(ExampleMod.MODID+":item_grilled_cheese");
            GameRegistry.registerItem(itemGrilledCheese, itemGrilledCheese.getUnlocalizedName().substring(5));
        }

        //Item Mallirus Gem
        public static void registerItemMallirusGem() {
            itemMallirusGem = new ItemMallirusGem();
            GameRegistry.registerItem(itemMallirusGem, itemMallirusGem.getUnlocalizedName().substring(5));
        }

        //Item Diamond Hammer
        public static void registerItemDiamondHammer() {
            itemDiamondHammer = new DiamondHammer(DiamondHammer.DIAMOND_HAMMER);
            GameRegistry.registerItem(itemDiamondHammer, itemDiamondHammer.getUnlocalizedName().substring(5));
        }

        //Item Stone Hammer
        public static void registerItemStoneHammer() {
            itemStoneHammer = new itemStoneHammer();
            GameRegistry.registerItem(itemStoneHammer, itemStoneHammer.getUnlocalizedName().substring(5));
        }

        //Item Iron Plate
        public static void registerItemIronPlate() {
            itemIronPlate = new itemIronPlate();
            GameRegistry.registerItem(itemIronPlate, itemIronPlate.getUnlocalizedName().substring(5));
        }

        //Item Iron Hammer
        public static void registerItemIronHammer() {
            itemIronHammer = new itemIronHammer();
            GameRegistry.registerItem(itemIronHammer, itemIronHammer.getUnlocalizedName().substring(5));
        }

        //Item Diamond Plate
        public static void registerItemDiamondPlate() {
            itemDiamondPlate = new itemDiamondPlate();
            GameRegistry.registerItem(itemDiamondPlate, itemDiamondPlate.getUnlocalizedName().substring(5));
        }

        //Item Diamond Plate
        public static void registerItemDetonator() {
            itemDetonator = new ItemDetonator();
            GameRegistry.registerItem(itemDetonator, itemDetonator.getUnlocalizedName().substring(5));
        }




        public static void registerAllItems() {
            registerItemTest();
            registerItemCheese();
            registerItemGrilledCheese();
            registerItemMallirusGem();
            registerItemDiamondHammer();
            registerItemStoneHammer();
            registerItemIronPlate();
            registerItemIronHammer();
            registerItemDiamondPlate();
            registerItemDetonator();


        }
    }
}

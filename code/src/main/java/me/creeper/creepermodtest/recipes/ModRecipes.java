package me.creeper.creepermodtest.recipes;

import me.creeper.creepermodtest.blocks.ModBlocks;
import me.creeper.creepermodtest.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModRecipes {

    public static List<ItemStack> mallirusOutputs = new ArrayList<>(Arrays.asList(
            new ItemStack(Items.experience_bottle, 8),
            new ItemStack(Items.diamond, 1),
            new ItemStack(Items.ender_pearl, 4),
            new ItemStack(Items.skull, 1),
            new ItemStack(Items.blaze_rod, 8),
            new ItemStack(Blocks.sponge, 2),
            new ItemStack(Items.saddle, 1),
            new ItemStack(Items.name_tag, 1),
            new ItemStack(Items.golden_apple, 1, 1)
    ));

    public static List<RecipeData> craftingRecipes = new ArrayList<>();
    public static List<RecipeData> smeltingRecipes = new ArrayList<>();

    private static void addShaped(ItemStack output, Object... input) {
        craftingRecipes.add(new RecipeData(output, input, false));
    }
    private static void addShapeless(ItemStack output, Object... input) {
        craftingRecipes.add(new RecipeData(output, input, true));
    }

    private static void addSmelting(ItemStack output, ItemStack input, float xp) {
        smeltingRecipes.add(new RecipeData(output, input, xp));
    }



    public static void init() {
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // BASIC BLOCKS                  \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Table
        addShaped(
                new ItemStack(ModBlocks.blockTable),

                "WWW",
                "W W",
                "W W",

                'W', new ItemStack(Blocks.planks)
        );



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // FOOD                          \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Cheese
        addShapeless(
                new ItemStack(ModItems.itemCheese, 8),

                new ItemStack(Items.milk_bucket),
                new ItemStack(Items.milk_bucket),
                new ItemStack(Items.milk_bucket),
                new ItemStack(Items.milk_bucket),
                new ItemStack(Items.milk_bucket),
                new ItemStack(Items.milk_bucket),
                new ItemStack(Items.milk_bucket),
                new ItemStack(Items.milk_bucket),
                new ItemStack(Items.sugar)
        );
        // Grilled Cheese
        addSmelting(
                new ItemStack(ModItems.itemGrilledCheese),
                new ItemStack(ModItems.itemCheese),
                1.0F
        );



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // ORE -> INGOT                  \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Mallirus Gem
        addSmelting(
                new ItemStack(ModItems.itemMallirusGem),
                new ItemStack(ModBlocks.blockMallirusOre),
                4.0F
        );
        // Copper Ingot
        addSmelting(
                new ItemStack(ModItems.itemCopperIngot),
                new ItemStack(ModBlocks.blockCopperOre),
                4.0F
        );
        // Tungsten Ingot
        addSmelting(
                new ItemStack(ModItems.itemTungstenIngot),
                new ItemStack(ModBlocks.blockTungstenOre),
                4.0F
        );



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // EASIER RECIPES                \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Netherstar
        addShaped(
                new ItemStack(Items.nether_star),

                "WWW",
                "SSS",
                "DSB",

                'W', new ItemStack(Items.skull, 1, 1), // 1x Wither skull
                'S', new ItemStack(Blocks.soul_sand),
                'D', new ItemStack(Items.diamond_sword),
                'B', new ItemStack(Items.bow)

        );
        // Skeleton Skull
        addShaped(
                new ItemStack(Items.skull, 1, 0), // 1x Skeleton skull

                "MBM",
                "BBB",
                "MBM",

                'M', new ItemStack(Items.dye, 1, 15), // 1x Bone meal
                'B', new ItemStack(Items.bone)
        );
        // Wither Skull
        addShapeless(
                new ItemStack(Items.skull, 1, 1), // 1x Wither skull

                new ItemStack(Items.skull, 1, 0),
                new ItemStack(Items.coal),
                new ItemStack(Items.coal),
                new ItemStack(Items.coal),
                new ItemStack(Items.coal),
                new ItemStack(Items.coal),
                new ItemStack(Items.coal),
                new ItemStack(Items.coal),
                new ItemStack(Items.coal)
        );



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // PLATES                        \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Iron Plate
        addShapeless(
                new ItemStack(ModItems.itemIronPlate),

                new ItemStack(Items.iron_ingot),
                new ItemStack(ModItems.itemStoneHammer, 1, OreDictionary.WILDCARD_VALUE)
        );
        addShapeless(
                new ItemStack(ModItems.itemIronPlate),

                new ItemStack(Items.iron_ingot),
                new ItemStack(ModItems.itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)
        );
        addShapeless(
                new ItemStack(ModItems.itemIronPlate),

                new ItemStack(Items.iron_ingot),
                new ItemStack(ModItems.itemDiamondHammer, 1, OreDictionary.WILDCARD_VALUE)

        );
        // Diamond Plate
        addShapeless(
                new ItemStack(ModItems.itemDiamondPlate),

                new ItemStack(Items.diamond),
                new ItemStack(ModItems.itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)

        );
        addShapeless(
                new ItemStack(ModItems.itemDiamondPlate),

                new ItemStack(Items.diamond),
                new ItemStack(ModItems.itemDiamondHammer, 1, OreDictionary.WILDCARD_VALUE)

        );
        // Tungsten plate
        addShapeless(
                new ItemStack(ModItems.itemTungstenPlate),

                new ItemStack(ModItems.itemTungstenIngot),
                new ItemStack(ModItems.itemDiamondHammer, 1, OreDictionary.WILDCARD_VALUE)
        );



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // TOOLS AND ARMOR               \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Stone Hammer
        addShaped(
                new ItemStack(ModItems.itemStoneHammer),

                "SSS",
                "SWS",
                " W ",

                'S', new ItemStack(Blocks.cobblestone),
                'W', new ItemStack(Items.stick)

        );
        // Iron Hammer
        addShaped(
                new ItemStack(ModItems.itemIronHammer),

                "III",
                "ISI",
                " S ",

                'I', new ItemStack(ModItems.itemIronPlate),
                'S', new ItemStack(Items.stick)
        );
        // Diamond Hammer
        addShaped(
                new ItemStack(ModItems.itemDiamondHammer),

                "DDD",
                "DSD",
                " S ",

                'D', new ItemStack(ModItems.itemDiamondPlate),
                'S', new ItemStack(Items.stick)
        );
        // Horse armors
        addShaped(
                new ItemStack(Items.iron_horse_armor),

                "  I",
                "III",
                "I I",

                'I', new ItemStack(Items.iron_ingot)
        );
        addShaped(
                new ItemStack(Items.golden_horse_armor),

                "  G",
                "GGG",
                "G G",

                'G', new ItemStack(Items.gold_ingot)
        );
        addShaped(
                new ItemStack(Items.diamond_horse_armor),

                "  D",
                "DDD",
                "D D",

                'D', new ItemStack(Items.diamond)
        );
        addShaped(
                new ItemStack(ModItems.itemStoneMortar),

                "S S",
                "SSS",

                'S', new ItemStack(Blocks.stone)
        );
        addShaped(
                new ItemStack(ModItems.itemStonePestle),
                "S",
                "S",
                "S",

                'S', new ItemStack(Blocks.stone)
        );
        addShapeless(
                new ItemStack(ModItems.itemStoneMortarAndPestle),

                new ItemStack(ModItems.itemStoneMortar),
                new ItemStack(ModItems.itemStonePestle)
        );



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Other                         \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        addShapeless(
                new ItemStack(ModItems.itemDenseCopper),

                new ItemStack(ModItems.itemCopperIngot),
                new ItemStack(ModItems.itemCopperIngot),
                new ItemStack(ModItems.itemCopperIngot),
                new ItemStack(ModItems.itemCopperIngot),

                new ItemStack(ModItems.itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)
        );
        addShapeless(
                new ItemStack(ModItems.itemDenseCopper),

                new ItemStack(ModItems.itemCopperIngot),
                new ItemStack(ModItems.itemCopperIngot),
                new ItemStack(ModItems.itemCopperIngot),
                new ItemStack(ModItems.itemCopperIngot),

                new ItemStack(ModItems.itemDiamondHammer, 1, OreDictionary.WILDCARD_VALUE)
        );
        addShaped(
                new ItemStack(ModBlocks.blockTestMultiCasing),

                "CSC",
                "SDS",
                "CSC",

                'D', new ItemStack(ModItems.itemDenseCopper),
                'S', new ItemStack(Blocks.stone),
                'C', new ItemStack(ModBlocks.blockCable)

        );
        // Insulator
        addShapeless(
                new ItemStack(ModItems.itemInsulator),

                new ItemStack(Items.dye, 1, 8),
                new ItemStack(Items.dye, 1, 8),
                new ItemStack(Items.dye, 1, 8),
                new ItemStack(ModItems.itemCrushedFineQuartz)
        );
        addShaped(
                new ItemStack(ModBlocks.blockDenseCopperTube, 6),

                "C",
                "C",
                "C",

                'C', new ItemStack(ModItems.itemDenseCopper)

        );



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Powders/Crushed               \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Quartz powder
        addShapeless(
                new ItemStack(ModItems.itemCrushedGranularQuartz),

                new ItemStack(Items.quartz),
                new ItemStack(ModItems.itemStoneMortarAndPestle, 1, OreDictionary.WILDCARD_VALUE)
        );
        addShapeless(
                new ItemStack(ModItems.itemCrushedFineQuartz),

                new ItemStack(ModItems.itemCrushedGranularQuartz),
                new ItemStack(ModItems.itemStoneMortarAndPestle, 1, OreDictionary.WILDCARD_VALUE)
        );



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Redstone/Logic/Computers      \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Wire
        addShaped(
                new ItemStack(ModItems.itemRedstoneWire),

                "R",
                "R",
                "R",

                'R', new ItemStack(Items.redstone)
        );
        // Cable
        addShapeless(
                new ItemStack(ModBlocks.blockCable),

                new ItemStack(ModItems.itemRedstoneWire),
                new ItemStack(ModItems.itemInsulator)
        );



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Mallirus Crafting             \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        ItemStack mallirusGemStack = new ItemStack(ModItems.itemMallirusGem);
        for (int i = 1; i <= 9; i++) { // 1-9
            ItemStack[] mallirusGems = new ItemStack[i];
            Arrays.fill(mallirusGems, mallirusGemStack);
            addShapeless(mallirusOutputs.get(i-1), (Object[])mallirusGems);
        }
    }
}

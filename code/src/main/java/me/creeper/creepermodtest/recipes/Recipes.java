package me.creeper.creepermodtest.recipes;

import me.creeper.creepermodtest.blocks.RegisterBlocks;
import me.creeper.creepermodtest.items.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recipes {

    public static List<ItemStack> mallirusOutputs = new ArrayList<>(Arrays.asList(
            new ItemStack(net.minecraft.init.Items.experience_bottle, 8),
            new ItemStack(net.minecraft.init.Items.diamond, 1),
            new ItemStack(net.minecraft.init.Items.ender_pearl, 4),
            new ItemStack(net.minecraft.init.Items.skull, 1),
            new ItemStack(net.minecraft.init.Items.blaze_rod, 8),
            new ItemStack(Blocks.sponge, 2),
            new ItemStack(net.minecraft.init.Items.saddle, 1),
            new ItemStack(net.minecraft.init.Items.name_tag, 1),
            new ItemStack(net.minecraft.init.Items.golden_apple, 1, 1)
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
                new ItemStack(RegisterBlocks.blockTable),

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
                new ItemStack(Items.itemCheese, 8),

                new ItemStack(net.minecraft.init.Items.milk_bucket),
                new ItemStack(net.minecraft.init.Items.milk_bucket),
                new ItemStack(net.minecraft.init.Items.milk_bucket),
                new ItemStack(net.minecraft.init.Items.milk_bucket),
                new ItemStack(net.minecraft.init.Items.milk_bucket),
                new ItemStack(net.minecraft.init.Items.milk_bucket),
                new ItemStack(net.minecraft.init.Items.milk_bucket),
                new ItemStack(net.minecraft.init.Items.milk_bucket),
                new ItemStack(net.minecraft.init.Items.sugar)
        );
        // Grilled Cheese
        addSmelting(
                new ItemStack(Items.itemGrilledCheese),
                new ItemStack(Items.itemCheese),
                1.0F
        );



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // ORE -> INGOT                  \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Mallirus Gem
        addSmelting(
                new ItemStack(Items.itemMallirusGem),
                new ItemStack(RegisterBlocks.blockMallirusOre),
                4.0F
        );



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // EASIER RECIPES                \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Netherstar
        addShaped(
                new ItemStack(net.minecraft.init.Items.nether_star),

                "WWW",
                "SSS",
                "DSB",

                'W', new ItemStack(net.minecraft.init.Items.skull, 1, 1), // 1x Wither skull
                'S', new ItemStack(Blocks.soul_sand),
                'D', new ItemStack(net.minecraft.init.Items.diamond_sword),
                'B', new ItemStack(net.minecraft.init.Items.bow)

        );
        // Skeleton Skull
        addShaped(
                new ItemStack(net.minecraft.init.Items.skull, 1, 0), // 1x Skeleton skull

                "MBM",
                "BBB",
                "MBM",

                'M', new ItemStack(net.minecraft.init.Items.dye, 1, 15), // 1x Bone meal
                'B', new ItemStack(net.minecraft.init.Items.bone)
        );
        // Wither Skull
        addShapeless(
                new ItemStack(net.minecraft.init.Items.skull, 1, 1), // 1x Wither skull

                new ItemStack(net.minecraft.init.Items.skull, 1, 0),
                new ItemStack(net.minecraft.init.Items.coal),
                new ItemStack(net.minecraft.init.Items.coal),
                new ItemStack(net.minecraft.init.Items.coal),
                new ItemStack(net.minecraft.init.Items.coal),
                new ItemStack(net.minecraft.init.Items.coal),
                new ItemStack(net.minecraft.init.Items.coal),
                new ItemStack(net.minecraft.init.Items.coal),
                new ItemStack(net.minecraft.init.Items.coal)
        );



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // PLATES                        \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Iron Plate
        addShapeless(
                new ItemStack(Items.itemIronPlate),

                new ItemStack(net.minecraft.init.Items.iron_ingot),
                new ItemStack(Items.itemStoneHammer, 1, OreDictionary.WILDCARD_VALUE)
        );
        addShapeless(
                new ItemStack(Items.itemIronPlate),

                new ItemStack(net.minecraft.init.Items.iron_ingot),
                new ItemStack(Items.itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)
        );
        addShapeless(
                new ItemStack(Items.itemIronPlate),

                new ItemStack(net.minecraft.init.Items.iron_ingot),
                new ItemStack(Items.itemDiamondHammer, 1, OreDictionary.WILDCARD_VALUE)

        );
        // Diamond Plate
        addShapeless(
                new ItemStack(Items.itemDiamondPlate),

                new ItemStack(net.minecraft.init.Items.diamond),
                new ItemStack(Items.itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)

        );
        addShapeless(
                new ItemStack(Items.itemDiamondPlate),

                new ItemStack(net.minecraft.init.Items.diamond),
                new ItemStack(Items.itemDiamondHammer, 1, OreDictionary.WILDCARD_VALUE)

        );

        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // TOOLS AND ARMOR               \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Stone Hammer
        addShaped(
                new ItemStack(Items.itemStoneHammer),

                "SSS",
                "SWS",
                " W ",

                'S', new ItemStack(Blocks.cobblestone),
                'W', new ItemStack(net.minecraft.init.Items.stick)

        );
        // Iron Hammer
        addShaped(
                new ItemStack(Items.itemIronHammer),

                "III",
                "ISI",
                " S ",

                'I', new ItemStack(Items.itemIronPlate),
                'S', new ItemStack(net.minecraft.init.Items.stick)
        );
        // Diamond Hammer
        addShaped(
                new ItemStack(Items.itemDiamondHammer),

                "DDD",
                "DSD",
                " S ",

                'D', new ItemStack(Items.itemDiamondPlate),
                'S', new ItemStack(net.minecraft.init.Items.stick)
        );
        // Horse armors
        addShaped(
                new ItemStack(net.minecraft.init.Items.iron_horse_armor),

                "  I",
                "III",
                "I I",

                'I', new ItemStack(net.minecraft.init.Items.iron_ingot)
        );
        addShaped(
                new ItemStack(net.minecraft.init.Items.golden_horse_armor),

                "  G",
                "GGG",
                "G G",

                'G', new ItemStack(net.minecraft.init.Items.gold_ingot)
        );
        addShaped(
                new ItemStack(net.minecraft.init.Items.diamond_horse_armor),

                "  D",
                "DDD",
                "D D",

                'D', new ItemStack(net.minecraft.init.Items.diamond)
        );



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        // Mallirus Crafting             \\
        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-= \\
        ItemStack mallirusGemStack = new ItemStack(Items.itemMallirusGem);
        for (int i = 1; i <= 9; i++) { // 1-9
            ItemStack[] mallirusGems = new ItemStack[i];
            Arrays.fill(mallirusGems, mallirusGemStack);
            addShapeless(mallirusOutputs.get(i-1), (Object[])mallirusGems);
        }
    }
}

package me.creeper.creepermodtest.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks {
    public static Block registerBlock(Block block) {
        GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));

        return block;
    }

    public static Block blockTable;
    public static Block blockMallirusOre;
    public static Block blockCable;
    public static Block blockTestMultiCasing;
    public static Block blockCopperOre;
    public static Block blockDenseCopperTube;
    public static Block blockTungstenOre;
    public static Block blockBerryBush;

    public static void registerAllBlocks() {
        ExampleMod.debugLog("Registering blocks...");

        blockTable = registerBlock(new BlockTable());
        blockMallirusOre = registerBlock(new BlockMallirusOre());
        blockCable = registerBlock(new BlockCable());
        blockTestMultiCasing = registerBlock(new BlockTestMultiCasing());
        blockCopperOre = registerBlock(new BlockCopperOre());
        blockDenseCopperTube = registerBlock(new BlockDenseCopperTube());
        blockTungstenOre = registerBlock(new BlockTungstenOre());
        blockBerryBush = registerBlock(new BlockBerryBush());

        OreDictionary.registerOre("oreMallirus", blockMallirusOre);
        OreDictionary.registerOre("oreCopper", blockCopperOre);
        OreDictionary.registerOre("tube", blockDenseCopperTube);
        OreDictionary.registerOre("oreTungsten", blockTungstenOre);
        OreDictionary.registerOre("plantBerryBush", blockBerryBush);
        OreDictionary.registerOre("bushBerry", blockBerryBush);
        OreDictionary.registerOre("bush", blockBerryBush);

        ExampleMod.debugLog("Registering blocks done.");
    }
}

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

    public static void registerAllBlocks() {
        ExampleMod.debugLog("Registering blocks...");

        blockTable = registerBlock(new BlockTable());
        blockMallirusOre = registerBlock(new BlockMallirusOre());
        blockCable = registerBlock(new BlockCable());

        OreDictionary.registerOre("oreMallirus", blockMallirusOre);

        ExampleMod.debugLog("Registering blocks done.");
    }
}

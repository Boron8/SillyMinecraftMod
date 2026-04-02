package me.creeper.creepermodtest.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;

public class RegisterBlocks {
    public static Block blockTable;
    public static Block blockMallirusOre;
    public static Block blockCable;

    public static class RegisterBlocksHandler {
        public static void registerBlockTable() {
            blockTable = new BlockTable();
            GameRegistry.registerBlock(blockTable, blockTable.getUnlocalizedName().substring(5));
        }

        public static void registerMallirusOre() {
            blockMallirusOre = new BlockMallirusOre();
            GameRegistry.registerBlock(blockMallirusOre, blockMallirusOre.getUnlocalizedName().substring(5));
            OreDictionary.registerOre("oreMallirus", blockMallirusOre);
        }

        public static void registerBlockCable() {
            blockCable = new BlockCable();
            GameRegistry.registerBlock(blockCable, blockCable.getUnlocalizedName().substring(5));
        }


        public static void registerAllBlocks() {
            ExampleMod.debugLog("Registering blocks...");
            registerBlockTable();
            registerMallirusOre();
            registerBlockCable();
            ExampleMod.debugLog("Registering blocks done.");
        }
    }
}

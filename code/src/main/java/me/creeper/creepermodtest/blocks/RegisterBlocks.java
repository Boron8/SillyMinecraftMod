package me.creeper.creepermodtest.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class RegisterBlocks {
    public static Block blockTable;
    public static Block blockMallirusOre;

    public static class RegisterBlocksHandler {
        public static void registerBlockTable() {
            blockTable = new BlockTable();
            GameRegistry.registerBlock(blockTable, blockTable.getUnlocalizedName().substring(5));
        }

        public static void registerMallirusOre() {
            blockMallirusOre = new BlockMallirusOre();
            GameRegistry.registerBlock(blockMallirusOre, blockMallirusOre.getUnlocalizedName().substring(5));
        }


        public static void registerAllBlocks() {
            registerBlockTable();
            registerMallirusOre();
        }
    }
}

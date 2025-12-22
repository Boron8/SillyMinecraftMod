package me.creeper.creepermodtest.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class RegisterBlocks {
    public static Block blockTable;
    public static Block blockMallirusOre;
    public static Block blockBlinker;

    public static TileEntity tileEntityBlinker;

    public static class RegisterBlocksHandler {
        public static void registerBlockTable() {
            blockTable = new BlockTable().setBlockName("blockTable").setBlockTextureName(ExampleMod.MODID+":block_table");
            GameRegistry.registerBlock(blockTable, blockTable.getUnlocalizedName().substring(5));
        }

        public static void registerMallirusOre() {
            blockMallirusOre = new BlockMallirusOre().setBlockName("blockMallirusOre").setBlockTextureName(ExampleMod.MODID+":block_mallirus_ore");
            GameRegistry.registerBlock(blockMallirusOre, blockMallirusOre.getUnlocalizedName().substring(5));
        }


        public static void registerAllBlocks() {
            registerBlockTable();
            registerMallirusOre();
        }
    }
}

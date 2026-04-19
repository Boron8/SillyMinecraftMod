package me.creeper.creepermodtest.multiblocks;

import cpw.mods.fml.common.registry.GameRegistry;
import me.creeper.creepermodtest.multiblocks.testMulti.BlockTestMultiController;
import me.creeper.creepermodtest.multiblocks.testMulti.TileEntityTestMultiController;
import net.minecraft.block.Block;

public class registerMultiblocks {
    public static Block blockTestMultiController;

    public static void registerTestMulti() {
        blockTestMultiController = new BlockTestMultiController();
        GameRegistry.registerBlock(blockTestMultiController, blockTestMultiController.getUnlocalizedName().substring(5));

        GameRegistry.registerTileEntity(TileEntityTestMultiController.class, "TestMultiControllerTE");
    }

    public static void registerAllMultiBlocks() {
        registerTestMulti();
    }
}

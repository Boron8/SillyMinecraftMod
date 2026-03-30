package me.creeper.creepermodtest;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.creeper.creepermodtest.blocks.RegisterBlocks;
import me.creeper.creepermodtest.commands.RegisterCommands;
import me.creeper.creepermodtest.generation.RegisterOreGeneration;
import me.creeper.creepermodtest.handlers.DetonatorHeldHandler;
import me.creeper.creepermodtest.handlers.KeybindingsHandler;
import me.creeper.creepermodtest.items.RegisterItems;
import me.creeper.creepermodtest.recipes.RegisterRecipes;
import me.creeper.creepermodtest.renderers.TestRenderer;
import me.creeper.creepermodtest.utils.Counter;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.command.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.Random;

import static me.creeper.creepermodtest.keyBindings.RegisterKeybindings.registerAllKeybindings;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
    public static String LICENSE = "Copyright (C) 2024-2026 Boron8, Creeper9555, Emil Svensson\n\nPermission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the \"Software\"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:\n\nThe above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.\n\nTHE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.\n";

    // DEV     = Development
    // ALPHA   = Alpha
    // BETA    = Beta
    // PRE     = Pre Release
    // RELEASE = Release
    public static final String RELEASE_TYPE    = "DEV";
    public static final String RELEASE_VERSION = "1";
    public static final String MODID           = "creepermodtest";
    public static final String VERSION         = "0.0.2-" + RELEASE_TYPE + "-" + RELEASE_VERSION;

    public static boolean debug_print;
    public static File configFile;

    public static Counter globalCounter;

    public static Random random = new Random();

    @SideOnly(Side.CLIENT)
    public static Minecraft mc;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //1
        //Item/block init and registering
        //Config handling

        preInitClient(event);

        globalCounter = new Counter();


        configFile = event.getSuggestedConfigurationFile();


        Configuration config = new Configuration(configFile);
        try {
            config.load();

             debug_print = config.getBoolean("debug_print", Configuration.CATEGORY_GENERAL, false, "Enable debug print mode");

            if (config.hasChanged()) {
                config.save();
            }
        } catch (Exception e) {
            FMLLog.severe("There was a problem loading the configuration file");
            e.printStackTrace();
        }

        RegisterItems.RegisterItemsHandler.registerAllItems();
        RegisterBlocks.RegisterBlocksHandler.registerAllBlocks();
    }

    @SideOnly(Side.CLIENT)
    public void preInitClient(FMLPreInitializationEvent event) {
        mc = Minecraft.getMinecraft();
    }


    @EventHandler
    public void init(FMLInitializationEvent event) {
        //2
        //Proxy, entity, GUI, Packet registering, World generation
        //Recipe registering
        //Custom Renderers

        RegisterRecipes.RegisterRecipesHandler.registerAllRecipes();

        RegisterOreGeneration.RegisterOreGenerationHandler.registerAllGeneration();

        MinecraftForge.EVENT_BUS.register(new TestRenderer());

        if (event.getSide().isClient()) {
            registerAllKeybindings();
            FMLCommonHandler.instance().bus().register(new KeybindingsHandler());
        }

        FMLCommonHandler.instance().bus().register(new DetonatorHeldHandler());
    }


    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Inter mod compatibility
    }


    @EventHandler
    public void onServerStart(FMLServerStartingEvent event) {
        MinecraftServer server = MinecraftServer.getServer();
        ICommandManager command = server.getCommandManager();
        ServerCommandManager manager = (ServerCommandManager) command;

        RegisterCommands.RegisterCommandsHandler.registerAllCommands(manager);
    }



    public static CreativeTabs tabCreepermodtest = new CreativeTabs("tabCreepermodtest") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(RegisterItems.itemCheese).getItem();
        }
    };
}

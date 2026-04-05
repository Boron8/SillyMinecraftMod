package me.creeper.creepermodtest;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.creeper.creepermodtest.blocks.ModBlocks;
import me.creeper.creepermodtest.commands.RegisterCommands;
import me.creeper.creepermodtest.computers.LuaSandbox;
import me.creeper.creepermodtest.computers.chat.ChatHandler;
import me.creeper.creepermodtest.config.MainConfig;
import me.creeper.creepermodtest.generation.RegisterOreGeneration;
import me.creeper.creepermodtest.handlers.CounterHandler;
import me.creeper.creepermodtest.handlers.DetonatorHeldHandler;
import me.creeper.creepermodtest.handlers.KeybindingsHandler;
import me.creeper.creepermodtest.items.ModItems;
import me.creeper.creepermodtest.licenseManager.LicenseLoader;
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
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;

import java.util.Random;

import static me.creeper.creepermodtest.commands.RegisterCommands.RegisterCommandsHandler.registerAllCommandsClient;
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

    private static MainConfig mainConfig;
    public  static MainConfig getMainConfig() { return mainConfig; }


    private static final Counter globalServerCounter = new Counter();
    private static final Counter globalClientCounter = new Counter();

    public static Random random = new Random();

    @SideOnly(Side.CLIENT)
    public static Minecraft mc;

    public static LuaSandbox luaSandbox;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ExampleMod.debugLog("PreInit...", true);

        //1
        //Item/block init and registering
        //Config handling

        if (event.getSide().isClient()) {
            mc = Minecraft.getMinecraft();
        }

        LicenseLoader.loadLicenses();

        mainConfig = new MainConfig(event.getSuggestedConfigurationFile());
        mainConfig.load();

        ModItems.registerItems();
        ModBlocks.registerAllBlocks();

        ExampleMod.debugLog("PreInit done.", true);
    }


    @EventHandler
    public void init(FMLInitializationEvent event) {
        ExampleMod.debugLog("Init...");
        //2
        //Proxy, entity, GUI, Packet registering, World generation
        //Recipe registering
        //Custom Renderers
        //Custom handlers

        // Recipes
        RegisterRecipes.registerRecipes();

        // World Gen
        RegisterOreGeneration.RegisterOreGenerationHandler.registerAllGeneration();

        // Forge Events
        MinecraftForge.EVENT_BUS.register(new TestRenderer());
        MinecraftForge.EVENT_BUS.register(new CounterHandler());

        if (event.getSide().isClient()) {
            // Keybindings
            registerAllKeybindings();

            // Handlers (Client)
            FMLCommonHandler.instance().bus().register(new KeybindingsHandler());
            FMLCommonHandler.instance().bus().register(new DetonatorHeldHandler());

            // Client Commands
            registerAllCommandsClient(ClientCommandHandler.instance);
        } else {
            // Handlers (Server)
        }

        // Handlers (Client+Server)
        FMLCommonHandler.instance().bus().register(new CounterHandler());
        MinecraftForge.EVENT_BUS.register(new ChatHandler());



        ExampleMod.debugLog("Init done.");
    }


    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        ExampleMod.debugLog("PostInit...");
        // Inter mod compatibility
        ExampleMod.debugLog("PostInit Done.");
    }


    @EventHandler
    public void onServerStart(FMLServerStartingEvent event) {
        ExampleMod.debugLog("ServerStart...");
        MinecraftServer server = MinecraftServer.getServer();
        ICommandManager command = server.getCommandManager();
        ServerCommandManager manager = (ServerCommandManager)command;

        RegisterCommands.RegisterCommandsHandler.registerAllCommands(manager);

        if (getMainConfig().computers_enabled) {
            luaSandbox = new LuaSandbox();
        }

        ExampleMod.debugLog("ServerStart done.");
    }


    public static CreativeTabs tabCreepermodtest = new CreativeTabs("tabCreepermodtest") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(ModItems.itemCheese).getItem();
        }
    };


    public static void debugLog(String msg, boolean ignore) {
        if (mainConfig == null || Boolean.TRUE.equals(mainConfig.debug_print) || ignore) {
            FMLLog.info("[CMT DBG]: " + msg);
        }
    }
    public static void debugLog(String msg) {
        ExampleMod.debugLog(msg, false);
    }

    public static Counter getServerCounter() {
        return globalServerCounter;
    }
    public static Counter getClientCounter() {
        return globalClientCounter;
    }
}

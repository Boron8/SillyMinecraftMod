package me.creeper.creepermodtest.commands;

import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.commands.TutorialPages.CommandTutorial;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.ClientCommandHandler;

public class RegisterCommands {
    public static class RegisterCommandsHandler {
        public static void registerCommandTestTest(ServerCommandManager manager) {
            manager.registerCommand(new TestTestCommand());
        }

        public static void registerCommandTps(ServerCommandManager manager) {
            manager.registerCommand(new CommandTps());
        }

        public static void registerCommandTutorial() {
            ClientCommandHandler.instance.registerCommand(new CommandTutorial());
        }

        public static void registerCommandVersion() {
            ClientCommandHandler.instance.registerCommand(new CommandVersion());
        }

        public static void registerCommandLicenses() {
            ClientCommandHandler.instance.registerCommand(new CommandLicenses());
        }


        public static void registerAllCommands() {
            ExampleMod.debugLog("Registering commands...");

            ServerCommandManager manager = ((ServerCommandManager)MinecraftServer.getServer().getCommandManager());

            registerCommandTestTest(manager);
            registerCommandTps(manager);

            ExampleMod.debugLog("Registering commands done.");
        }

        public static void registerAllCommandsClient() {
            ExampleMod.debugLog("Registering (Client) commands...");

            registerCommandLicenses();
            registerCommandTutorial();
            registerCommandVersion();

            ExampleMod.debugLog("Registering (Client) commands done.");
        }
    }
}

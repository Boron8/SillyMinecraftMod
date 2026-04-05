package me.creeper.creepermodtest.commands;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.command.ServerCommandManager;
import net.minecraftforge.client.ClientCommandHandler;

public class RegisterCommands {
    public static class RegisterCommandsHandler {
        public static void registerCommandTestTest(ServerCommandManager manager) {
            manager.registerCommand(new TestTestCommand());
        }

        public static void registerCommandTutorial(ServerCommandManager manager) {
            manager.registerCommand(new CommandTutorial());
        }

        public static void registerCommandVersion(ServerCommandManager manager) {
            manager.registerCommand(new CommandVersion());
        }

        public static void registerCommandLicenses(ClientCommandHandler commandHandler) {
            commandHandler.registerCommand(new CommandLicenses());
        }


        public static void registerAllCommands(ServerCommandManager manager) {
            ExampleMod.debugLog("Registering commands...");
            registerCommandTestTest(manager);
            registerCommandTutorial(manager);
            registerCommandVersion(manager);
            ExampleMod.debugLog("Registering commands done.");
        }

        public static void registerAllCommandsClient(ClientCommandHandler commandHandler) {
            registerCommandLicenses(commandHandler);
        }
    }
}

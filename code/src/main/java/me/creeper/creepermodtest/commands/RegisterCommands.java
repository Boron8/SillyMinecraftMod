package me.creeper.creepermodtest.commands;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.command.ServerCommandManager;

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


        public static void registerAllCommands(ServerCommandManager manager) {
            ExampleMod.debugLog("Registering commands...");
            registerCommandTestTest(manager);
            registerCommandTutorial(manager);
            registerCommandVersion(manager);
            ExampleMod.debugLog("Registering commands done.");
        }
    }
}

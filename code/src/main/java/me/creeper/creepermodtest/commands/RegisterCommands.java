package me.creeper.creepermodtest.commands;

import net.minecraft.command.ServerCommandManager;

public class RegisterCommands {
    public static class RegisterCommandsHandler {
        public static void registerCommandTestTest(ServerCommandManager manager) {
            manager.registerCommand(new TestTestCommand());
        }

        public static void registerCommandTutorial(ServerCommandManager manager) {
            manager.registerCommand(new CommandTutorial());
        }


        public static void registerAllCommands(ServerCommandManager manager) {
            registerCommandTestTest(manager);
            registerCommandTutorial(manager);
        }
    }
}

package me.creeper.creepermodtest.commands;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.util.Objects;

public class CommandVersion extends CommandBase {
    public String getCommandName() {
        return "version";
    }

    public String getCommandUsage(ICommandSender commandSender) {
        return "command.version.usage";
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public void processCommand(ICommandSender commandSender, String[] args) {
        commandSender.addChatMessage(new ChatComponentText("ModID: " + ExampleMod.MODID));
        commandSender.addChatMessage(new ChatComponentText("Version: " + ExampleMod.VERSION));
        commandSender.addChatMessage(new ChatComponentText("Author: " + "Creeper9555/Boron8"));
    }
}

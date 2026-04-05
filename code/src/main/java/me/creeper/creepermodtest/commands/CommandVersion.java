package me.creeper.creepermodtest.commands;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.util.Collections;
import java.util.List;

public class CommandVersion implements ICommand {
    @Override
    public String getCommandName() { return "version"; }

    @Override
    public String getCommandUsage(ICommandSender commandSender) { return "command.version.usage"; }

    @Override
    public List getCommandAliases() { return Collections.emptyList(); }

    @Override
    public void processCommand(ICommandSender commandSender, String[] args) {
        commandSender.addChatMessage(new ChatComponentText("ModID: " + ExampleMod.MODID));
        commandSender.addChatMessage(new ChatComponentText("Version: " + ExampleMod.VERSION));
        commandSender.addChatMessage(new ChatComponentText("Author: " + "Creeper9555/Boron8"));
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) { return true; }

    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] args) { return Collections.emptyList(); }

    @Override
    public boolean isUsernameIndex(String[] args, int p_82358_2_) { return false; }

    @Override
    public int compareTo(Object o) { return 0; }
}

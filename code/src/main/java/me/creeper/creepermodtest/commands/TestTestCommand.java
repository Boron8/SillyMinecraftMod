package me.creeper.creepermodtest.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;

public class TestTestCommand extends CommandBase {

    public String getCommandName() {
        return "testtest";
    }

    public String getCommandUsage(ICommandSender commandSender) {
        return "command.testtest.usage";
    }

    public int getRequiredPermissionLevel() {
        return 2;
    }

    public void processCommand(ICommandSender commandSender, String[] args) {
        if (args.length < 1) {
            if (commandSender instanceof EntityPlayerMP) {
                EntityPlayerMP entityPlayerMP = (EntityPlayerMP) commandSender;
                entityPlayerMP.attackEntityFrom(DamageSource.outOfWorld, 1.0F);
                commandSender.addChatMessage(new ChatComponentTranslation("commands.testtest.success", entityPlayerMP.getDisplayName()));
            } else {
                commandSender.addChatMessage(new ChatComponentTranslation("commands.testtest.usage"));
            }
            return;
        }

        EntityPlayerMP targetPlayer;
        try {
            targetPlayer = getPlayer(commandSender, args[0]);
        } catch (PlayerNotFoundException e) {
            commandSender.addChatMessage(new ChatComponentTranslation("commands.testtest.playerNotFound"));
            return;
        }

        targetPlayer.attackEntityFrom(DamageSource.outOfWorld, 1.0F);
        commandSender.addChatMessage(new ChatComponentTranslation("commands.testtest.success", targetPlayer.getDisplayName()));
    }
}

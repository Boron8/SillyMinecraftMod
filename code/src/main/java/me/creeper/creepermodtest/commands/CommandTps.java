package me.creeper.creepermodtest.commands;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.util.Iterator;

public class CommandTps extends CommandBase {
    @Override
    public String getCommandName() { return "tps"; }

    @Override
    public String getCommandUsage(ICommandSender sender) { return "command.tps.usage"; }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        Iterator<Long> it = ExampleMod.tickTimesNS.values().descendingIterator();

        int i = 0;
        int i10 = 0;
        int i20 = 0;
        int i50 = 0;
        int i100 = 0;
        long avg10 = 0;
        long avg20 = 0;
        long avg50 = 0;
        long avg100 = 0;
        while (it.hasNext() && i < 100) {
            long value = it.next();
            if (i < 10)  { avg10  += value; i10++;  }
            if (i < 20)  { avg20  += value; i20++;  }
            if (i < 50)  { avg50  += value; i50++;  }
            if (i < 100) { avg100 += value; i100++; }
            i++;
        }

        if (i != 0) {
            avg10 /= i10;
            avg20 /= i20;
            avg50 /= i50;
            avg100 /= i100;

            sender.addChatMessage(new ChatComponentText(String.format("10t: %.2f mspt", avg10 / 1_000_000.0)));
            sender.addChatMessage(new ChatComponentText(String.format("20t: %.2f mspt", avg20 / 1_000_000.0)));
            sender.addChatMessage(new ChatComponentText(String.format("50t: %.2f mspt", avg50 / 1_000_000.0)));
            sender.addChatMessage(new ChatComponentText(String.format("100t: %.2f mspt", avg100 / 1_000_000.0)));
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}

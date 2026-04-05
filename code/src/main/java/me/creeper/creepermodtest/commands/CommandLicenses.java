package me.creeper.creepermodtest.commands;

import me.creeper.creepermodtest.licenseManager.LicenseLoader;
import me.creeper.creepermodtest.utils.NumberUtils;
import net.minecraft.command.*;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

import java.util.*;

public class CommandLicenses implements ICommand {

    @Override
    public String getCommandName() { return "licenses"; }

    @Override
    public String getCommandUsage(ICommandSender sender) { return "command.licenses.usage"; }

    @Override
    public List getCommandAliases() { return Collections.emptyList(); }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            int i = 1;
            for (String licenseName : LicenseLoader.licensesFilenames) {
                sender.addChatMessage(new ChatComponentText(i + ". /" + getCommandName() + " " + licenseName));
                i++;
            }
        } else if (args.length == 1) {
            String licenseText = "";
            String licenseName = args[0];
            if (NumberUtils.isInteger(licenseName)) {
                int idx = Integer.parseInt(licenseName) - 1;
                if (idx < 0 || idx >= LicenseLoader.licensesTexts.size()) {
                    licenseNotFound(sender, licenseName);
                    return;
                }
                licenseText = LicenseLoader.licensesTexts.get(idx);
            } else {
                int idx = LicenseLoader.licensesFilenames.indexOf(args[0]);
                if (idx == -1) { licenseNotFound(sender, licenseName); return; }
                licenseText = LicenseLoader.licensesTexts.get(idx);
            }
            for (String line : licenseText.split("\n")) {
                IChatComponent component = new ChatComponentText(line);
                component.getChatStyle().setColor(EnumChatFormatting.DARK_AQUA);
                sender.addChatMessage(component);
            }
        } else {
            sender.addChatMessage(new ChatComponentTranslation(getCommandUsage(sender)));
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) { return true; }

    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] args) {
        if (args.length != 1) { return Collections.emptyList(); }

        return new ArrayList<>(LicenseLoader.licensesFilenames);
    }

    @Override
    public boolean isUsernameIndex(String[] args, int p_82358_2_) { return false; }

    @Override
    public int compareTo(Object o) { return 0; }



    private static void licenseNotFound(ICommandSender sender, String licenseName) {
        IChatComponent text = new ChatComponentText("License '" + licenseName + "' not found.");
        text.getChatStyle().setColor(EnumChatFormatting.DARK_AQUA);
        sender.addChatMessage(text);
    }
}

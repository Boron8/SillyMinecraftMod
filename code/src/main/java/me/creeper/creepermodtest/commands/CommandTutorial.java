package me.creeper.creepermodtest.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;

import java.util.Objects;

public class CommandTutorial extends CommandBase {
    public static String showPages =   "Pages:\n" +
                                       "  Blocks - /tutorial blocks";

    public static String showBlocks =  "Blocks:\n" +
                                       "  MallirusOre - /tutorial mallirusOre";

    public static String mallirusOre = "MallirusOre:\n" +
                                       "  Material - Rock\n" +
                                       "  Hardness - 2.5F\n" +
                                       "  Harvest - Pickaxe 2\n" +
                                       "  Generation:\n" +
                                       "    MinVeinSize: 2\n" +
                                       "    MaxVeinSize: 10\n" +
                                       "    MinY: 0\n" +
                                       "    MaxY: 70\n" +
                                       "    Replaces: Stone";

    private static class TutorialPages {
        private static void show(EntityPlayerMP player) {
            for (String message : showPages.split("\n")) {
                player.addChatMessage(new ChatComponentText(message));
            }
        }

        private static class TutorialBlocks {
            private static void show(EntityPlayerMP player) {
                for (String message : showBlocks.split("\n")) {
                    player.addChatMessage(new ChatComponentText(message));
                }
            }

            private static class TutorialBlockMallirusOre {
                private static void show(EntityPlayerMP player) {
                    for (String message : mallirusOre.split("\n")) {
                        player.addChatMessage(new ChatComponentText(message));
                    }
                }

            }
        }
    }

    public String getCommandName() {
        return "tutorial";
    }

    public String getCommandUsage(ICommandSender commandSender) {
        return "command.tutorial.usage";
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public void processCommand(ICommandSender commandSender, String[] args) {
        String arg = "";
        if (args.length >= 1) {
            arg = args[0];
        }

        arg = arg.toLowerCase();

        EntityPlayerMP playerMP = (EntityPlayerMP)commandSender;

        if (Objects.equals(arg, "")) {
            TutorialPages.show(playerMP);
        } else if (Objects.equals(arg, "blocks")) {
            TutorialPages.TutorialBlocks.show(playerMP);
        } else if (Objects.equals(arg, "mallirusore")) {
            TutorialPages.TutorialBlocks.TutorialBlockMallirusOre.show(playerMP);
        } else {
            playerMP.addChatMessage(new ChatComponentText("Unknown Page"));
        }
    }
}

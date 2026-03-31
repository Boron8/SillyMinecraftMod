package me.creeper.creepermodtest.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;

import java.util.Objects;

public class CommandTutorial extends CommandBase {
    public static String showPages =   "\nPages:\n" +
                                       "  Blocks - /tutorial blocks\n" +
                                       "  Commands - /tutorial commands";

    public static String showBlocks =  "\nBlocks:\n" +
                                       "  MallirusOre - /tutorial blocks mallirus\n" +
                                       "  TableBlock - /tutorial blocks table";

    public static String mallirusOre = "\nMallirus Ore:\n" +
                                       "  Material - Rock\n" +
                                       "  Hardness - 2.5F\n" +
                                       "  Harvest - Pickaxe 2\n" +
                                       "  Tab - tabCreepermodtest\n" +
                                       "  Generation:\n" +
                                       "    MinVeinSize: 2\n" +
                                       "    MaxVeinSize: 10\n" +
                                       "    MinY: 0\n" +
                                       "    MaxY: 70\n" +
                                       "    Replaces: Stone";

    public static String tableBlock = "\nTable Block:\n" +
                                      "  Material - Wood\n" +
                                      "  Hardness - 2.0F\n" +
                                      "  Harvest - Axe 1\n" +
                                      "  Light Level - 0.1F\n" +
                                      "  Tab - tabCreepermodtest";


    public static String showCommands =  "\nCommands:\n" +
                                         "  Version - /tutorial commands version\n" +
                                         "  Tutorial - /tutorial commands tutorial\n" +
                                         "  TestTest - /tutorial commands testtest";

    public static String versionCommand = "\nVersion Command:\n" +
                                          "  Permission - All, 0\n" +
                                          "  Usage - /version\n" +
                                          "  Description - Shows current mod version and info.";

    public static String tutorialCommand = "\nTutorial Command:\n" +
                                           "  Permission - All, 0\n" +
                                           "  Usage - /tutorial {page} {subpage}\n" +
                                           "  Description - A tutorial about this mod.";

    public static String TestTestCommand = "\nTestTest Command:\n" +
                                            "  Permission - OP, 2 (Maybe broken)\n" +
                                            "  Usage - /testtest {playername}\n" +
                                            "  Description - Damages a player with 1.0F of outOfWorld damage.";


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

            private static class TutorialMallirusOre {
                private static void show(EntityPlayerMP player) {
                    for (String message : mallirusOre.split("\n")) {
                        player.addChatMessage(new ChatComponentText(message));
                    }
                }
            }

            private static class TutorialBlockTable {
                private static void show(EntityPlayerMP player) {
                    for (String message : tableBlock.split("\n")) {
                        player.addChatMessage(new ChatComponentText(message));
                    }
                }
            }
        }

        private static class TutorialCommands {
            private static void show(EntityPlayerMP player) {
                for (String message : showCommands.split("\n")) {
                    player.addChatMessage(new ChatComponentText(message));
                }
            }

            private static class TutorialVersion {
                private static void show(EntityPlayerMP player) {
                    for (String message : versionCommand.split("\n")) {
                        player.addChatMessage(new ChatComponentText(message));
                    }
                }
            }

            private static class TutorialTutorial {
                private static void show(EntityPlayerMP player) {
                    for (String message : tutorialCommand.split("\n")) {
                        player.addChatMessage(new ChatComponentText(message));
                    }
                }
            }

            private static class TutorialTestTest {
                private static void show(EntityPlayerMP player) {
                    for (String message : TestTestCommand.split("\n")) {
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
        String page = "";
        String subPage = "";
        if (args.length >= 1) {
            page = args[0].toLowerCase();
        }
        if (args.length >= 2) {
            subPage = args[1].toLowerCase();
        }

        if (!(commandSender instanceof EntityPlayerMP)) {
            commandSender.addChatMessage(new ChatComponentText("Must run as a player!"));
            return;
        }

        EntityPlayerMP playerMP = (EntityPlayerMP)commandSender;

        if (Objects.equals(page, "")) {
            TutorialPages.show(playerMP);
            return;
        } else if (Objects.equals(page, "blocks")) {
            if (subPage.isEmpty()) {
                TutorialPages.TutorialBlocks.show(playerMP);
                return;
            } else if (Objects.equals(subPage, "mallirus")) {
                TutorialPages.TutorialBlocks.TutorialMallirusOre.show(playerMP);
                return;
            } else if (Objects.equals(subPage, "table")) {
                TutorialPages.TutorialBlocks.TutorialBlockTable.show(playerMP);
                return;
            } else {
                playerMP.addChatMessage(new ChatComponentText("Unknown SubPage"));
                return;
            }
        } else if (Objects.equals(page, "commands")) {
            if (subPage.isEmpty()) {
                TutorialPages.TutorialCommands.show(playerMP);
                return;
            } else if (Objects.equals(subPage, "version")) {
                TutorialPages.TutorialCommands.TutorialVersion.show(playerMP);
                return;
            } else if (Objects.equals(subPage, "tutorial")) {
                TutorialPages.TutorialCommands.TutorialTutorial.show(playerMP);
                return;
            } else if (Objects.equals(subPage, "testtest")) {
                TutorialPages.TutorialCommands.TutorialTestTest.show(playerMP);
                return;
            } else {
                playerMP.addChatMessage(new ChatComponentText("Unknown SubPage"));
                return;
            }
        } else {
            playerMP.addChatMessage(new ChatComponentText("Unknown Page"));
            return;
        }
    }

    // idk maybe unsafe, but idc, its the only thing that works. -Boron8
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}

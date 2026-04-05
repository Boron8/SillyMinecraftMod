package me.creeper.creepermodtest.commands.TutorialPages;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import org.luaj.vm2.ast.Str;

import java.util.*;

public class CommandTutorial implements ICommand {

    private static final Map<String, TutorialPage> pages = new LinkedHashMap<>();

    static {
        TutorialPage blocksPage = new TutorialPage("Blocks");
        TutorialPage commandsPage = new TutorialPage("Commands");

        blocksPage.addSubPage("mallirus", new TutorialPage(
                "Mallirus Ore",
                Arrays.asList(
                        "Material - Rock",
                        "Hardness - 2.5F",
                        "Harvest - Pickaxe 2",
                        "Tab - tabCreepermodtest",
                        "Generation:",
                        "  MinVeinSize: 2",
                        "  MaxVeinSize: 10",
                        "  MinY: 0",
                        "  MaxY: 70",
                        "  Replaces: Stone"
                )
        ));
        blocksPage.addSubPage("table", new TutorialPage(
                "Table",
                Arrays.asList(
                        "Table Block:",
                        "Material - Wood",
                        "Hardness - 2.0F",
                        "Harvest - Axe 1",
                        "Light Level - 0.1F",
                        "Tab - tabCreepermodtest"
                )
        ));

        commandsPage.addSubPage("version", new TutorialPage(
                "Version",
                Arrays.asList(
                        "Side - Client",
                        "Permission - All, 0",
                        "Usage - /version",
                        "Description - Shows current mod version and info."

                )
        ));
        commandsPage.addSubPage("tutorial", new TutorialPage(
                "Tutorial",
                Arrays.asList(
                        "Side - Client",
                        "Permission - All, 0",
                        "Usage - /tutorial {page} {subpage}",
                        "Description - A tutorial about this mod."
                )
        ));
        commandsPage.addSubPage("testtest", new TutorialPage(
                "TestTest",
                Arrays.asList(
                        "Side - Server",
                        "Permission - OP, 2 (Maybe broken)",
                        "Usage - /testtest {playername}",
                        "Description - Damages a player with 1.0F of outOfWorld damage."
                )
        ));

        pages.put("blocks",    blocksPage);
        pages.put("commands", commandsPage);
    }


    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (!(sender instanceof EntityPlayer)) {
            sender.addChatMessage(new ChatComponentText("Must run as a player!"));
            return;
        }

        EntityPlayer player = (EntityPlayer)sender;

        if (args.length == 0) {
            showAllPages(player);
            return;
        }

        String pageKey = args[0].toLowerCase();
        TutorialPage page = pages.get(pageKey);

        if (page == null) {
            player.addChatMessage(new ChatComponentText("§cUnknown Page"));
            return;
        }

        if (args.length == 1) {
            page.show(player);
            return;
        }

        String subPageKey = args[1].toLowerCase();
        TutorialPage subPage = page.getSubPage(subPageKey);

        if (subPage == null) {
            player.addChatMessage(new ChatComponentText("§cUnknown SubPage"));
            return;
        }

        subPage.show(player);
    }

    private void showAllPages(EntityPlayer player) {
        player.addChatMessage(new ChatComponentText(""));
        player.addChatMessage(new ChatComponentText("Pages:"));
        ChatComponentText text = new ChatComponentText("");
        for (String key : pages.keySet()) {
            text.appendText(key + ", ");
        }
        player.addChatMessage(text);
    }


    // --- ICommand Implementation --- \\
    @Override
    public String getCommandName() { return "tutorial"; }

    @Override
    public String getCommandUsage(ICommandSender commandSender) {
        return "command.tutorial.usage";
    }

    @Override
    public List getCommandAliases() { return Collections.emptyList(); }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) { return true; }

    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] args) {
        if (args.length == 1) {
            return new ArrayList<>(pages.keySet());
        }

        if (args.length == 2) {
            String pageKey = args[0].toLowerCase();
            TutorialPage page = pages.get(pageKey);
            if (page != null) {
                return new ArrayList<>(page.getSubPages().keySet());
            }
        }

        return Collections.emptyList();
    }

    @Override
    public boolean isUsernameIndex(String[] args, int p_82358_2_) { return false; }

    @Override
    public int compareTo(Object o) { return 0; }
}

package me.creeper.creepermodtest.commands.TutorialPages;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import java.util.*;

public class CommandTutorial implements ICommand {

    private static final Map<String, TutorialPage> pages = new LinkedHashMap<>();

    static {
        TutorialPage blocksPage = new TutorialPage("Blocks");
        TutorialPage commandsPage = new TutorialPage("Commands");
        TutorialPage otherModsPage = new TutorialPage("OtherMods");

        blocksPage.addSubPage("mallirus", new TutorialPage(
                "Mallirus Ore",
                Arrays.asList(
                        "Material - Rock",
                        "Hardness - 2.5",
                        "Harvest - Pickaxe 2",
                        "Tab - tabCreepermodtest",
                        "Generation:",
                        "  MinVeinSize: 2",
                        "  MaxVeinSize: 10",
                        "  MinY: 0",
                        "  MaxY: 70",
                        "  Replaces: Stone",
                        "  Dimensions: Overworld",
                        "Descriptions: A common ore (i will make it less common), used to make other crafting materials"
                )
        ));
        blocksPage.addSubPage("table", new TutorialPage(
                "Table",
                Arrays.asList(
                        "Table Block:",
                        "Material - Wood",
                        "Hardness - 2.0",
                        "Harvest - Axe 1",
                        "Light Level - 0.1F",
                        "Tab - tabCreepermodtest",
                        "Descriptions: An early test block"
                )
        ));
        blocksPage.addSubPage("copper", new TutorialPage(
                "Copper Ore",
                Arrays.asList(
                        "Material - Rock",
                        "Hardness - 2.5",
                        "Harvest - Pickaxe 2",
                        "Tab - tabCreepermodtest",
                        "Generation:",
                        "  MinVeinSize: 3",
                        "  MaxVeinSize: 8",
                        "  MinY: 15",
                        "  MaxY: 60",
                        "  Replaces: Stone",
                        "  Dimensions: Overworld",
                        "Descriptions: A common ore "
                )
        ));
        blocksPage.addSubPage("tungsten", new TutorialPage(
                "Tungsten Ore",
                Arrays.asList(
                        "Material - Rock",
                        "Hardness - 4",
                        "Harvest - Pickaxe 3",
                        "Tab - tabCreepermodtest",
                        "Generation:",
                        "  MinVeinSize: 2",
                        "  MaxVeinSize: 6",
                        "  MinY: 10",
                        "  MaxY: 38",
                        "  Replaces: Netherrack",
                        "  Dimensions: Nether",
                        "Descriptions: A rare-ish ore found in nether, originally made for the End but that didn't work, maybe ill do something in the end later"
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
        commandsPage.addSubPage("licenses", new TutorialPage(
                "Licenses",
                Arrays.asList(
                        "Side - Client",
                        "Permission - All, 0",
                        "Usage - /licenses [project]",
                        "Description - Displays a license for different projects, no project shows what projects are available."
                )
        ));
        commandsPage.addSubPage("tps", new TutorialPage(
                "Tps",
                Arrays.asList(
                        "Side - Server",
                        "Permission - All, 0",
                        "Usage - /tps",
                        "Description - Shows MSPT (milli-seconds per tick). Displays MSPT over 10/20/50/100 ticks. One tick may last max 50ms before TPS lag. If MSPT is lower than 50ms, will cause TPS lag. Lower MSPT is better, 0=ideal 0-50=ok 50=max 50+=bad, Actual TPS display may come later."
                )
        ));

        otherModsPage.addSubPage("required", new TutorialPage(
                "Required Mods",
                Arrays.asList(
                        "Any Mixin provider (UniMixins Recommended) - Provides the mixin library to minecraft"
                )
        ));
        otherModsPage.addSubPage("recommended", new TutorialPage(
                "Recommended Mods",
                Arrays.asList(
                        "Laggoggles backported - See whats lagging your world",
                        "(GTNH) NotEnoughItems - See items recipes easily, GTNH version provides extra functionality like bookmarks and GUI tabs",
                        "Waila - What Am I Looking At, see what your pointing at",
                        "Spark - See whats lagging, primarily for servers, lag goggles is recommended over spark",
                        "JourneyMap / MapWriter 2 - A minimap and world map to see your surroundings and what you've explored, MapWriter is a good opensource alternative to JourneyMap"
                )
        ));

        pages.put("blocks",    blocksPage);
        pages.put("commands",  commandsPage);
        pages.put("othermods", otherModsPage);
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
    public String getCommandUsage(ICommandSender commandSender) { return "command.tutorial.usage"; }

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

package me.creeper.creepermodtest.commands.TutorialPages;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TutorialPage {
    private final String title;
    private final List<String> content = new ArrayList<>();
    private final Map<String, TutorialPage> subPages = new LinkedHashMap<>();

    public TutorialPage(String title) {
        this.title = title;
    }

    public TutorialPage(String title, List<String> content) {
        this.title = title;
        this.content.addAll(content);
    }

    public void addSubPage(String key, TutorialPage page) {
        subPages.put(key.toLowerCase(), page);
    }

    public void show(EntityPlayer player) {
        player.addChatMessage(new ChatComponentText(""));
        player.addChatMessage(new ChatComponentText(title + ":"));
        for (String line : content) {
            player.addChatMessage(new ChatComponentText("  " + line));
        }
        if (!subPages.isEmpty()) {
            player.addChatMessage(new ChatComponentText("  SubPages: " + String.join(", ", subPages.keySet())));
        }
    }
    
    public TutorialPage getSubPage(String key) {
        return subPages.get(key.toLowerCase());
    }

    public Map<String, TutorialPage> getSubPages() {
        return subPages;
    }
}

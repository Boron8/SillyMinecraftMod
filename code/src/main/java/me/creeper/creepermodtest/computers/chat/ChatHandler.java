package me.creeper.creepermodtest.computers.chat;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.computers.Result;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.ServerChatEvent;

public class ChatHandler {
    @SubscribeEvent
    public void onPlayerChat(ServerChatEvent event) {
        EntityPlayerMP player = event.player;
        String message = event.message;

        if (ExampleMod.luaSandbox == null) { return; }

        if (!message.startsWith("!lua ")) return;

        String command = message.replace("<\\n>", "\n");
        command = command.substring(5);

        Result result = ExampleMod.luaSandbox.run(command);
        String out = result.msg;

        String color = result.error ? "§c" : "§a";

        for (String line : out.split("\n")) {
            player.addChatMessage(new ChatComponentText(color+line));
        }
    }
}

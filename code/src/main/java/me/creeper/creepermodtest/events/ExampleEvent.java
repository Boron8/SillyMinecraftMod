package me.creeper.creepermodtest.events;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ExampleEvent extends Event {
    public final Stage stage;
    public final EntityPlayer player;
    public final ItemStack item;

    public ExampleEvent(Stage stage, EntityPlayer player, ItemStack item) {
        this.stage = stage;
        this.player = player;
        this.item = item;
    }
}

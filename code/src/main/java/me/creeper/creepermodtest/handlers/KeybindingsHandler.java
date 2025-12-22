package me.creeper.creepermodtest.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import me.creeper.creepermodtest.keyBindings.KeybindingToggleTestRenderer;

public class KeybindingsHandler {
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (KeybindingToggleTestRenderer.toggleTestRendererKey.isPressed()) {
            KeybindingToggleTestRenderer.value = !KeybindingToggleTestRenderer.value;
        }
    }
}

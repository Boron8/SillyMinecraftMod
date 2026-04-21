package me.creeper.creepermodtest.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.keyBindings.KeybindingToggleTestRenderer;

public class KeybindingsHandler {
    public static int phase = 0;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (KeybindingToggleTestRenderer.toggleTestRendererKey.isPressed()) {
            KeybindingToggleTestRenderer.value = !KeybindingToggleTestRenderer.value;

            phase = (phase + 1) % 6;

            float yaw = 0F;
            float pitch = 0F;

            switch (phase) {
                case 0:
                    yaw = 0F;
                    pitch = 0F;
                    break;
                case 1:
                    yaw = 90F;
                    pitch = 0F;
                    break;
                case 2:
                    yaw = 180F;
                    pitch = 0F;
                    break;
                case 3:
                    yaw = 270F;
                    pitch = 0F;
                    break;
                case 4:
                    yaw = 0F;
                    pitch = -90F;
                    break;
                case 5:
                    yaw = 0F;
                    pitch = 90F;
                    break;
            }

            ExampleMod.mc.thePlayer.rotationYaw = yaw;
            ExampleMod.mc.thePlayer.rotationPitch = pitch;
        }
    }
}

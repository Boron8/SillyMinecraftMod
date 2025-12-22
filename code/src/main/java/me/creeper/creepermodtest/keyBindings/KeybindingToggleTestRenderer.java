package me.creeper.creepermodtest.keyBindings;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class KeybindingToggleTestRenderer {
    public static boolean value;
    public static KeyBinding toggleTestRendererKey;

    public static void register() {
        toggleTestRendererKey = new KeyBinding("key.creepermodtest.toggleTestRenderer", Keyboard.KEY_L, "key.categories.creepermodtest");
        ClientRegistry.registerKeyBinding(toggleTestRendererKey);
    }
}

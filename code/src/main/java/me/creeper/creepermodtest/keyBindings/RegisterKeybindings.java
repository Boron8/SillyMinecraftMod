package me.creeper.creepermodtest.keyBindings;

import me.creeper.creepermodtest.ExampleMod;

public class RegisterKeybindings {
    public static void registerAllKeybindings() {
        ExampleMod.debugLog("Registering KeyBinds...");
        KeybindingToggleTestRenderer.register();
        ExampleMod.debugLog("Registering KeyBinds done.");
    }
}

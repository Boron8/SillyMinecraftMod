package me.creeper.creepermodtest.generation;

import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterOreGeneration {
    public static class RegisterOreGenerationHandler {
        public static void registerGenerationMallirusOre() {
            GameRegistry.registerWorldGenerator(new MallirusOreGeneration(), 0);
        }

        public static void registerAllGeneration() {
            registerGenerationMallirusOre();
        }
    }
}

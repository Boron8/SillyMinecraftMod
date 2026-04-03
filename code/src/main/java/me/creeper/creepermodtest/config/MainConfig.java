package me.creeper.creepermodtest.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class MainConfig extends BaseConfig {
    public Boolean debug_print;

    public MainConfig(File configFile) {
        super(configFile, "main");
    }

    @Override
    protected void loadValues() {
        debug_print = this.configuration.getBoolean("debug_print", Configuration.CATEGORY_GENERAL, false, "Enable debug print mode");
    }

    @Override
    protected void onFailedToLoad() {
        debug_print = true;
    }
}

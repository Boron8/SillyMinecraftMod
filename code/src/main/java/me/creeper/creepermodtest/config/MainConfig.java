package me.creeper.creepermodtest.config;

import java.io.File;

public class MainConfig extends BaseConfig {
    public Boolean debug_print = true;

    public Boolean computers_enabled = false;
    public Boolean computer_allow_network = false;

    public MainConfig(File configFile) {
        super(configFile, "main");
    }

    @Override
    protected void loadValues() {
        debug_print            = this.configuration.getBoolean("debug_print", "general", false, "Enable debug print mode");

        computer_allow_network = this.configuration.getBoolean("computer_allow_network", "computers", false, "Allow computers to use HTTP(S) functions");
        computers_enabled      = this.configuration.getBoolean("computers_enabled", "computers", false, "Allow computers to work");
    }

    @Override
    protected void onFailedToLoad() {
        debug_print = true;
    }
}

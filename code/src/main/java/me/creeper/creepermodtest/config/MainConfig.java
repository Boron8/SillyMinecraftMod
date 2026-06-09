package me.creeper.creepermodtest.config;

import java.io.File;

public class MainConfig extends BaseConfig {
    public Boolean debug_print = true;

    public Boolean computer_allow_network = false;
    public Boolean computers_enabled = false;
    public int     computers_execution_delay = 50;
    public int     computers_base64_decode_max_bytes = 4096;
    public int     computers_base64_encode_max_bytes = 4096;

    public boolean dev_command = false;

    public MainConfig(File configFile) {
        super(configFile, "main");
    }

    @Override
    protected void loadValues() {
        debug_print               = this.configuration.getBoolean("debug_print", "general", false, "Enable debug print mode");

        computer_allow_network    = this.configuration.getBoolean("computer_allow_network", "computers", false, "Allow computers to use HTTP(S) functions");
        computers_enabled         = this.configuration.getBoolean("computers_enabled", "computers", false, "Allow computers to work");
        computers_execution_delay = this.configuration.getInt("computers_execution_delay", "computers", 50, 0, 1000, "Allow computers to work");
        computers_base64_decode_max_bytes = this.configuration.getInt("computers_base64_decode_max_bytes", "computers", 4096, 0, Integer.MAX_VALUE, "Max bytes that can be decoded from base64 at a time. In input bytes.");
        computers_base64_decode_max_bytes = this.configuration.getInt("computers_base64_encode_max_bytes", "computers", 4096, 0, Integer.MAX_VALUE, "Max bytes that can be encoded from base64 at a time. In input bytes.");

        dev_command               = this.configuration.getBoolean("dev_command", "commands", false, "Enables the debug command");
    }

    @Override
    protected void onFailedToLoad() {
        debug_print = true;
    }
}

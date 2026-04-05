package me.creeper.creepermodtest.config;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public abstract class BaseConfig {
    protected final File configFile;
    protected final Configuration configuration;
    protected final String name;

    public BaseConfig(File configFile, String name) {
        this.configFile = configFile;
        this.name = name;

        this.configuration = new Configuration(getConfigFile());

        this.load();
    }



    public void load() {
        try {
            configuration.load();
            loadValues();
        } catch (RuntimeException e) {
            FMLLog.warning("Failed to load configuration file: '" + name + "', at '" + configFile.getPath() + ".");
            onFailedToLoad();
        } finally {
            if (configuration.hasChanged()) {
                configuration.save();
            }
        }
    }



    public File getConfigFile() { return configFile; }

    public Configuration getConfiguration() { return configuration; }


    protected abstract void loadValues();

    protected void onFailedToLoad() {};
}

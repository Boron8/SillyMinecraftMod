package me.creeper.creepermodtest.energy.api;

public interface IEnergyHandler {
    int getEnergyStored();
    int getMaxEnergyStored();

    IEnergyHandler setEnergyStored(int energy);
    IEnergyHandler addEnergy(int energy);
    IEnergyHandler removeEnergy(int energy);
    IEnergyHandler setMaxEnergyStored(int capacity);
}

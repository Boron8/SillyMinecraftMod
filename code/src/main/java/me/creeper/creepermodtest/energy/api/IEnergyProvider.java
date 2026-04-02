package me.creeper.creepermodtest.energy.api;

public interface IEnergyProvider extends IEnergyHandler {
    int extractEnergy(int maxExtract, boolean simulate);

    int getMaxExtract();
    IEnergyProvider setMaxExtract(int maxExtract);
}

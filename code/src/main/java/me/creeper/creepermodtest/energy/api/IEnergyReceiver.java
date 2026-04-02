package me.creeper.creepermodtest.energy.api;

public interface IEnergyReceiver extends IEnergyHandler {
     int receiveEnergy(int maxReceive, boolean simulate);

     int getMaxReceive();
     IEnergyProvider setMaxReceive(int maxReceive);
}

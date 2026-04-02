package me.creeper.creepermodtest.energy.api;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TEEnergyHandler extends TileEntity implements IEnergyReceiver, IEnergyProvider {
    protected EnergyStorage storage = new EnergyStorage(1000);

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        storage.loadEnergyFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        storage.saveEnergyToNBT(nbt);
    }


    // IEnergyReceiver
    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return storage.receiveEnergy(maxReceive, simulate);
    }
    @Override
    public int getMaxReceive() {
        return storage.getMaxReceive();
    }
    @Override
    public TEEnergyHandler setMaxReceive(int maxReceive) {
        storage.setMaxReceive(maxReceive);

        return this;
    }


    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return storage.extractEnergy(maxExtract, simulate);
    }
    @Override
    public int getMaxExtract() {
        return storage.getMaxExtract();
    }
    @Override
    public TEEnergyHandler setMaxExtract(int maxExtract) {
        storage.setMaxExtract(maxExtract);

        return this;
    }


    @Override
    public int getEnergyStored() {
        return storage.getEnergyStored();
    }
    @Override
    public int getMaxEnergyStored() {
        return storage.getMaxEnergyStored();
    }
    @Override
    public TEEnergyHandler setEnergyStored(int energy) {
        storage.setEnergyStored(energy);

        return this;
    }

    @Override
    public IEnergyHandler addEnergy(int energy) {
        return storage.addEnergy(energy);
    }

    @Override
    public IEnergyHandler removeEnergy(int energy) {
        return storage.removeEnergy(energy);
    }

    @Override
    public TEEnergyHandler setMaxEnergyStored(int capacity) {
        storage.setMaxEnergyStored(capacity);

        return this;
    }
}

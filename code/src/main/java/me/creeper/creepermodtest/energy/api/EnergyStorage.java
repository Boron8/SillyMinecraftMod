package me.creeper.creepermodtest.energy.api;

import net.minecraft.nbt.NBTTagCompound;

public class EnergyStorage implements IEnergyStorage {
    protected int energy = 0;
    protected int capacity;
    protected int maxReceive;
    protected int maxExtract;


    public EnergyStorage(int capacity) {
        this(capacity, capacity, capacity);
    }

    public EnergyStorage(int capacity, int maxTransfer) {
        this(capacity, maxTransfer, maxTransfer);
    }

    public EnergyStorage(int capacity, int maxReceive, int maxExtract) {
        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
    }

    public boolean isFull() {
        return getEnergyStored() == getMaxEnergyStored();
    }

    public EnergyStorage loadEnergyFromNBT(NBTTagCompound nbt) {
        this.energy = nbt.getInteger("energy");

        if (energy > capacity) {
            energy = capacity;
        }

        return this;
    }
    public EnergyStorage saveEnergyToNBT(NBTTagCompound nbt) {
        if (energy < 0) {
            energy = 0;
        }
        nbt.setInteger("energy", energy);

        return this;
    }


    @Override
    public int getMaxExtract()      { return maxExtract;   }
    @Override
    public int getMaxReceive()      { return maxReceive;   }
    @Override
    public int getEnergyStored()    { return energy;       }
    @Override
    public int getMaxEnergyStored() { return capacity;     }


    @Override
    public EnergyStorage setEnergyStored(int energy) {
        this.energy = energy;

        if (this.energy > capacity) {
            this.energy = capacity;
        } else if (this.energy < 0) {
            this.energy = 0;
        }

        return this;
    }

    @Override
    public IEnergyHandler addEnergy(int energy) {
        return setEnergyStored(getEnergyStored() + energy);
    }

    @Override
    public IEnergyHandler removeEnergy(int energy) {
        return setEnergyStored(getEnergyStored() - energy);
    }

    @Override
    public EnergyStorage setMaxEnergyStored(int capacity) {
        this.capacity = capacity;

        if (energy > capacity) {
            energy = capacity;
        }
        return this;
    }


    @Override
    public EnergyStorage setMaxReceive(int maxReceive) {
        this.maxReceive = maxReceive;

        return this;
    }
    @Override
    public EnergyStorage setMaxExtract(int maxExtract) {
        this.maxExtract = maxExtract;

        return this;
    }



    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));

        if (!simulate) {
            energy += energyReceived;
        }
        return energyReceived;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));

        if (!simulate) {
            energy -= energyExtracted;
        }
        return energyExtracted;
    }
}

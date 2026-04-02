package me.creeper.creepermodtest.energy.network;

import me.creeper.creepermodtest.energy.api.EnergyStorage;

import java.util.ArrayList;
import java.util.List;

public class EnergyNetwork {
    protected List<NetworkCable> cables  = new ArrayList<>();
    protected List<NetworkBlock> inputs  = new ArrayList<>();
    protected List<NetworkBlock> outputs = new ArrayList<>();
    private int nextIndex = 0;
    private final EnergyStorage networkBuffer = new EnergyStorage(1_000);

    public EnergyNetwork() {
        networkBuffer.setEnergyStored(0);
    }

    public void tick() {
        doInputsAndOutputs();
    }

    private void doInputsAndOutputs() {
        if (!inputs.isEmpty()) {
            int amountChecked = 0;

            // Loop over all outputs
            for (NetworkBlock output : outputs) { // No need for output full checks, that automatic soon
                int energyLeft = output.getTEEnergyHandler().getMaxEnergyStored() - output.getTEEnergyHandler().getEnergyStored();
                // Run while: (Outputs not empty OR buffer not empty) AND input wanting more energy
                while ((amountChecked < inputs.size() || networkBuffer.getEnergyStored() > 0) && energyLeft > 0) {
                    // All outputs empty + Buffer not empty
                    if (amountChecked >= inputs.size() && networkBuffer.getEnergyStored() > 0) {
                        int extracted = networkBuffer.extractEnergy(energyLeft, false);
                        output.getTEEnergyHandler().addEnergy(extracted);
                        // Skips all if: Buffer is empty. This is an optimization trick
                        if (networkBuffer.getEnergyStored() <= 0) {
                            return;
                        }
                        continue; // Continue to next, if buffer still contains energy
                    }
                    // Loop back if: at ends of inputs
                    if (nextIndex >= inputs.size()) {
                        nextIndex = 0;
                    }

                    int extracted = inputs.get(nextIndex).getTEEnergyHandler().extractEnergy(energyLeft, false);
                    output.getTEEnergyHandler().addEnergy(extracted);
                    energyLeft -= extracted;

                    amountChecked++;
                    // Skip nextIndex increase if current input still has energy left
                    if (inputs.get(nextIndex).getTEEnergyHandler().getEnergyStored() != 0) {
                        continue;
                    }
                    nextIndex++;
                }
            }

            // Increase network buffer if: Buffer NOT full (and if non-empty outputs exist)
            if (!networkBuffer.isFull()) {
                int energyLeft = networkBuffer.getMaxEnergyStored() - networkBuffer.getEnergyStored();
                while (amountChecked < inputs.size() && energyLeft > 0) {
                    if (nextIndex >= inputs.size()) {
                        nextIndex = 0;
                    }
                    int extracted = inputs.get(nextIndex).getTEEnergyHandler().extractEnergy(energyLeft, false);
                    networkBuffer.addEnergy(extracted);
                    energyLeft -= extracted;

                    amountChecked++;
                    nextIndex++;
                }
            }
        }
    }

    public void addCable(NetworkCable cable) {
        cables.add(cable);
    }
    public void addInput(NetworkBlock networkBlock) {
        inputs.add(networkBlock);
    }
    public void addOutput(NetworkBlock networkBlock) {
        outputs.add(networkBlock);
    }
}

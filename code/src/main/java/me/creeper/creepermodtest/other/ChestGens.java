package me.creeper.creepermodtest.other;

import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChestGens {
    public static List<DevNoteData> devNotes = new ArrayList<DevNoteData>(
            Arrays.asList(
                    new DevNoteData(new String[]{"ExampleMod.java"}, 6),
                    new DevNoteData(new String[]{"Tungsten in the nether"}, 6),
                    new DevNoteData(new String[]{"/tps"}, 6)
            )
    );

    public static void addDevNotes() {
        for (DevNoteData devNote : devNotes) {
            ChestGenHooks.addItem(
                    ChestGenHooks.DUNGEON_CHEST,
                    new WeightedRandomChestContent(
                            DevNoteData.toItemStack(devNote),
                            1,
                            1,
                            devNote.weight
                    )
            );
        }
    }
}

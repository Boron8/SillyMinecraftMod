package me.creeper.creepermodtest.magic;

import net.minecraft.entity.player.EntityPlayer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MagicData {
    // UUID, unlocked keys
    private static final Map<String, Set<String>> playerUnlocks = new HashMap<>();

    public static Set<String> getUnlocks(EntityPlayer player) {
        return playerUnlocks.computeIfAbsent(
                player.getUniqueID().toString(), k -> new HashSet<>()
        );
    }

    public static void unlock(EntityPlayer player, String key) {
        getUnlocks(player).add(key);
    }

    public static boolean hasUnlock(EntityPlayer player, String key) {
        return getUnlocks(player).contains(key);
    }
}

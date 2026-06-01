package me.creeper.creepermodtest.magic;

import java.util.HashSet;
import java.util.Set;

public class MagicCache {
    private static final Set<String> unlockedKeys = new HashSet<>();

    public static void setAll(Set<String> keys) {
        unlockedKeys.clear();
        unlockedKeys.addAll(keys);
    }

    public static void add(String key) {
        unlockedKeys.add(key);
    }

    public static boolean isUnlocked(String key) {
        return unlockedKeys.contains(key);
    }

    public static void clear() {
        unlockedKeys.clear();
    }
}

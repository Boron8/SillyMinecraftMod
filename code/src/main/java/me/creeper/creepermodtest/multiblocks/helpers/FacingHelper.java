package me.creeper.creepermodtest.multiblocks.helpers;

public class FacingHelper {
    // 0 Bottom
    // 1 Up
    // 2 North
    // 3 South
    // 4 East
    // 5 West


    public static int getFacingFromMeta(int meta) {
        switch (meta) {
            case 0: return 2;
            case 1: return 5;
            case 2: return 3;
            case 3: return 4;
        }
        return 2;
    }
}

package me.creeper.creepermodtest.mixin;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(WorldGenDungeons.class)
public class WorldGenDungeonsMixin {
    @Inject(method = "generate", at = @At("RETURN"))
    public void generate(World world, Random rand, int x, int y, int z, CallbackInfoReturnable<Boolean> ci) {
        //if (!ci.getReturnValue()) return;

        //System.out.println("Dungeon at: "+x+" "+y+" "+z);
    }
}

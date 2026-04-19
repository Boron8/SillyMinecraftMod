package me.creeper.creepermodtest.mixin;

import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.utils.CTMArray;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {
    private long lastTickTime = -1;

    @Inject(method = "tick", at = @At("HEAD"))
    private void beforeTick(CallbackInfo ci) {
        lastTickTime = System.nanoTime();
    }

    @Inject(method = "tick", at = @At("RETURN"))
    private void afterTick(CallbackInfo ci) {
        if (lastTickTime != -1) {
            ExampleMod.tickTimesNS.add(System.nanoTime() - lastTickTime);
        }
    }
}

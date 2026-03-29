package me.creeper.creepermodtest.mixin;

import net.minecraft.block.BlockPistonBase;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(BlockPistonBase.class)
public class MixinPiston {
    @Inject(method = "tryExtend", at = @At("HEAD"))
    private void tryExtend(World world, int x, int y, int z, int p_150079_5_, CallbackInfoReturnable<Boolean> cir) {
        if (x == 0 && y == 60 && z == 0) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("MixinTest Working!"));
        }
    }
}

package me.creeper.creepermodtest.mixin;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.util.EnumChatFormatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GuiNewChat.class)
public class GuiNewChatMixin {
    @Redirect(
            method = "drawChat",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/FontRenderer;drawStringWithShadow(Ljava/lang/String;III)I"
            )
    )
    private int redirectDrawStringWithShadow(FontRenderer instance, String text, int x, int y, int color) {
        if (EnumChatFormatting.getTextWithoutFormattingCodes(text).endsWith("-U")) {
            return ExampleMod.unknownFontRenderer.drawStringWithShadow(text, x, y, color);
        }
        return instance.drawStringWithShadow(text, x, y, color);
    }
}

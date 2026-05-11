package me.creeper.creepermodtest.mixin;

import me.creeper.creepermodtest.ExampleMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;


@Mixin(GuiMainMenu.class)
public abstract class MixinGuiMainMenu {
    @Shadow private ResourceLocation field_110351_G;

    @Shadow @Final private static Random rand;

    /**
     * @author Boron8
     * @reason Cooler
     */
    @Overwrite
    private void rotateAndBlurSkybox(float p_73968_1_) {
        GuiMainMenu self = ((GuiMainMenu)(Object)this);

        Minecraft.getMinecraft().getTextureManager().bindTexture(field_110351_G);

        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

        GL11.glCopyTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, 0, 0, 256, 256);
        GL11.glEnable(GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColorMask(true, true, true, false);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        byte b0 = 0;

        for (int i = 0; i < b0; ++i)
        {
            tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F / (float)(i + 1));
            int j = self.width;
            int k = self.height;
            float f1 = (float)(i - b0 / 2) / 256.0F;
            tessellator.addVertexWithUV((double)j, (double)k, (double)((GuiAccessor)(Object)this).getZLevel(), (double)(0.0F + f1), 1.0D);
            tessellator.addVertexWithUV((double)j, 0.0D, (double)((GuiAccessor)(Object)this).getZLevel(), (double)(1.0F + f1), 1.0D);
            tessellator.addVertexWithUV(0.0D, 0.0D, (double)((GuiAccessor)(Object)this).getZLevel(), (double)(1.0F + f1), 0.0D);
            tessellator.addVertexWithUV(0.0D, (double)k, (double)((GuiAccessor)(Object)this).getZLevel(), (double)(0.0F + f1), 0.0D);
        }

        tessellator.draw();
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColorMask(true, true, true, true);
    }

    @Inject(method = "drawScreen", at = @At("TAIL"))
    private void onDrawScreen(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        GuiMainMenu self = ((GuiMainMenu)(Object)this);

        if (ExampleMod.guiTimer >= 10) {
            ExampleMod.guiIndex = ExampleMod.random.nextInt(ExampleMod.guiText.length());

            ExampleMod.guiChar = ExampleMod.guiOptions[ExampleMod.random.nextInt(ExampleMod.guiOptions.length)];

            StringBuilder sb = new StringBuilder(ExampleMod.originalGuiText);
            sb.setCharAt(ExampleMod.guiIndex, ExampleMod.guiChar);

            ExampleMod.guiText = sb.toString();

            ExampleMod.guiTimer = 0;
        }
        ExampleMod.guiTimer++;


        self.drawString(
                self.mc.fontRenderer,
                ExampleMod.guiText,
                5, 5,
                0xFFFFFF
        );
    }
}

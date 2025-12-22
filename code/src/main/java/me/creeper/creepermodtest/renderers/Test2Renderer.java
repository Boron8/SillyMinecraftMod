package me.creeper.creepermodtest.renderers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;

public class Test2Renderer {
    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        GL11.glPushMatrix();

        Minecraft mc = Minecraft.getMinecraft();

        double playerX = mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * event.partialTicks;
        double playerY = mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * event.partialTicks;
        double playerZ = mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * event.partialTicks;
        GL11.glTranslated(-playerX, -playerY, -playerZ);

        GL11.glTranslatef(100, 70, 100);


        GL11.glDisable(GL11.GL_TEXTURE_2D);

        GL11.glColor4f(0.0f, 1.0f, 1.0f, 0.7f);
        GL11.glScalef(1f, 1f, 1f);

        // Draw Here
        GL11.glBegin(GL11.GL_LINES);

        GL11.glVertex3d(0, 0, 0);
        GL11.glVertex3d(1, 0, 0);

        GL11.glEnd();
        // Draw Here

        GL11.glEnable(GL11.GL_TEXTURE_2D);


        GL11.glPopMatrix();
    }
}

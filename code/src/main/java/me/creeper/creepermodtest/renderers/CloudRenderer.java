package me.creeper.creepermodtest.renderers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;

public class CloudRenderer {
    @SubscribeEvent
    public void onRenderWorldLast(RenderGameOverlayEvent event) {
        GL11.glPushMatrix();

        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GL11.glColor4f(1f, 0f, 0f, 0.5f);

        drawCircle(100, 100, 50, 32);

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        GL11.glPopMatrix();

    }

    public void drawCircle(float cy, float cx, float radius, int segments) {
        GL11.glBegin(GL11.GL_LINE_LOOP);

        for (int i = 0; i < segments; i++) {
            double angle = 2 * Math.PI * i / segments;
            float x = cx + (float) Math.cos(angle) * radius;
            float y = cy + (float) Math.sin(angle) * radius;
            GL11.glVertex2f(x, y);
        }

        GL11.glEnd();
    }
}

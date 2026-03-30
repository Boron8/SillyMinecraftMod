package me.creeper.creepermodtest.renderers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.handlers.DetonatorHeldHandler;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;

import static me.creeper.creepermodtest.renderers.Utils.drawSphere;

public class TestRenderer {
    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        if (!DetonatorHeldHandler.held) {
            return;
        }

        double playerX = ExampleMod.mc.thePlayer.lastTickPosX + (ExampleMod.mc.thePlayer.posX - ExampleMod.mc.thePlayer.lastTickPosX) * event.partialTicks;
        double playerY = ExampleMod.mc.thePlayer.lastTickPosY + (ExampleMod.mc.thePlayer.posY - ExampleMod.mc.thePlayer.lastTickPosY) * event.partialTicks;
        double playerZ = ExampleMod.mc.thePlayer.lastTickPosZ + (ExampleMod.mc.thePlayer.posZ - ExampleMod.mc.thePlayer.lastTickPosZ) * event.partialTicks;
        GL11.glTranslated(-playerX, -playerY, -playerZ);

        double x = ExampleMod.mc.thePlayer.rayTrace(1000, event.partialTicks).hitVec.xCoord;
        double y = ExampleMod.mc.thePlayer.rayTrace(1000, event.partialTicks).hitVec.yCoord;
        double z = ExampleMod.mc.thePlayer.rayTrace(1000, event.partialTicks).hitVec.zCoord;
        GL11.glTranslated(x, y, z);

        GL11.glDisable(GL11.GL_TEXTURE_2D);

        GL11.glPushMatrix();
        GL11.glColor4f(1.0f, 0.0f, 0.0f, 0.7f);
        GL11.glScalef(1f, 1f, 1f);
        drawSphere(32, 8, 1, 0.01f);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glRotatef((System.currentTimeMillis() / 10) % 360, 0, -1, 0); // Rotate based on time
        GL11.glColor4f(0.0f, 1.0f, 0.0f, 0.7f);
        drawLines();
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glRotatef((System.currentTimeMillis() / 10) % 360, 0, 2, 0); // Rotate based on time
        GL11.glColor4f(0.0f, 0.0f, 1.0f, 0.7f);
        GL11.glScalef(1f, 1f, 1f);
        drawLine();
        GL11.glPopMatrix();


        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }

    public void drawLine() {
        GL11.glBegin(GL11.GL_QUADS);

        // Front
        GL11.glVertex3d(-0.5, -0,  0.5); // Bottom Left
        GL11.glVertex3d( 0.5, -0,  0.5); // Bottom Right
        GL11.glVertex3d( 0.5,  200,  0.5); // Top Right
        GL11.glVertex3d(-0.5,  200,  0.5); // Top Left

        // Back
        GL11.glVertex3d(-0.5, -0,  -0.5);
        GL11.glVertex3d(-0.5,  200,  -0.5);
        GL11.glVertex3d( 0.5,  200,  -0.5);
        GL11.glVertex3d( 0.5, -0,  -0.5);

        // Left
        GL11.glVertex3d(-0.5, -0, -0.5);
        GL11.glVertex3d(-0.5,  -0, 0.5);
        GL11.glVertex3d(-0.5,  200,  0.5);
        GL11.glVertex3d(-0.5, 200,  -0.5);

        // Right
        GL11.glVertex3d(0.5, -0, -0.5);
        GL11.glVertex3d(0.5,  200, -0.5);
        GL11.glVertex3d(0.5,  200,  0.5);
        GL11.glVertex3d(0.5, -0,  0.5);

        // Top
        GL11.glVertex3d(-0.5, 200, -0.5);
        GL11.glVertex3d(-0.5,  200, 0.5);
        GL11.glVertex3d(0.5,  200,  0.5);
        GL11.glVertex3d(0.5, 200,  -0.5);

        // Bottom
        GL11.glVertex3d(-0.5, -0, -0.5);
        GL11.glVertex3d(0.5,  -0, -0.5);
        GL11.glVertex3d(0.5,  -0,  0.5);
        GL11.glVertex3d(-0.5, -0,  0.5);

        GL11.glEnd();
    }

    public void drawLines() {
        GL11.glBegin(GL11.GL_LINES);

        long currentTime = System.currentTimeMillis();

        long period = 2000;

        double angle = 2 * Math.PI * (currentTime % period) / period;

        float len = (float)((Math.sin(angle - Math.PI / 2) + 1) / 2);

        len++;

        GL11.glVertex3d(0, 0, 0);
        GL11.glVertex3d(len, len, 0);

        GL11.glVertex3d(0, 0, 0);
        GL11.glVertex3d(0, len, len);

        GL11.glVertex3d(0, 0, 0);
        GL11.glVertex3d(-len, len, 0);

        GL11.glVertex3d(0, 0, 0);
        GL11.glVertex3d(0, len, -len);


        GL11.glVertex3d(0, 0, 0);
        GL11.glVertex3d(len, len, len);

        GL11.glVertex3d(0, 0, 0);
        GL11.glVertex3d(-len, len, len);

        GL11.glVertex3d(0, 0, 0);
        GL11.glVertex3d(len, len, -len);

        GL11.glVertex3d(0, 0, 0);
        GL11.glVertex3d(-len, len, -len);

        GL11.glEnd();
    }
}

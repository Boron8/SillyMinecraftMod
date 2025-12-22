package me.creeper.creepermodtest.renderers;

import org.lwjgl.opengl.GL11;

public class Utils {
    public static void drawSphere(int maxSegments, int minSegments, float radius, float step) {
        //maxSegments = 32;
        //minSegments = 8;
        //radius      = 1;
        //step        = 0.01f;

        for (float y = -radius; y < radius; y+=step) {
            float sliceRadius = (float)Math.sqrt(radius * radius - y * y);

            int segments = (int)(maxSegments * (sliceRadius / radius));
            segments = Math.max(segments, minSegments);

            GL11.glBegin(GL11.GL_LINE_LOOP);
            for (int i = 0; i < segments; i++) {
                double angle = 2 * Math.PI * i / segments;
                float x = (float) Math.cos(angle) * sliceRadius;
                float z = (float) Math.sin(angle) * sliceRadius;
                GL11.glVertex3f(x, y, z);
            }
            GL11.glEnd();
        }

        //GL11.glVertex3d(-0.5, -0.5,  0.5); // Bottom Left
        //GL11.glVertex3d( 0.5, -0.5,  0.5); // Bottom Right
        //GL11.glVertex3d( 0.5,  0.5,  0.5); // Top Right
        //GL11.glVertex3d(-0.5,  0.5,  0.5); // Top Left
    }
}

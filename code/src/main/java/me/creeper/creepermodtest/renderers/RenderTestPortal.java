package me.creeper.creepermodtest.renderers;

import me.creeper.creepermodtest.blocks.tileEntities.TETestPortal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

// TODO: Opaque support, optional via TE state (opt-in?)
public class RenderTestPortal extends TileEntitySpecialRenderer {

    // partial ticks = delta time
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTicks) {
        TETestPortal portal = (TETestPortal)tileEntity;

        World world = portal.getWorldObj();

        int blockX = portal.xCoord;
        int blockY = portal.yCoord;
        int blockZ = portal.zCoord;


        float time = (Minecraft.getSystemTime() % 6000L) / 6000.0F;

        float r;
        float g;
        float b;

        if (time < 0.5F) {
            float t = time * 2.0F;

            r = 1.0F - t;
            g = 0.0F;
            b = t;
        } else {
            float t = (time - 0.5F) * 2.0F;

            r = t;
            g = 0.0F;
            b = 1.0F - t;
        }


        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(
                GL11.GL_SRC_ALPHA,
                GL11.GL_ONE_MINUS_SRC_ALPHA
        );

        Tessellator tessellator = Tessellator.instance;

        tessellator.startDrawingQuads();

        tessellator.setColorRGBA_F(
                r, g, b, 1.0F
        );

        // bottom
        tessellator.addVertex( 0.0D, 0.0D, 0.0D );
        tessellator.addVertex( 1.0D, 0.0D, 0.0D );
        tessellator.addVertex( 1.0D, 0.0D, 1.0D );
        tessellator.addVertex( 0.0D, 0.0D, 1.0D );

        // top
        tessellator.addVertex( 0.0D, 1.0D, 0.0D );
        tessellator.addVertex( 0.0D, 1.0D, 1.0D );
        tessellator.addVertex( 1.0D, 1.0D, 1.0D );
        tessellator.addVertex( 1.0D, 1.0D, 0.0D );

        // north
        tessellator.addVertex( 0.0D, 0.0D, 0.0D );
        tessellator.addVertex( 0.0D, 1.0D, 0.0D );
        tessellator.addVertex( 1.0D, 1.0D, 0.0D );
        tessellator.addVertex( 1.0D, 0.0D, 0.0D );

        // south
        tessellator.addVertex( 0.0D, 0.0D, 1.0D );
        tessellator.addVertex( 1.0D, 0.0D, 1.0D );
        tessellator.addVertex( 1.0D, 1.0D, 1.0D );
        tessellator.addVertex( 0.0D, 1.0D, 1.0D );

        // west
        tessellator.addVertex( 0.0D, 0.0D, 0.0D );
        tessellator.addVertex( 0.0D, 0.0D, 1.0D );
        tessellator.addVertex( 0.0D, 1.0D, 1.0D );
        tessellator.addVertex( 0.0D, 1.0D, 0.0D );

        // east
        tessellator.addVertex( 1.0D, 0.0D, 0.0D );
        tessellator.addVertex( 1.0D, 1.0D, 0.0D );
        tessellator.addVertex( 1.0D, 1.0D, 1.0D );
        tessellator.addVertex( 1.0D, 0.0D, 1.0D );

        tessellator.draw();

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LIGHTING);

        GL11.glPopMatrix();
    }
}

package me.creeper.creepermodtest.multiblocks.testMulti;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiTestMulti extends GuiContainer {
    private static final ResourceLocation texture = new ResourceLocation("creepermodtest", "textures/gui/container/test_multi.png");
    private TileEntityTestMultiController tile;

    public GuiTestMulti(ContainerTestMulti container, TileEntityTestMultiController tile) {
        super(container);
        this.tile = tile;
        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        String name = "Test Multi";
        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        mc.getTextureManager().bindTexture(texture);

        int xx = (width - xSize) / 2;
        int yy = (height - ySize) / 2;

        drawTexturedModalRect(xx, yy, 0, 0, xSize, ySize);

        int progress = 0;
        if (tile.recipeTime > 0) {
            progress = tile.recipeTime * 24 / TileEntityTestMultiController.maxRecipeTime;
            // Burn
            this.drawTexturedModalRect(xx + 56 + 6, yy + 36, 176, 0, 14, 14);
            // Arrow
            this.drawTexturedModalRect(xx + 79 + 5, yy + 34, 176, 14, progress + 1, 16);
        }
    }
}

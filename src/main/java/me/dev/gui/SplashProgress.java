package me.dev.gui;

import me.dev.util.Wrapper;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.shader.*;
import net.minecraft.client.renderer.*;

import net.minecraft.client.gui.*;

import java.awt.*;

public class SplashProgress
{
    public static ColorEnum mainColor = ColorEnum.white;
    public static Color getSplashColor() {
        if (mainColor == ColorEnum.pink) {
            return new Color(255, 85, 255);
        }
        if (mainColor == ColorEnum.blue) {
            return new Color(85, 85, 255);
        }
        if (mainColor == ColorEnum.red) {
            return new Color(255, 85, 85);
        }
        if (mainColor == ColorEnum.pink) {
            return new Color(255, 85, 255);
        }
        if (mainColor == ColorEnum.green) {
            return new Color(85, 255, 85);
        }
        if (mainColor == ColorEnum.cyan) {
            return new Color(85, 255, 255);
        }
        if (mainColor == ColorEnum.orange) {
            return new Color(255, 170, 0);
        }
        if (mainColor == ColorEnum.gold) {
            return new Color(255, 170, 0);
        }
        if (mainColor == ColorEnum.brown) {
            return new Color(255, 170, 0);
        }
        if (mainColor == ColorEnum.white) {
            return new Color(255, 255, 255);
        }
        if (mainColor == ColorEnum.yellow) {
            return new Color(255, 255, 85);
        }
        if (mainColor == ColorEnum.darkpurple) {
            return new Color(170, 0, 170);
        }
        return new Color(0);
    }

    private static final int MAX = 60;
    private static int PROGRESS;
    private static String CURRENT;
    private static ResourceLocation splash;
    private static UnicodeFontRenderer ufr;

    static {
        SplashProgress.PROGRESS = 0;
        SplashProgress.CURRENT = "";
    }

    public static void update() {
        if (Minecraft.getMinecraft() == null || Minecraft.getMinecraft().getLanguageManager() == null) {
            return;
        }
        drawSplash(Minecraft.getMinecraft().getTextureManager());
    }

    public static void setProgress(final int givenProgress, final String givenText) {
        SplashProgress.PROGRESS = givenProgress;
        SplashProgress.CURRENT = givenText;
        update();
    }

    public static void drawSplash(final TextureManager tm) {
        final ScaledResolution scaledResolution = new ScaledResolution(Wrapper.mc, Wrapper.mc.displayWidth, Wrapper.mc.displayHeight);
        final int scaleFactor = scaledResolution.getScaleFactor();
        final Framebuffer framebuffer = new Framebuffer(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor, true);
        framebuffer.bindFramebuffer(false);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), 0.0, 1000.0, 3000.0);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0f, 0.0f, -2000.0f);
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        GlStateManager.disableDepth();
        GlStateManager.enableTexture2D();
        if (SplashProgress.splash == null) {
            String splashScreen = "Jello/mainmenubg.png";
            SplashProgress.splash = new ResourceLocation(splashScreen);
        }
        tm.bindTexture(SplashProgress.splash);
        GlStateManager.resetColor();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Gui.drawScaledCustomSizeModalRect(0, 0, 0.0f, 0.0f, 1920, 1080, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), 1920.0f, 1080.0f);
        drawProgress();
        framebuffer.unbindFramebuffer();
        framebuffer.framebufferRender(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(352, 0.1f);
        Minecraft.getMinecraft().updateDisplay();
    }

    private static void drawProgress() {
        if (Minecraft.getMinecraft().gameSettings == null || Minecraft.getMinecraft().getTextureManager() == null) {
            return;
        }
        if (SplashProgress.ufr == null) {
            SplashProgress.ufr = UnicodeFontRenderer.getFontFromAssets("jellolight",20);
        }
        final ScaledResolution sr = new ScaledResolution(Wrapper.mc, Wrapper.mc.displayWidth, Wrapper.mc.displayHeight);
        final double nProgress = SplashProgress.PROGRESS;
        final double calc = nProgress / 58.0 * sr.getScaledWidth();
        GlStateManager.resetColor();
        resetTextureState();
        GlStateManager.resetColor();
        resetTextureState();
        Gui.drawRect(0, sr.getScaledHeight() - 7, (int)calc, sr.getScaledHeight(), getSplashColor().getRGB());
        ufr.drawString(CURRENT, 20, sr.getScaledHeight() - 25, 0xffffffff);

        // Draw the current amount of progress / max amount of progress
        String s = PROGRESS + "/" + MAX;
        ufr.drawString(s, sr.getScaledWidth() - 20 - ufr.getWidth(s), sr.getScaledHeight() - 25, 0xe1e1e1ff);
    }

    private static void resetTextureState() {
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(352, 0.1f);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public static int getProgress() {
        return SplashProgress.PROGRESS;
    }
}
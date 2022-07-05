package com.mentalfrostbyte.jello.modules;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import com.mentalfrostbyte.jello.util.FontUtil;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Keyboard;

public class Coords extends Module {
    ScaledResolution sr = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
    public static boolean enabled;
    float yStart = 1;
    float xStart = 0;

    public Coords() {
        super("Coordinates", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(4);
    }

    private String getXYZString() {
        return String.format("%.3f / %.3f / %.3f", this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().getEntityBoundingBox().minY, this.mc.getRenderViewEntity().posZ);
    }

    public void onEnable(){
        enabled = true;
    }

    public void onDisable(){
        enabled = false;
    }


    public void onUpdate()
    {

        if(!this.isToggled())
            return;
        int y = 0;
        FontUtil.jelloFontMarker.drawString(this.getXYZString(), xStart, yStart + 7.5f, 0xffffffff);

    }
}

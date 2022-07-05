package com.mentalfrostbyte.jello.modules;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import me.dev.util.Vars;
import org.lwjgl.input.Keyboard;

public class Fullbright extends Module {

    private float oldGamma;

    public Fullbright() {
        super("Full Bright", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(4);
        oldGamma = mc.gameSettings.gammaSetting;
    }

    public void onEnable(){
        Vars.fullbright = true;
        oldGamma = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 1000000;
    }

    public void onDisable(){
        Vars.fullbright = false;
        mc.gameSettings.gammaSetting = oldGamma;
    }


    public void onUpdate()
    {
        if(!this.isToggled())
            return;
        Vars.fullbright = true;
        oldGamma = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 1000000;
    }


}

package me.dev.modules.movement;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import com.mentalfrostbyte.jello.util.TimerUtil;
import org.lwjgl.input.Keyboard;

import java.util.Random;

public class Fly extends Module {

    public Random rand = new Random();

    public TimerUtil timer = new TimerUtil();

    public Fly() {
        super("Fly", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(0);
    }

    public void onEnable(){
    }

    public void onDisable(){
        mc.thePlayer.capabilities.allowFlying = false;
        mc.thePlayer.capabilities.isFlying = false;
    }


    public void onUpdate()
    {
        if(!this.isToggled())
            return;
        mc.thePlayer.capabilities.allowFlying = true;
        mc.thePlayer.capabilities.isFlying = true;
    }


}

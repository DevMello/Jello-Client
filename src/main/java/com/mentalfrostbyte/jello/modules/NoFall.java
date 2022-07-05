package com.mentalfrostbyte.jello.modules;

import com.mentalfrostbyte.jello.event.events.EventPreMotion;
import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import com.mentalfrostbyte.jello.util.TimerUtil;
import net.minecraft.network.play.client.C03PacketPlayer;
import org.lwjgl.input.Keyboard;

import java.util.Random;

public class NoFall extends Module {

    public Random rand = new Random();

    public TimerUtil timer = new TimerUtil();

    public NoFall() {
        super("NoFall", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(1);
    }

    public void onEnable(){
    }

    public void onDisable(){
    }


    public void onUpdate(EventPreMotion e)
    {
        if(!this.isToggled())
            return;
        if(mc.thePlayer.fallDistance > 3) {
            e.setOnGround(true);
        }

    }


}
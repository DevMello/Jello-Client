package com.mentalfrostbyte.jello.modules;

import com.mentalfrostbyte.jello.event.EventManager;
import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.events.EventSlowDown;
import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import com.mentalfrostbyte.jello.util.BooleanValue;
import com.mentalfrostbyte.jello.util.TimerUtil;
import org.lwjgl.input.Keyboard;

public class NoSlow extends Module {


    public static double moveSpeed;
    public TimerUtil timer = new TimerUtil();
    public static boolean enabled;
    public BooleanValue run;
    public BooleanValue step;
    public BooleanValue brakes;
    private boolean resetNextTick;
    private double preY;



    public NoSlow() {
        super("NoSlow", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(0);
    }

    public void onEnable(){
        EventManager.register(this);
        enabled = true;

    }

    public void onDisable(){
        EventManager.unregister(this);
        enabled = false;
    }

    //BRAKES

    @EventTarget
    public void onSlowDown(EventSlowDown e) {

        // if (mc.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
        //   e.setCancelled(false);
        //     return;
        // }
        e.setCancelled(true);

    }


}
package com.mentalfrostbyte.jello.modules;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import com.mentalfrostbyte.jello.util.TimerUtil;
import org.lwjgl.input.Keyboard;

public class HighJump extends Module {

	
	public static double moveSpeed;
	public TimerUtil timer = new TimerUtil();
	public static boolean enabled;
	private boolean resetNextTick;
    private double preY;
	
    
    
	public HighJump() {
        super("HighJump", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(0);
    }
   
	public void onEnable(){
		//EventManager.register(this);
		enabled = true;
		
	}
	
	public void onDisable(){
		//EventManager.unregister(this);
		//mc.thePlayer.jump();
		enabled = false;
	}
	
    
	
}

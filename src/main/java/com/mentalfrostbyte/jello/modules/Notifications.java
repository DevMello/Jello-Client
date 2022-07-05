package com.mentalfrostbyte.jello.modules;

import com.mentalfrostbyte.jello.main.Module;
import org.lwjgl.input.Keyboard;

public class Notifications extends Module {

	public static boolean enabled;
	
	public Notifications() {
        super("Notifications", Keyboard.KEY_NONE);
    }
   
	public void onEnable(){
		enabled = true;
	}
	
	public void onDisable(){
		enabled = false;
	}
	
	
}

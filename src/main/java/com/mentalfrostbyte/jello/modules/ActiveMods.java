package com.mentalfrostbyte.jello.modules;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import org.lwjgl.input.Keyboard;

public class ActiveMods extends Module {

	
	public static boolean enabled;

	public ActiveMods() {
        super("ActiveMods", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(4);
    }
   
	public void onEnable(){
		enabled = true;
		
	}
	
	public void onDisable(){
		enabled = false;
	}
	
}

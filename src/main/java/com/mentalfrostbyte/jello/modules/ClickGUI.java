package com.mentalfrostbyte.jello.modules;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import com.mentalfrostbyte.jello.util.TimerUtil;
import org.lwjgl.input.Keyboard;

import java.util.Random;

public class ClickGUI extends Module {

	public Random rand = new Random();
	
	public TimerUtil timer = new TimerUtil();
	
	public ClickGUI() {
        super("ClickGUI", Keyboard.KEY_RSHIFT);
    }
   
	public void onEnable(){
		if (mc.theWorld != null) {
             this.mc.displayGuiScreen(Jello.jgui);
            this.setToggled(false);
        }

	}
	
	public void onDisable(){
		
	}
	
    
	
	
}

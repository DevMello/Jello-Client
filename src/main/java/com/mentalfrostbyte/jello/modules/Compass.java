package com.mentalfrostbyte.jello.modules;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import org.lwjgl.input.Keyboard;

public class Compass extends Module {

	
	public Compass() {
        super("Compass", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(4);
    }
   
	
	
	
}

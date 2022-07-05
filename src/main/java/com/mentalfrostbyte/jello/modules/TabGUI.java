package com.mentalfrostbyte.jello.modules;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import org.lwjgl.input.Keyboard;

public class TabGUI extends Module {

	
	public TabGUI() {
        super("TabGUI", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(4);
    }
   
	
	
	
}

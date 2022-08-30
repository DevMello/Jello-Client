package me.dev.modules.player;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import me.dev.gui.logger.GUI;
import org.lwjgl.input.Keyboard;

public class Logger extends Module {
    GUI gui = new GUI();
    public Logger() {
        super("Logger", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(1);
    }


    /*
     * (non-Javadoc)
     *
     * @see EventListener#onEvent(Event)
     */
    public void onEnable(){
        //gui.init();
    }

    public void onDisable(){
        //gui.destroy();
    }



}

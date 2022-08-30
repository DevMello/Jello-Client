package me.dev.modules.player;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;

import me.dev.gui.logger.panels.ConsolePanel;
import org.lwjgl.input.Keyboard;

public class NoFall extends Module {
    public NoFall() {
        super("No Fall", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(1);
    }
    /*
     * (non-Javadoc)
     *
     * @see EventListener#onEvent(Event)
     */
    public void onEnable(){
        ConsolePanel.addToConsole("No Fall Enabled");
    }

    public void onDisable(){
    }



}

package me.dev.modules.player;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import info.sigmaclient.event.Event;
import info.sigmaclient.event.RegisterEvent;
import info.sigmaclient.event.impl.EventUpdate;
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
    }

    public void onDisable(){
    }

    @RegisterEvent(events = {EventUpdate.class})
    public void onUpdate(Event event) {
        if (event instanceof EventUpdate) {
            EventUpdate em = (EventUpdate)event;
            if(em.isPre() && mc.thePlayer.fallDistance >= 1) {
                em.setGround(true);
            }
        }
    }

}

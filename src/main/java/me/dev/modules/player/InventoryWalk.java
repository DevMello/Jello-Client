package me.dev.modules.player;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import com.mentalfrostbyte.jello.util.BooleanValue;
import info.sigmaclient.event.Event;
import info.sigmaclient.event.RegisterEvent;
import info.sigmaclient.event.impl.EventPacket;
import info.sigmaclient.event.impl.EventTick;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import org.lwjgl.input.Keyboard;

public class InventoryWalk extends Module {

    private String CARRY = "CARRY";
    public BooleanValue carry;

    public InventoryWalk() {
        super("Inventory Walk", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(0);
        carry = new BooleanValue("carry", false);
        addValue(carry);
    }

    public void onEnable(){

    }

    public void onDisable(){
    }



    @RegisterEvent(events = { EventPacket.class, EventTick.class })
    public void onUpdate(Event event) {
        if (mc.currentScreen instanceof GuiChat) {
            return;
        }
        if(event instanceof EventTick) {
            if (mc.currentScreen != null) {
                if (Keyboard.isKeyDown(200)) {
                    mc.thePlayer.rotationPitch -= 1;
                }
                if (Keyboard.isKeyDown(208)) {
                    mc.thePlayer.rotationPitch += 1;
                }
                if (Keyboard.isKeyDown(203)) {
                    mc.thePlayer.rotationYaw -= 3;
                }
                if (Keyboard.isKeyDown(205)) {
                    mc.thePlayer.rotationYaw += 3;
                }
            }
        }
        if(event instanceof EventPacket && carry.getValue()) {
            EventPacket ep = (EventPacket)event;
            if(ep.isOutgoing() && ep.getPacket() instanceof C0DPacketCloseWindow) {
                ep.setCancelled(true);
            }
        }
    }
}
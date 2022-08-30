package me.dev.modules.player;

import com.mentalfrostbyte.jello.event.events.Event;
import com.mentalfrostbyte.jello.event.events.EventTick;
import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import com.mentalfrostbyte.jello.util.BooleanValue;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import org.lwjgl.input.Keyboard;

public class InventoryWalk extends Module {

    private String CARRY = "CARRY";
    public BooleanValue carry;

    public InventoryWalk() {
        super("Inventory Walk", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(1);
        carry = new BooleanValue("carry", false);
        addValue(carry);
    }

    public void onEnable(){

    }

    public void onDisable(){
    }



    public void onUpdate(Event event) {
        if (mc.currentScreen instanceof GuiChat) {
            return;
        }
        if(event instanceof EventTick) {
            if (mc.currentScreen != null) {
                if (Keyboard.isKeyDown(200)) {
                    Minecraft.thePlayer.rotationPitch -= 1;
                }
                if (Keyboard.isKeyDown(208)) {
                    Minecraft.thePlayer.rotationPitch += 1;
                }
                if (Keyboard.isKeyDown(203)) {
                    Minecraft.thePlayer.rotationYaw -= 3;
                }
                if (Keyboard.isKeyDown(205)) {
                    Minecraft.thePlayer.rotationYaw += 3;
                }
            }
        }
    }
}
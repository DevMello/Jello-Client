package me.dev.modules.combat;

import com.mentalfrostbyte.jello.event.events.Event;
import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import me.dev.event.events.EventSendPacket;
import me.dev.util.Vars;
import net.minecraft.network.play.client.C03PacketPlayer;
import org.lwjgl.input.Keyboard;

public class Criticals extends Module {

    public void onEnable() {
        Vars.CriticlesEnabled =true;
        this.mc.thePlayer.jump();
    }

    public Criticals() {
        super("Criticals", Keyboard.KEY_NONE);
        this.jelloCat = Jello.tabgui.cats.get(2);
    }


    public void onEvent(Event var1) {
        if (var1 instanceof EventSendPacket) {
            EventSendPacket var2 = (EventSendPacket) var1;
            if (var2.getPacket() instanceof C03PacketPlayer && this.mc.thePlayer.fallDistance < 3.0F) {
                C03PacketPlayer var3 = (C03PacketPlayer) var2.getPacket();
                var3.onground = false;
            }
        }

    }

    public void onPacket(EventSendPacket e) {
        if (e.getPacket() instanceof C03PacketPlayer) {
            if(Vars.CriticlesEnabled) {
                C03PacketPlayer packet = (C03PacketPlayer) e.getPacket();
                packet.onground = false;
            }
        }
    }

    public void onDisable() {
        Vars.CriticlesEnabled =false;
    }

}
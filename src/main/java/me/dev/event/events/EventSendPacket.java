package me.dev.event.events;


import me.dev.event.Event;
import net.minecraft.network.Packet;

public class EventSendPacket extends Event<EventSendPacket> {
    Packet packet;

    public void setPacket(Packet var1) {
        this.packet = var1;
    }

    public EventSendPacket(Packet var1) {
        this.packet = var1;
    }

    public Packet getPacket() {
        return this.packet;
    }
}

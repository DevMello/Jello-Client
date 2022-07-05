package me.dev.event;

import me.dev.event.events.KeyPressedEvent;
import net.minecraft.client.Minecraft;

public class EventListener {

    protected Minecraft mc;

    public EventListener() {
        this.mc = Minecraft.getMinecraft();
    }

    public void onKeyPressed(KeyPressedEvent event) {
        System.out.println("Pressed");
    }



}
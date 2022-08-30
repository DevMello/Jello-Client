package me.dev.event.events;

import me.dev.event.Event;

public class EventRender3D extends Event {

    public float particlTicks;

    public EventRender3D(float particlTicks) {
        this.particlTicks = particlTicks;
    }

}

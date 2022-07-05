package me.dev.event.events;

import me.dev.event.CancellableEvent;

public class KeyPressedEvent extends CancellableEvent {

    private int key;

    public KeyPressedEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

}

package me.dev.event;

public class CancellableEvent extends Event {

    private boolean cancelled = false;

    public CancellableEvent() {
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public boolean setCancelled(boolean cancelled) {
        return this.cancelled = cancelled;
    }

}

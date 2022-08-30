package me.dev.event.events;

import me.dev.event.Event;


public class Render3DEvent extends Event {

	private float partialTicks;

	public Render3DEvent(float partialTicks) {
		this.partialTicks = partialTicks;
	}

	public float getPartialTicks() {
		return partialTicks;
	}

}
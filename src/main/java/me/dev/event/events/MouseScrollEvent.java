package me.dev.event.events;

import me.dev.event.CancellableEvent;

public class MouseScrollEvent extends CancellableEvent {

	private int button;

	/**
	 * @formatter:off
	 * Directions:
	 * 0 = LEFT CLICK
	 * 1 = RIGHT CLICK
	 * 2 = WHEEL CLICK
	 */
	public MouseScrollEvent(int button) {
		this.button = button;
	}
	
	public int getDirection() {
		return button;
	}
	
}
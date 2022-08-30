package me.dev.event.events;

import me.dev.event.Event;

import me.dev.util.KeyUtils.MouseButton;

public class MouseClickEvent extends Event {

	private int button;

	/**
	 * @formatter:off
	 * Directions:
	 * 0 = LEFT CLICK
	 * 1 = RIGHT CLICK
	 * 2 = WHEEL CLICK
	 * 
	 * Check the MouseButton enum (inside of the KeyUtils class) for more informations about how the mouse buttons work
	 * 
	 */
	public MouseClickEvent(int button) {
		this.button = button;
	}
	
	public int getButton() {
		return button;
	}
	
	public MouseButton getMouseButton() {
		return MouseButton.getFromDefaultCode(button);
	}

}
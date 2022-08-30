package me.dev.event.events;

import me.dev.event.CancellableEvent;


public class MessageReceivedEvent extends CancellableEvent {

	private String message;

	public MessageReceivedEvent(String message, boolean fromMinecraft) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String setMessage(String message) {
		return this.message = message;
	}

}
package me.dev.event.events;


import me.dev.event.Event;
import net.minecraft.client.multiplayer.ServerData;

public class ServerJoinEvent extends Event {

	private final ServerData serverData;

	public ServerJoinEvent(final ServerData serverData) {
		this.serverData = serverData;
	}

	public ServerData getServerData() {
		return serverData;
	}


}
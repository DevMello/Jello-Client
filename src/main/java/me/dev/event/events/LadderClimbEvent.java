package me.dev.event.events;


import me.dev.event.CancellableEvent;

public class LadderClimbEvent extends CancellableEvent {

	private double motionY;

	public LadderClimbEvent(double motionY) {
		this.motionY = motionY;
	}

	public double getMotionY() {
		return motionY;
	}

	public void setMotionY(double motionY) {
		this.motionY = motionY;
	}

}
package com.think.controller;

public abstract class Event {
	private long eventTime;
	protected final long delayTime;
	public Event(long delayTime) {
		this.delayTime = delayTime;
	}
	public void start() {
		eventTime = System.nanoTime() + eventTime;
	}
	public boolean ready() {
		return System.nanoTime() >=eventTime;
	}
	public abstract void action();
}

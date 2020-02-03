package com.centro.app.myapp;
//each call has a level, employee can handle level a, supervisor can handle level b, manager can handle level c 

public class Call {
	public char level;
	public int callId;
	
	public Call(char level, int callId) {
		this.level = level;
		this.callId = callId;
	}
	
	public char getLevel() {
		return level;
	}
}

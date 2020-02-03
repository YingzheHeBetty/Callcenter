package com.centro.app.myapp;

public class Supervisor implements Chain{
	private Chain nextInChain;
	private boolean free;
	@Override
	public void setNext(Chain c) {
		nextInChain = c;
	}
	public Supervisor(boolean status) {
		free = status;
	}
	@Override
	public void process(Call request) {
		if (free && request.getLevel() == 'b') {
			this.free = false;
			System.out.println("Supervisor is handling phone call number: " + request.callId + " at level " + request.getLevel());	
		}
		else {
			System.out.println("the supervisor is busy or can't handle the request,");
			nextInChain.process(request);
			}
	}
}

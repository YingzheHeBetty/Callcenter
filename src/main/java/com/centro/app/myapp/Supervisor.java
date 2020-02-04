package com.centro.app.myapp;
//Manager implements Chain interface
public class Supervisor implements Chain{
	private Chain nextInChain;
	private boolean free;
	private String respond;
	@Override
	public void setNext(Chain c) {
		nextInChain = c;
	}
	public Supervisor(boolean status) {
		free = status;
	}
	@Override
	public String process(Call request) {
		if (free && request.getLevel() == 'b') {
			this.free = false;
			respond = "Supervisor is handling phone call number " + request.callName + " at level " + request.getLevel();
			return respond;	
		}
		else {
			respond = "the supervisor is busy or can't handle the request," + nextInChain.process(request);
			return respond;
			}
	}
}

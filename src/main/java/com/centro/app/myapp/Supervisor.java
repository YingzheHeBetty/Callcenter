package com.centro.app.myapp;

public class Supervisor implements Chain{
	private Chain nextInChain;
	private boolean free;
	
	public void setNext(Chain c) {
		nextInChain = c;
	}
	public Supervisor(boolean status) {
		free = status;
	}
	
	public void process(Call request) {
		if (free && request.getLevel() == 2) {
			System.out.println("SupervisorProcessor : " + request.getLevel());
		}
		else {
			System.out.println("the supervisor is busy or can't handle the request");
			nextInChain.process(request);
			}
	}
}

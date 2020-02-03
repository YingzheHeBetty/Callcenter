package com.centro.app.myapp;

import java.util.*;
//Assume manager is always free and can handle request
public class Manager implements Chain{
	private boolean free;
	
	@SuppressWarnings("unused")
	private Chain nextInChain;
	
    private Deque<Call> waitlistforManager;
    @Override
	public void setNext(Chain c) {
		nextInChain = c;
	}
	public Manager(boolean free) {
		this.free = free;
		waitlistforManager = new LinkedList<Call>();
	}
	@Override
	public void process(Call request) {
		if (this.free && request.level > 'a') {
			System.out.println( " Manager is handling phone call number: " + request.callId + " at level " + request.getLevel());
			this.free = false; // change manager status to busy
		}
		else {
			 waitlistforManager.addLast(request);
			 System.out.println(" Manager is busy, call request has been added into wait list");
			}
	}
}



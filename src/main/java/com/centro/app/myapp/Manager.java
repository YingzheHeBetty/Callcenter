package com.centro.app.myapp;

//Manager implements Chain interface
public class Manager implements Chain{
	private String respond;
	private boolean free;
	@SuppressWarnings("unused")
	private Chain nextInChain;
	
 
    @Override
	public void setNext(Chain c) {
		nextInChain = c;
	}
	public Manager(boolean free) {
		this.free = free;
	}
	@Override
	public String process(Call request) {
		if (this.free && request.level > 'a') {
			this.free = false; // change manager status to busy
			respond =  " Manager is handling phone call number " + request.callName + " at level " + request.getLevel();
			
			return respond;
		}
		else {
			 respond = " Manager is busy, please call again later";
			 return respond;
			}
	}
}



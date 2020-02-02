package com.centro.app.myapp;


//Assume manager is always free and can handle request
public class Manager implements Chain{
	private Chain nextInChain;
	
	public void setNext(Chain c) {
		nextInChain = c;
	}
	
	public void process(Call request) {
		if (request.level > 1) {
			System.out.println("ManagerProcessor : " + request.getLevel());
		}
		else {
			nextInChain.process(request);
			}
	}
}



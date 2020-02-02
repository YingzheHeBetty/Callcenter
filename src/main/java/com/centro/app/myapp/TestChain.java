package com.centro.app.myapp;

public class TestChain {
	public static void main(String[] args) {
		// configure Chain of Responsibility
		Chain c1 = new Employee(true);
		Chain c2 = new Supervisor(true);
		Chain c3 = new Manager();
		c1.setNext(c2);
		c2.setNext(c3);
		
		//calling chain of responsibility
		c1.process(new Call(1));
		c1.process(new Call(2));
	    c1.process(new Call(3));
	}
}

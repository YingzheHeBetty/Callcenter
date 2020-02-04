package com.centro.app.myapp;
import java.util.concurrent.Semaphore;

//each call has a level and a name, employee can handle level a, supervisor can handle level b, manager can handle level c 
//each call is a thread, when semaphore permits(available employee's number) > 0, the call can access findcallhandler class, otherwise the call will wait until permits > 0;

public class Call extends Thread{
	Semaphore sem;
	String callName; 
    char level;
    Supervisor sup;
    Manager man;
	public Call(char level, String callName, Semaphore sem, Supervisor sup, Manager man) {
		this.level = level;
		this.callName = callName;
		this.sem = sem;
		this.sup = sup;
		this.man = man;
	}
	@Override
	public void run() {
			//System.out.println("Starting " + callName + " thread");
			try
			{
				// First, get a permit.
				System.out.println(callName + " is waiting for an employee.");
				// acquiring the lock
				sem.acquire();
				System.out.println(callName + " is connecting to an employee.");	
				
				Thread.sleep(50);
				
				//Now, accessing the shared resource(findcallhandler). Other waiting threads will wait, until this thread release the lock.
				FindCallHandler handle = new FindCallHandler(this);
				String respond = handle.getRespond();
				System.out.println(respond);
				
				Thread.sleep((long)(Math.random() * 1000)); // random call duration
				
			} catch (InterruptedException exc) {
				System.out.println(exc);		
				}
				// Release the permit
				System.out.println(callName + " ends the phone call");
				sem.release();
		}
	
	public char getLevel() {
		return this.level;
	}
	public Supervisor getSupervisor() {
		return this.sup;
	}
	public Manager getManager() {
		return this.man;
	}

}

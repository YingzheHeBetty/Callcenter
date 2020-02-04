package com.centro.app.myapp;
import java.util.concurrent.Semaphore;
import java.util.Scanner; 

public class CallCenter {

	 public static void main(String args[]) throws InterruptedException  
	 {
		 	//creating a Semaphore object Employee with number of permits 5
		 	int numberofEmployee = 5;
			Semaphore employee = new Semaphore(numberofEmployee);
			
			Manager manager = new Manager(true);
			Supervisor supervisor = new Supervisor(true);
			
			
			//creating two calls with name A and B
			Call call1 = new Call('a', "A", employee, supervisor, manager);
			Call call2 = new Call('c', "B", employee, supervisor, manager);
			Call call3 = new Call('c', "C", employee, supervisor, manager);
			Call call4 = new Call('b', "D", employee, supervisor, manager);
			Call call5 = new Call('a', "E", employee, supervisor, manager);
			Call call6 = new Call('a', "F", employee, supervisor, manager);
			
			
			// stating threads A and B 
		    call1.start(); 
		    call2.start(); 
		    call3.start();
		    call4.start();
		    call5.start();
		    call6.start();
		      
		    // waiting for threads A and B  
		    call1.join(); 
		    call2.join(); 
		    call3.join();
		    call4.join();
		    call5.join();
		    call6.join();
		    
		    // count will always remain 0 after 
		    // both threads will complete their execution 
		    System.out.println("All phone calls are ended"); 
			 
	 }
}
	

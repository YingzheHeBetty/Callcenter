package com.centro.app.myapp;

import java.util.*;

public class FindCallHandler {
	
			public static void findCallHandler(Deque<Employee> freeEmployee, Deque<Call> waitListforEmployee) {
				int waitnumber = waitListforEmployee.size();
				while(waitnumber-- > 0) {
				// check if there is any employee available
				if (freeEmployee.size() > 0) {
					//pop the first call from waitlistforEmployee
					Call request = waitListforEmployee.removeFirst();
					// pop one employee out of the free list to handle the request
					Employee em = freeEmployee.removeFirst();
					em.process(request);
					em.updateList(freeEmployee);
				}
				else {
					// if no employee is available, the request needs to stay in the waitList
					System.out.println("Sorry, please wait for a moment. There is no employee available right now");
				}
			}
	}
			public static void main(String[] args) {
				// create a waitListforEmployee using dequeue interface
				 Deque<Call> waitListforEmployee = new LinkedList<Call>();
				
				//create a list of free employee
				 Deque<Employee> freeEmployee = new LinkedList<Employee>();
				
				//configure Chain of Responsibility
				//Suppose there are 5 employees, 1 Supervisor, 1 manager
				
				Supervisor supervisor = new Supervisor(true);
				Manager manager = new Manager(true);
				int numberofEmployee = 5;
				
				for (int i = 0; i < numberofEmployee; i++) {
					Employee emp = new Employee(i, true);
					freeEmployee.addLast(emp);
					emp.setNext(supervisor);
				}	
				supervisor.setNext(manager);
				
				//calling chain of responsibility
				// a new phone call coming in, first goes into waitListforEmployee
				waitListforEmployee.addLast(new Call('a', 1));
				waitListforEmployee.addLast(new Call('a', 2));
				waitListforEmployee.addLast(new Call('a', 3));
				waitListforEmployee.addLast(new Call('b', 4));
				waitListforEmployee.addLast(new Call('a', 5));
				waitListforEmployee.addLast(new Call('c', 6));
				waitListforEmployee.addLast(new Call('a', 7));
				 
				findCallHandler(freeEmployee, waitListforEmployee);
				
	}
}

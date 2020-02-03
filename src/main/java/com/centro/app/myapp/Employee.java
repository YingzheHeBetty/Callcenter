package com.centro.app.myapp;
import java.util.*;
// each employee has a id and a status: free == true means free, free == false means busy

public class Employee implements Chain{
		private Chain nextInChain;
		private int id;
		public boolean free;
		
		public Employee(int id, boolean free) {
			this.id = id;
			this.free = free;
		}
		
		@Override
		public void setNext(Chain c) {
			nextInChain = c;
		}
		@Override
		public void process(Call request) {
			
			if (request.level == 'a') {
				System.out.println("Employee id " + this.id + " is handling phone call number "+ request.callId+ " at level " + request.getLevel());
				this.free = false;
				
			}
			else {
				 nextInChain.process(request);
				}
		}
		
		// if an employee took the phone call but he could not handle it, the phone call would be processed to the supervisor and the employee will be added back to the employeeList
		public Deque<Employee> updateList (Deque<Employee> freeEmployee) {
			if (this.free) {
				freeEmployee.addLast(this);
			}
			return freeEmployee;
		}
}
  
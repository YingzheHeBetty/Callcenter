package com.centro.app.myapp;

public class Employee implements Chain{
		private Chain nextInChain;
		private boolean free; // true : free; false: busy
		
		public void setNext(Chain c) {
			nextInChain = c;
		}
		public Employee(boolean status) {
			free = status;
		}
		
		public void process(Call request) {
			if (!free) {
				System.out.println("Sorry, please wait for an available employee");
			}
			else if (request.level == 1) {
				System.out.println("EmployeeProcessor : " + request.getLevel());
			}
			else {
				nextInChain.process(request);
				}
		}
}
  
package com.centro.app.myapp;

//Employee implement Chain interface
public class Employee implements Chain{
		private Chain nextInChain;
		private String respond;
		public Employee() {
		}
		@Override
		public void setNext(Chain c) {
			nextInChain = c;
		}
		@Override
		public String process(Call request) {
			
			if (request.level == 'a') {
				respond = "An employee is handling phone call number "+ request.callName+ " at level " + request.getLevel();
				return respond;
			}
			else {
				 respond = nextInChain.process(request);
				 return respond;
				}
		}
	
}
  

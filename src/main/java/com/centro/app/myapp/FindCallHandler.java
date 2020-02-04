package com.centro.app.myapp;


public class FindCallHandler {
			public Call request;
			public String respond;
			
			
			public FindCallHandler(Call request) {
				this.request = request;
			}
			
			public String getRespond() {
				Employee em = new Employee();
				Supervisor sup = this.request.getSupervisor(); // sup and man are global variables
				Manager man = this.request.getManager();
				em.setNext(sup);
				sup.setNext(man);
				String respond = em.process(this.request);
				return respond;
			}

	
}

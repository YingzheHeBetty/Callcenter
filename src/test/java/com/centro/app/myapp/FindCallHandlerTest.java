package com.centro.app.myapp;

import static org.junit.Assert.*;

import java.util.concurrent.Semaphore;

import org.junit.Test;

public class FindCallHandlerTest {
	
	public Supervisor sup;
	public Manager man;
	private Semaphore employee = new Semaphore(5);
	//when Sup and man are free
	@Test
		// call level is a 
	public void test1() {
		Supervisor sup = new Supervisor(true);
		Manager man = new Manager(true);
		Call call1 = new Call('a', "A", employee, sup, man);
		FindCallHandler findCallHandler1 = new FindCallHandler(call1);
		String respond = findCallHandler1.getRespond();
		String expected = "An employee is handling phone call number A at level a";
		assertEquals(respond,expected);
	}
	@Test
	// call level is b 
	public void test2() {
		Supervisor sup = new Supervisor(true);
		Manager man = new Manager(true);
		Call call2 = new Call('b', "B", employee, sup, man);
		FindCallHandler findCallHandler2 = new FindCallHandler(call2);
		String respond = findCallHandler2.getRespond();
		String expected = "Supervisor is handling phone call number B at level b";
		assertEquals(respond,expected);
	}
	@Test
	// call level is c 
	public void test3() {
		Supervisor sup = new Supervisor(true);
		Manager man = new Manager(true);
		Call call3 = new Call('c', "C", employee, sup, man);
		FindCallHandler findCallHandler3 = new FindCallHandler(call3);
		String respond = findCallHandler3.getRespond();
		String expected = "the supervisor is busy or can't handle the request, Manager is handling phone call number C at level c";
		assertEquals(respond,expected);
	}
	//when Sup is busy and man is free
		@Test
		// call level is a 
	public void test4() {
		Supervisor sup = new Supervisor(false);
		Manager man = new Manager(true);
		Call call4 = new Call('a', "D", employee, sup, man);
		FindCallHandler findCallHandler4 = new FindCallHandler(call4);
		String respond = findCallHandler4.getRespond();
		String expected = "An employee is handling phone call number D at level a";
		assertEquals(respond,expected);
	}
	@Test
	// call level is b 
	public void test5() {
		Supervisor sup = new Supervisor(false);
		Manager man = new Manager(true);
		Call call5 = new Call('b', "E", employee, sup, man);
		FindCallHandler findCallHandler5 = new FindCallHandler(call5);
		String respond = findCallHandler5.getRespond();
		String expected = "the supervisor is busy or can't handle the request, Manager is handling phone call number E at level b";
		assertEquals(respond,expected);
	}
	@Test
	// call level is c 
	public void test6() {
		Supervisor sup = new Supervisor(false);
		Manager man = new Manager(true);
		Call call6 = new Call('c', "F", employee, sup, man);
		FindCallHandler findCallHandler6 = new FindCallHandler(call6);
		String respond = findCallHandler6.getRespond();
		String expected = "the supervisor is busy or can't handle the request, Manager is handling phone call number F at level c";
		assertEquals(respond,expected);
	}
	//when Sup is free and man is busy
			@Test
			// call level is a 
		public void test7() {
			Supervisor sup = new Supervisor(true);
			Manager man = new Manager(false);
			Call call7 = new Call('a', "G", employee, sup, man);
			FindCallHandler findCallHandler7 = new FindCallHandler(call7);
			String respond = findCallHandler7.getRespond();
			String expected = "An employee is handling phone call number G at level a";
			assertEquals(respond,expected);
		}
		@Test
		// call level is b 
		public void test8() {
			Supervisor sup = new Supervisor(true);
			Manager man = new Manager(false);
			Call call8 = new Call('b', "H", employee, sup, man);
			FindCallHandler findCallHandler8 = new FindCallHandler(call8);
			String respond = findCallHandler8.getRespond();
			String expected = "Supervisor is handling phone call number H at level b";
			assertEquals(respond,expected);
		}
		@Test
		// call level is c 
		public void test9() {
			Supervisor sup = new Supervisor(true);
			Manager man = new Manager(false);
			Call call9 = new Call('c', "I", employee, sup, man);
			FindCallHandler findCallHandler9 = new FindCallHandler(call9);
			String respond = findCallHandler9.getRespond();
			String expected = "the supervisor is busy or can't handle the request, Manager is busy, please call again later";
			assertEquals(respond,expected);
		}
		//when Sup is busy and man is busy
		@Test
		// call level is a 
	public void test10() {
		Supervisor sup = new Supervisor(false);
		Manager man = new Manager(false);
		Call call10 = new Call('a', "J", employee, sup, man);
		FindCallHandler findCallHandler10 = new FindCallHandler(call10);
		String respond = findCallHandler10.getRespond();
		String expected = "An employee is handling phone call number J at level a";
		assertEquals(respond,expected);
	}
	@Test
	// call level is b 
	public void test11() {
		Supervisor sup = new Supervisor(false);
		Manager man = new Manager(false);
		Call call11 = new Call('b', "K", employee, sup, man);
		FindCallHandler findCallHandler11 = new FindCallHandler(call11);
		String respond = findCallHandler11.getRespond();
		String expected = "the supervisor is busy or can't handle the request, Manager is busy, please call again later";
		assertEquals(respond,expected);
	}
	@Test
	// call level is c 
	public void test12() {
		Supervisor sup = new Supervisor(true);
		Manager man = new Manager(false);
		Call call12 = new Call('c', "L", employee, sup, man);
		FindCallHandler findCallHandler12 = new FindCallHandler(call12);
		String respond = findCallHandler12.getRespond();
		String expected = "the supervisor is busy or can't handle the request, Manager is busy, please call again later";
		assertEquals(respond,expected);
	}
}

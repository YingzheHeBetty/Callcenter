package com.centro.app.myapp;

public interface Chain {
			 void setNext(Chain nextInChain);  // send request to the next handler
			 void process(Call request);      // handle the call
			 }

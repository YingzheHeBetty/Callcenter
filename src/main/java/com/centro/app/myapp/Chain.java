package com.centro.app.myapp;

public interface Chain {
			 void setNext(Chain nextInChain);  // send request to the next handler
			 String process(Call request);      // handle the call
			}

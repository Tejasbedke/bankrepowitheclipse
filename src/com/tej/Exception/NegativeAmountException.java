package com.tej.Exception;

public class NegativeAmountException extends Exception {

	public NegativeAmountException() {
		super();
	}
	
	public NegativeAmountException(String errmsg) {
		super(errmsg);
	}
	public NegativeAmountException(Exception e) {
		super(e);
	}
}

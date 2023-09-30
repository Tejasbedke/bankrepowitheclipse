package com.tej.Exception;

public class InsufficientBalanceException extends Exception {
	
	
	public InsufficientBalanceException(){
		super();
	}
	public InsufficientBalanceException(String errmsg){
		super(errmsg);
	}
	
	public InsufficientBalanceException(Exception e){
		super(e);
	}
	

}

package com.tej.spec;

import com.tej.Exception.AmountGreaterthanBalance;
import com.tej.Exception.InsufficientBalanceException;
import com.tej.Exception.NegativeAmountException;

public interface BankAccount {

	public void deposit(long amt)throws NegativeAmountException;
	
	public void withdraw(long amt)throws NegativeAmountException,InsufficientBalanceException;
	
	public void currentbalance();
	
	public void transfer(BankAccount acc,long amt);
	
	public String bankname();
	public String branchname();
	public String ifsc();
	
	public void setAc_No(long ac_No);
	public long getAc_No();
	
	public void setAcHName(String acHName);
	public String getAcHName();
	
	public void setAc_Balance(long ac_Balance);
	public long getAc_Balance();
	
}

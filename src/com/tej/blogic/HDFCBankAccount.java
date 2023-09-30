package com.tej.blogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.io.IOException;


import com.tej.Exception.InsufficientBalanceException;
import com.tej.Exception.NegativeAmountException;
import com.tej.spec.BankAccount;

public class HDFCBankAccount  implements BankAccount {
	
	private static final String BANKNAME;
	private static final String BRANCHNAME;
	private static final String IFSC;
	private long ac_No;
	private String acHName;
	private long ac_Balance;	
	static {
		
		String bankn=null;
		String branchn=null;
		String ifsc=null;
		try {
                BufferedReader br=new BufferedReader(new FileReader("hdfcbankdetails.txt"));
                bankn=br.readLine();
                branchn=br.readLine();
		        ifsc=br.readLine();
		        System.out.println("hdfc bank account object created");
		        System.out.println("Static variable are initializsed ");
		        System.out.println("Enter value of account details");
		}catch(FileNotFoundException e) {
			e.getStackTrace();
		}catch (IOException e) {
			e.getStackTrace();
		}
		
		BANKNAME=bankn;
		BRANCHNAME=branchn;
		IFSC=ifsc;
	}
	
	public String bankname() {
         return BANKNAME;		
	}
	public String branchname() {
		return BRANCHNAME;
	}
	public String ifsc() {
		return IFSC;
	}
	

	public long getAc_No() {
		return ac_No;
	}

	public void setAc_No(long ac_No) {
		this.ac_No = ac_No;
	}

	public String getAcHName() {
		return acHName;
	}

	public void setAcHName(String acHName) {
		this.acHName = acHName;
	}

	public long getAc_Balance() {
		return ac_Balance;
	}

	public void setAc_Balance(long ac_Balance) {
		this.ac_Balance = ac_Balance;
	}

	public static String getBankname() {
		return BANKNAME;
	}

	public static String getBranchname() {
		return BRANCHNAME;
	}

	public static String getIfsc() {
		return IFSC;
	}

	@Override
	public void deposit(long amt) throws NegativeAmountException {
            if(amt<0) {
            	throw new NegativeAmountException("Dirty fellow please insert +ve value");
            }
		  this.ac_Balance=this.ac_Balance+amt;
		  System.out.println("The "+this.ac_No+" is credited by "+amt);
		}	
	@Override
	public void withdraw(long amt) throws NegativeAmountException, InsufficientBalanceException,InputMismatchException {
              
		if(amt<0) {
			throw new NegativeAmountException();
			
		}
		else if(amt>this.getAc_Balance()) {
			throw new InsufficientBalanceException();
		}
		this.ac_Balance=this.ac_Balance-amt;
		System.out.println("The "+this.ac_No+" Debited by "+amt);
	}

	public void currentbalance() {

	}

	@Override
	public void transfer(BankAccount dest, long amt)  {
		  
	      try {
			dest.deposit(amt);
		} catch (NegativeAmountException e) {
			e.printStackTrace();
		}
	      try {
			this.withdraw(amt);
		} catch (NegativeAmountException e) {
			e.printStackTrace();
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
		}
	      
	      System.out.println("Money is debited from "+this.getAc_No()+"and credited into "+dest.getAc_No() );
	}
    @Override
	public String toString() {
		return  "HDFC Bank Account details:\n"+
				"Bank name           :->"+BANKNAME+
				"\nBranch Name        :->"+BRANCHNAME+
				"\nIFSC code          :->"+IFSC+
	            "\nAccount holder name:->"+acHName+
				"\nAccount number   :->"+ac_No+
				"\nAccount Balance  :->"+ac_Balance;				
		
	}
}
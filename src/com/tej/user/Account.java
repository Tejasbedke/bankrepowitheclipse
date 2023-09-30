package com.tej.user;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.tej.Exception.InsufficientBalanceException;
import com.tej.Exception.NegativeAmountException;
import com.tej.blogic.SBIBankAccount;
import java.util.Scanner;
public class Account {

	public static void main(String[] args)  {
		Scanner scn=new Scanner(System.in);
		com.tej.spec.BankAccount account=null;
		try {
			
			System.out.println("Enter bank Account class name");
			
			String classname=scn.next();
			Class <?>cls=Class.forName(classname);
			
			Object obj=cls.getConstructor().newInstance(); 
			
			account=(com.tej.spec.BankAccount)obj;
			
			System.out.println("Enter the Account number:->");
            account.setAc_No(scn.nextLong());scn.nextLine();
            
            System.out.println("Enter the Account Holder name");
            account.setAcHName(scn.nextLine());
            
            System.out.println("Enter the Account balance:");
            account.setAc_Balance(scn.nextLong());
            System.out.println(account);
            	
            
            while(true) {
            	
            	try {
            		System.out.println("Enter amount to deposit in to account:->");
            		account.deposit(scn.nextLong());
                    break;
            	}catch(NegativeAmountException e) {
            		e.printStackTrace();
            	}catch(InputMismatchException e) {
            		//e.getMessage();            		
            		System.err.println("please Enter only +value");
            		scn.nextLine();
                	}
            }
            System.out.println("current Account balance is:->"+account.getAc_Balance());
		
            
            
            while(true) {
            	
            	try {
            		System.out.println("Enter amount to withdraw from account:->");
            		account.withdraw(scn.nextLong());
                    break;
            	}catch(InsufficientBalanceException e) {
            		
            		//e.getMessage("Insufficient fund")
            		e.getMessage();
            	}
            	catch(NegativeAmountException e) {
            		e.printStackTrace();
            	}catch(InputMismatchException e) {
            		//e.getMessage();            		
            		System.err.println("please Enter only +value");
            		scn.nextLine();
                	}
            }
            System.out.println("current Account balance is:->"+account.getAc_Balance());
		
           
           
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		com.tej.spec.BankAccount account1=null;
		while(true) {
		try {
			
			System.out.println("Enter your account class name:->");
            
			String classname1=scn.next();
			Class <?>cls=Class.forName(classname1);
			Object obj=cls.getConstructor().newInstance();
			 account1=(com.tej.spec.BankAccount)obj;

				System.out.println("Enter the Account number:->");
	            account1.setAc_No(scn.nextLong());scn.nextLine();
	            
	            System.out.println("Enter the Account Holder name");
	            account1.setAcHName(scn.nextLine());
	            
	            System.out.println("Enter the Account balance:");
	            account1.setAc_Balance(scn.nextLong());
	            System.out.println(account1);
			account.transfer(account1, 2000);
			break;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
		System.err.println("After Transaction:->================================================================================================");
		System.out.println(account);
		System.out.println("====================================================================================================================");
        System.out.println("\n"+account1);		
}
}

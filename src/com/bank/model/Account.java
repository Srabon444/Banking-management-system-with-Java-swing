/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

import java.util.Random;

/**
 *
 * @author User
 */
public class Account {
	String memberName, accountNumber;
	double accountBalance;
        String accounttype;
        String matrialstatustype;
        String gendertype;
	
	public Account(){
		//memberName = name;
		//accountBalance = balance;
		
		Random rand = new Random();
		accountNumber = 1000 + rand.nextInt(89999) + "  ";
	}

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
	
	public void deposit(double amount){
		accountBalance += amount;
	}
	
	public void withdraw(double amount){
		if(accountBalance - amount >= 0)
			accountBalance -= amount;
		
		else
			System.out.println("Insuficient Balance!");
	}
	
	public void getBalance(){
		System.out.println("Balance: " + accountBalance);
	}
}
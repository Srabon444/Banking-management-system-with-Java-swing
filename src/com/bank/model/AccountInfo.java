/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author User
 */

public class  AccountInfo{
double interestRate = 5,  maxWithdraw;
private String name;
private String Account;
private String FatherName;
private String MothersName;
private String Birthdate;
private String Address;
private String Nationality;
private String NID;
private String email;
private String phn_no;
private String reference;
private String accType;
private String Balance;


    
/*public SavingsAccount(String name, double balance, double mW) {
	//super(name, balance);
		
	maxWithdraw = mW;
}*/
    

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMaxWithdraw() {
        return maxWithdraw;
    }

    public void setMaxWithdraw(double maxWithdraw) {
        this.maxWithdraw = maxWithdraw;
    }
    public String getName() {
        System.out.println(name);
        return name; //To change body of generated methods, choose Tools | Templates.
    }

    public String getAccount() {
        return Account; //To change body of generated methods, choose Tools | Templates.
    }

    public String getFatherName() {
        return FatherName; //To change body of generated methods, choose Tools | Templates.
    }

    public String getMotherName() {
        return MothersName; //To change body of generated methods, choose Tools | Templates.
    }

    public String getAddress() {
        return Address; //To change body of generated methods, choose Tools | Templates.
    }

    public String getDateofBirth() {
        return Birthdate; //To change body of generated methods, choose Tools | Templates.
    }

    public String getNationality() {
        return Nationality; //To change body of generated methods, choose Tools | Templates.
    }

    public String getNID() {
        return NID; //To change body of generated methods, choose Tools | Templates.
    }

    public String getEmail() {
        return email; //To change body of generated methods, choose Tools | Templates.
    }

    public String getMoblie() {
        return phn_no; //To change body of generated methods, choose Tools | Templates.
    }

    public String getReference() {
        return reference; //To change body of generated methods, choose Tools | Templates.
    }

    public void setName(String text) {
        this.name = text;
    }

    public void setAccount(String text) {
        this.Account = text;
    }

    public void setFatherName(String text) {
        this.FatherName = text;
    }

    public void setMotherName(String text) {
        this.MothersName = text;
    }

    public void setBirthDate(String text) {
        this.Birthdate = text;
    }

    public void setAddress(String text) {
        this.Address = text;
    }

    public void setNationality(String text) {
        this.Nationality = text;
    }

    public void setNID(String text) {
        this.NID = text;
    }

    public void setEmail_add(String text) {
        this.email = text;
    }

    public void setMoblie_num(String text) {
        this.phn_no = text;
    }

    public void setReference(String text) {
        this.reference = text;
    }
    public void setAccType(String text)
    {
        this.accType = text;
    }
    public String getAccType()
    {
        return accType;
    }
    public void setBalance(String text)
    {
        this.Balance = text;
    }
    public String getBalance()
    {
        return Balance;
    }
}
    

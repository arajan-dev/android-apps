package com.aravind.patientaccount;

import java.io.Serializable;

public class PatientAccount implements Serializable {
    private String name;
    private double balance;

    public PatientAccount(){
        this.name = "None";
        this.balance = 0;
    }

    public PatientAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setBalance (double balance) {
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return  this.balance;
    }

    public void withdraw(double money) {
        if(this.balance < money) {
            System.out.println("cannot withdraw, balance too low");
        }
        else {
            this.balance = this.balance - money;
        }
    }

    public void deposit(double money) {
        this.balance += money;
    }
}

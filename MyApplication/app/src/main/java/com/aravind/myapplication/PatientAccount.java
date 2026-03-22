package com.aravind.myapplication;

public class PatientAccount {

    String name;
    double balance;

    public PatientAccount() {
        this.name = "None";
        this.balance = 0;
    }
    public PatientAccount(String name, double b) {
        this.name = name;
        this.balance = b;
    }

    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public boolean setName(String name) {
        try {
            this.name = name;
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public boolean setBalance(double balance) {
        try{
            this.balance = balance;
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}

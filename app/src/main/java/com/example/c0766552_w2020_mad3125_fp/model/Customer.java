package com.example.c0766552_w2020_mad3125_fp.model;

import java.util.ArrayList;

public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private ArrayList<Bill> bills;
    private Double totalAmountToPay;

    public Customer(String customerId, String firstName, String lastName, String email, ArrayList<Bill> bills, double totalAmountToPay) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = calculateFullName();
        this.email = email;
        this.bills = bills;
        this.totalAmountToPay = totalAmountToPay;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public Double getTotalAmountToPay() {
        return totalAmountToPay;
    }

    public void setTotalAmountToPay(Double totalAmountToPay) {
        this.totalAmountToPay = totalAmountToPay;
    }

    private String calculateFullName(){
        String fullName;
        fullName = firstName + " " + lastName;
        return fullName;
    }

}

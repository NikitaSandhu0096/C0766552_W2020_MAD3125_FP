package com.example.c0766552_w2020_mad3125_fp.util;

import com.example.c0766552_w2020_mad3125_fp.model.Customer;

import java.util.ArrayList;

public class DataStorage {
    private static DataStorage dataStorage = new DataStorage();
    private ArrayList<Customer> customer = new ArrayList<>();

    public DataStorage() {
    }

    public static DataStorage getInstance(){
        return dataStorage;
    }

    public ArrayList<Customer> getCustomer(){
        return this.customer;
    }

    public void loadDetails(){
        Customer customer1 = new Customer("C0001","Nikita","Sandhu","nsandhu@gmail.com");
        Customer customer2 = new Customer("C0002","Kashyap","Jhaveri","kjhaveri@yahoo.com");
        Customer customer3 = new Customer("C0003","Kamalpreet","Kaur","kkaur@yahoo.com");
        customer.add(customer1);
        customer.add(customer2);
        customer.add(customer3);
    }
}

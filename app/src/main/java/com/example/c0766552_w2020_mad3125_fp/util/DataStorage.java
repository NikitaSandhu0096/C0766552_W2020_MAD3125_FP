package com.example.c0766552_w2020_mad3125_fp.util;

import com.example.c0766552_w2020_mad3125_fp.model.Bill;
import com.example.c0766552_w2020_mad3125_fp.model.Customer;
import com.example.c0766552_w2020_mad3125_fp.model.Hydro;
import com.example.c0766552_w2020_mad3125_fp.model.Internet;
import com.example.c0766552_w2020_mad3125_fp.model.Mobile;

import java.util.ArrayList;

public class DataStorage {
    private static DataStorage dataStorage = new DataStorage();
    private ArrayList<Customer> customer = new ArrayList<>();
    private ArrayList<Bill> bill = new ArrayList<>();

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

        Internet internet1 = new Internet("INTB0001", "19-Oct-2019", 250.00, "Rogers", 500);
        Internet internet2 = new Internet("INTB0002", "20-Nov-2019", 360.00, "Bell", 400);
        Internet internet3 = new Internet("INTB0003", "21-Dec-2019", 245.00, "Fido", 350);

        Hydro hydro1 = new Hydro("HYDB0001", "16-Nov-2019", 900.00, "Planet Earth", 600);
        Hydro hydro2 = new Hydro("HYDB0002", "15-Sep-2019", 1250.00, "Bruce Power", 500);

        Mobile mobile = new Mobile("MOBB0001","11-Jun-2019", 187.60,"Samsung", "LTE+3G 9.5GB Promo", "9753186420", 4, 230);

        customer.add(customer1);
        customer.add(customer2);
        customer.add(customer3);
    }
}

package com.example.c0766552_w2020_mad3125_fp.model;

import java.text.SimpleDateFormat;

public class Bill {
    String billId;
    String billDate;
    String billType;
    Float totalBillAmount;

    public Bill(String billId, String billDate, String billType, Float totalBillAmount) {
        this.billId = billId;
        this.billDate = billDate;
        this.billType = billType;
        this.totalBillAmount = totalBillAmount;
    }
}

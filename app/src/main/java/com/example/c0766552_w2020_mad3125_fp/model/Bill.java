package com.example.c0766552_w2020_mad3125_fp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bill {
    private String billId;
    private String billDate;
    private String billType;
    private Double totalBillAmount;

    public Bill(String billId, String billDate, String billType, Double totalBillAmount) {
        this.billId = billId;
        this.billDate = billDate;
        this.billType = billType;
        this.totalBillAmount = totalBillAmount;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public Double getTotalBillAmount() {
        return totalBillAmount;
    }

    public void setTotalBillAmount(Double totalBillAmount) {
        this.totalBillAmount = totalBillAmount;
    }
}

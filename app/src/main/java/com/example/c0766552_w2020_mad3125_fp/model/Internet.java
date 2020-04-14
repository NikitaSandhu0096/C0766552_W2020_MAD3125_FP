package com.example.c0766552_w2020_mad3125_fp.model;

public class Internet extends Bill {
    private String providerName;
    private int internetGBUsed;

    public Internet(String billId, String billDate, String billType, Double totalBillAmount, String providerName, int internetGBUsed) {
        super(billId, billDate, billType, totalBillAmount);
        this.providerName = providerName;
        this.internetGBUsed = internetGBUsed;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public int getInternetGBUsed() {
        return internetGBUsed;
    }

    public void setInternetGBUsed(int internetGBUsed) {
        this.internetGBUsed = internetGBUsed;
    }
}

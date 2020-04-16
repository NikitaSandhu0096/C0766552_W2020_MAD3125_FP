package com.example.c0766552_w2020_mad3125_fp.model;

public class Hydro extends Bill {
    private String agencyName;
    private int unitConsumed;

    public Hydro(String billId, String billDate, Double totalBillAmount, String agencyName, int unitConsumed) {
        super(billId, billDate, "Hydro", totalBillAmount);
        this.agencyName = agencyName;
        this.unitConsumed = unitConsumed;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public int getUnitConsumed() {
        return unitConsumed;
    }

    public void setUnitConsumed(int unitConsumed) {
        this.unitConsumed = unitConsumed;
    }
}

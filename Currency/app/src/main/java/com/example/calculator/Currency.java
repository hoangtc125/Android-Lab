package com.example.calculator;

public class Currency {
    private String country;
    private String donvi;
    private Double weight;
    private String mindonvi;

    public Currency() {
    }

    public Currency(String country, String donvi, Double weight, String mindonvi) {
        this.country = country;
        this.donvi = donvi;
        this.weight = weight;
        this.mindonvi = mindonvi;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getMindonvi() {
        return mindonvi;
    }

    public void setMindonvi(String mindonvi) {
        this.mindonvi = mindonvi;
    }

    // Text show in Spinner
    @Override
    public String toString()  {
        return this.getCountry() + " - (" + this.getDonvi()+")";
    }
}
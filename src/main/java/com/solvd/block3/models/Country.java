package com.solvd.block3.models;

/**
 * Java model representing a country with an ID and a name.
 */
public class Country {
    private int countryId;
    private String name;

    public Country() {}

    public Country(int countryId, String name) {
        this.countryId = countryId;
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country " + name + ":\n" +
                "Id: " + countryId + "\n";
    }
}

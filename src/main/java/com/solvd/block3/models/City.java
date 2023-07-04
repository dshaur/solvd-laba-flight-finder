package com.solvd.block3.models;

/**
 * Java model representing a city with an ID, name, and country.
 */
public class City {
    private int cityId;
    private String name;
    private Country country;

    public City() {}

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}

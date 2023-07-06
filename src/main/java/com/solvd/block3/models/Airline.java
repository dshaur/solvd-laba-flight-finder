package com.solvd.block3.models;

/**
 * Java model representing an airline with an ID and a name.
 */
public class Airline {
    private int airlineId;
    private String name;

    public Airline() {}

    public Airline(int airlineId, String name) {
        this.airlineId = airlineId;
        this.name = name;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airline " + name + ":\n" +
                "Id: " + airlineId;
    }
}

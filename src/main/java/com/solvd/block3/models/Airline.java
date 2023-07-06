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

    @Override
    public boolean equals(Object o)
    {
        Airline toCompare = (Airline) o;
        if (this.airlineId == toCompare.airlineId &&
            this.name.equals(toCompare.name))
        {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return 100 * airlineId;
    }
}

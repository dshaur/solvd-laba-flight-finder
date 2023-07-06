package com.solvd.block3.models;

/**
 * Java model representing an airport with an ID, name, city, latitude, and longitude.
 */
public class Airport {
    private int airportId;
    private String name;
    private City city;
    private double latitude;
    private double longitude;

    public Airport() {}

    public Airport(int airportId, String name, City city, double latitude, double longitude) {
        this.airportId = airportId;
        this.name = name;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Airport " + name + ":\n" +
                "Id: " + airportId + "\n" + 
                "City:\n" + city + "\n" + 
                "Latitude: " + latitude + "\n" + 
                "Longitude: " + longitude + "\n";
    }

    @Override
    public boolean equals(Object o)
    {
        Airport toCompare = (Airport) o;
        if (this.airportId == toCompare.airportId &&
            this.name.equals(toCompare.name) &&
            this.latitude == toCompare.latitude &&
            this.longitude == toCompare.longitude &&
            this.city.equals(toCompare.city))
        {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return 100 * airportId;
    }
}

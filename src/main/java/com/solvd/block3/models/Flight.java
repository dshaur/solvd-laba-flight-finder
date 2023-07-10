package com.solvd.block3.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Java model representing a flight with an ID, airline, source airport, destination airport, and price.
 */
@XmlRootElement (name="flight")
public class Flight {
    private int flightId;
    private Airline airline;
    private Airport sourceAirport;
    private Airport destinationAirport;
    private double price;

    public Flight() {}

    public Flight(int flightId, Airline airline, Airport sourceAirport, Airport destinationAirport, double price) {
        this.flightId = flightId;
        this.airline = airline;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.price = price;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(Airport sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight:\n" +
                "Id: " + flightId + "\n" + 
                "Airline:\n" + airline + "\n" + 
                "Source Airport:\n" + sourceAirport + "\n" + 
                "Destination Airport:\n" + destinationAirport + "\n" + 
                "Price: " + price;
    }
}

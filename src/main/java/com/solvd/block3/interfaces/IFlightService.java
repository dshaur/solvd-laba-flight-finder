package com.solvd.block3.interfaces;

import com.solvd.block3.models.Flight;

import java.util.ArrayList;

public interface IFlightService {
    Flight getFlight(int id);

    ArrayList<Flight> getFlightByAirline(int id);

    ArrayList<Flight> getFlightBySourceAirport(int id);

    ArrayList<Flight> getFlightByDestinationAirport(int id);

    ArrayList<Flight> getFlights();

    void insertFlight(Flight flight);

    void updateFlight(Flight flight);

    void deleteFlight(Flight flight);
}

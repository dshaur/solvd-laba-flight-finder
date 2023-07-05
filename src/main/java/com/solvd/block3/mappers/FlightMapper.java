package com.solvd.block3.mappers;

import com.solvd.block3.models.Flight;

import java.util.ArrayList;

public interface FlightMapper {
    Flight selectFlightById(int id);

    ArrayList<Flight> selectFlightByAirline(int id);

    ArrayList<Flight> selectFlightBySourceAirport(int id);

    ArrayList<Flight> selectFlightByDestinationAirport(int id);

    ArrayList<Flight> selectFlights();

    void insertFlight(Flight flight);

    void updateFlight(Flight flight);

    void deleteFlight(Flight flight);
}

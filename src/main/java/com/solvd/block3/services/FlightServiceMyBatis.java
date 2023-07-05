package com.solvd.block3.services;

import com.solvd.block3.interfaces.IAirlineService;
import com.solvd.block3.interfaces.IFlightService;
import com.solvd.block3.mappers.AirlineMapper;
import com.solvd.block3.mappers.FlightMapper;
import com.solvd.block3.models.Airline;
import com.solvd.block3.models.Flight;
import com.solvd.block3.utilities.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class FlightServiceMyBatis implements IFlightService {
    private FlightMapper flightMapper;

    public FlightServiceMyBatis(){}

    @Override
    public Flight getFlight(int id) {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            Flight flight = flightMapper.selectFlightById(id);
            return flight;
        }
    }

    @Override
    public ArrayList<Flight> getFlightByAirline(int id) {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            ArrayList<Flight> flights = flightMapper.selectFlightByAirline(id);
            return flights;
        }
    }

    @Override
    public ArrayList<Flight> getFlightBySourceAirport(int id) {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            ArrayList<Flight> flights = flightMapper.selectFlightBySourceAirport(id);
            return flights;
        }
    }

    @Override
    public ArrayList<Flight> getFlightByDestinationAirport(int id) {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            ArrayList<Flight> flights = flightMapper.selectFlightByDestinationAirport(id);
            return flights;
        }
    }

    @Override
    public ArrayList<Flight> getFlights() {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            ArrayList<Flight> flights = flightMapper.selectFlights();
            return flights;
        }
    }

    @Override
    public void insertFlight(Flight flight) {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            flightMapper.insertFlight(flight);
            session.commit();
        }
    }

    @Override
    public void updateFlight(Flight flight) {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            flightMapper.updateFlight(flight);
            session.commit();
        }
    }

    @Override
    public void deleteFlight(Flight flight) {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            flightMapper.deleteFlight(flight);
            session.commit();
        }
    }
}

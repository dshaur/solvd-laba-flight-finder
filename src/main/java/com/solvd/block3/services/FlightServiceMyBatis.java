package com.solvd.block3.services;

import com.solvd.block3.graphs.Graph;
import com.solvd.block3.interfaces.IFlightService;
import com.solvd.block3.mappers.FlightMapper;
import com.solvd.block3.models.Flight;
import com.solvd.block3.utilities.DistanceCalculator;
import com.solvd.block3.utilities.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.ArrayList;
import java.util.List;


public class FlightServiceMyBatis implements IFlightService {
    private FlightMapper flightMapper;

    public FlightServiceMyBatis(){}

    @Override
    public Flight getFlight(int id) {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            return flightMapper.selectFlightById(id);
        }
    }

    @Override
    public ArrayList<Flight> getFlightByAirline(int id) {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            return flightMapper.selectFlightByAirline(id);
        }
    }

    @Override
    public ArrayList<Flight> getFlightBySourceAirport(int id) {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            return flightMapper.selectFlightBySourceAirport(id);
        }
    }

    @Override
    public ArrayList<Flight> getFlightByDestinationAirport(int id) {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            return flightMapper.selectFlightByDestinationAirport(id);
        }
    }

    @Override
    public ArrayList<Flight> getFlights() {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            return flightMapper.selectFlights();
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

    @Override
    public List<Integer> findShortestPath(int sourceAirportId, int destinationAirportId, boolean useDistance) {
        try (SqlSession session = SessionUtil.openSession()) {
            flightMapper = session.getMapper(FlightMapper.class);
            ArrayList<Flight> flights = flightMapper.selectFlights();

            if (flights.isEmpty()) {
                return new ArrayList<>();
            }

            Graph graph = new Graph();
            for (Flight flight : flights) {
                double weight = flight.getPrice();

                if (useDistance)
                {
                    weight = DistanceCalculator.calculateDistance
                    (flight.getSourceAirport().getLatitude(),
                    flight.getSourceAirport().getLongitude(),
                    flight.getDestinationAirport().getLatitude(),
                    flight.getDestinationAirport().getLongitude()
                    );
                }

                graph.addEdge(flight.getSourceAirport().getAirportId(), flight.getDestinationAirport().getAirportId(), weight);
            }

            List<Integer> path = graph.shortestPath(sourceAirportId, destinationAirportId);
            return path;
        }
    }
}

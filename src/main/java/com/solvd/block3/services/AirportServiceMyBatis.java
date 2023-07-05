package com.solvd.block3.services;

import com.solvd.block3.interfaces.IAirportService;
import com.solvd.block3.interfaces.ICityService;
import com.solvd.block3.mappers.AirportMapper;
import com.solvd.block3.mappers.CityMapper;
import com.solvd.block3.models.Airport;
import com.solvd.block3.models.City;
import com.solvd.block3.utilities.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class AirportServiceMyBatis implements IAirportService {
    private AirportMapper airportMapper;

    public AirportServiceMyBatis(){}
    @Override
    public Airport getAirport(int id) {
        try (SqlSession session = SessionUtil.openSession()) {
            airportMapper = session.getMapper(AirportMapper.class);
            Airport airport = airportMapper.selectAirportById(id);
            return airport;
        }
    }

    @Override
    public Airport getAirportByName(String name) {
        try (SqlSession session = SessionUtil.openSession()) {
            airportMapper = session.getMapper(AirportMapper.class);
            Airport airport = airportMapper.selectAirportByName(name);
            return airport;
        }
    }

    @Override
    public ArrayList<Airport> getAirports() {
        try (SqlSession session = SessionUtil.openSession()) {
            airportMapper = session.getMapper(AirportMapper.class);
            ArrayList<Airport> airports = airportMapper.selectAirports();
            return airports;
        }
    }

    @Override
    public void insertAirport(Airport airport) {
        try (SqlSession session = SessionUtil.openSession()) {
            airportMapper = session.getMapper(AirportMapper.class);
            airportMapper.insertAirport(airport);
            session.commit();
        }
    }

    @Override
    public void updateAirport(Airport airport) {
        try (SqlSession session = SessionUtil.openSession()) {
            airportMapper = session.getMapper(AirportMapper.class);
            airportMapper.updateAirport(airport);
            session.commit();
        }
    }

    @Override
    public void deleteAirport(Airport airport) {
        try (SqlSession session = SessionUtil.openSession()) {
            airportMapper = session.getMapper(AirportMapper.class);
            airportMapper.deleteAirport(airport);
            session.commit();
        }
    }
}

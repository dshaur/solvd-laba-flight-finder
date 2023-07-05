package com.solvd.block3.services;

import com.solvd.block3.interfaces.IAirlineService;
import com.solvd.block3.interfaces.IAirportService;
import com.solvd.block3.mappers.AirlineMapper;
import com.solvd.block3.mappers.AirportMapper;
import com.solvd.block3.models.Airline;
import com.solvd.block3.models.Airport;
import com.solvd.block3.utilities.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class AirlineServiceMyBatis implements IAirlineService {
    private AirlineMapper airlineMapper;
    @Override
    public Airline getAirline(int id) {
        try (SqlSession session = SessionUtil.openSession()) {
            airlineMapper = session.getMapper(AirlineMapper.class);
            Airline airline = airlineMapper.selectAirlineById(id);
            return airline;
        }
    }

    @Override
    public Airline getAirlineByName(String name) {
        try (SqlSession session = SessionUtil.openSession()) {
            airlineMapper = session.getMapper(AirlineMapper.class);
            Airline airline = airlineMapper.selectAirlineByName(name);
            return airline;
        }
    }

    @Override
    public ArrayList<Airline> getAirlines() {
        try (SqlSession session = SessionUtil.openSession()) {
            airlineMapper = session.getMapper(AirlineMapper.class);
            ArrayList<Airline> airlines = airlineMapper.selectAirlines();
            return airlines;
        }
    }

    @Override
    public void insertAirline(Airline airline) {
        try (SqlSession session = SessionUtil.openSession()) {
            airlineMapper = session.getMapper(AirlineMapper.class);
            airlineMapper.insertAirline(airline);
            session.commit();
        }
    }

    @Override
    public void updateAirline(Airline airline) {
        try (SqlSession session = SessionUtil.openSession()) {
            airlineMapper = session.getMapper(AirlineMapper.class);
            airlineMapper.updateAirline(airline);
            session.commit();
        }
    }

    @Override
    public void deleteAirline(Airline airline) {
        try (SqlSession session = SessionUtil.openSession()) {
            airlineMapper = session.getMapper(AirlineMapper.class);
            airlineMapper.deleteAirline(airline);
            session.commit();
        }
    }
}

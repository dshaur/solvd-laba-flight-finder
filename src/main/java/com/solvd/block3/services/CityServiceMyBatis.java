package com.solvd.block3.services;

import com.solvd.block3.interfaces.ICityService;
import com.solvd.block3.interfaces.ICountryService;
import com.solvd.block3.mappers.CityMapper;
import com.solvd.block3.mappers.CountryMapper;
import com.solvd.block3.models.City;
import com.solvd.block3.models.Country;
import com.solvd.block3.utilities.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class CityServiceMyBatis implements ICityService {
    private CityMapper cityMapper;

    public CityServiceMyBatis(){}

    @Override
    public City getCity(int id) {
        try (SqlSession session = SessionUtil.openSession()) {
            cityMapper = session.getMapper(CityMapper.class);
            City city = cityMapper.selectCityById(id);
            return city;
        }
    }

    @Override
    public City getCityByName(String name) {
        try (SqlSession session = SessionUtil.openSession()) {
            cityMapper = session.getMapper(CityMapper.class);
            City city = cityMapper.selectCityByName(name);
            return city;
        }
    }

    @Override
    public ArrayList<City> getCities() {
        try (SqlSession session = SessionUtil.openSession()) {
            cityMapper = session.getMapper(CityMapper.class);
            ArrayList<City> cities = cityMapper.selectCities();
            return cities;
        }
    }

    @Override
    public void insertCity(City city) {
        try (SqlSession session = SessionUtil.openSession()) {
            cityMapper = session.getMapper(CityMapper.class);
            cityMapper.insertCity(city);
            session.commit();
        }
    }

    @Override
    public void updateCity(City city) {
        try (SqlSession session = SessionUtil.openSession()) {
            cityMapper = session.getMapper(CityMapper.class);
            cityMapper.updateCity(city);
            session.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        try (SqlSession session = SessionUtil.openSession()) {
            cityMapper = session.getMapper(CityMapper.class);
            cityMapper.deleteCity(city);
            session.commit();
        }
    }
}

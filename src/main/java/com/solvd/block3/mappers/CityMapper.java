package com.solvd.block3.mappers;

import java.util.ArrayList;

import com.solvd.block3.models.City;

public interface CityMapper {
	City selectCityById(int id);

	City selectCityByName(String name);

	ArrayList<City> selectCities();

	void insertCity(City city);

	void updateCity(City city);

	void deleteCity(City city);
}

package com.solvd.block3.interfaces;

import java.util.ArrayList;

import com.solvd.block3.models.City;

public interface ICityService {
	City getCity(int id);

	City getCityByName(String name);

	ArrayList<City> getCities();

	void insertCity(City city);

	void updateCity(City city);

	void deleteCity(City city);
}

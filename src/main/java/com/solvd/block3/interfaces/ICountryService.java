package com.solvd.block3.interfaces;

import java.util.ArrayList;

import com.solvd.block3.models.Country;

public interface ICountryService {
	Country getCountry(int id);

	Country getCountryByName(String name);

	ArrayList<Country> getCountries();

	void insertCountry(Country country);

	void updateCountry(Country country);

	void deleteCountry(Country country);
}

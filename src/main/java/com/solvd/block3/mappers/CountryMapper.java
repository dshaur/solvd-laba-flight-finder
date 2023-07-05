package com.solvd.block3.mappers;

import java.util.ArrayList;

import com.solvd.block3.models.Country;

public interface CountryMapper {
	Country selectCountryById(int id);

	Country selectCountryByName(String name);

	ArrayList<Country> selectCountries();

	void insertCountry(Country country);

	void updateCountry(Country country);

	void deleteCountry(Country country);
}

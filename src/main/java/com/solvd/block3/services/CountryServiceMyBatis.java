package com.solvd.block3.services;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.solvd.block3.interfaces.ICountryService;
import com.solvd.block3.mappers.CountryMapper;
import com.solvd.block3.models.Country;
import com.solvd.block3.utilities.SessionUtil;

public class CountryServiceMyBatis implements ICountryService {
	private CountryMapper countryMapper;

	CountryServiceMyBatis() {
	}

	@Override
	public Country getCountry(int id) {
		try (SqlSession session = SessionUtil.openSession()) {
			countryMapper = session.getMapper(CountryMapper.class);
			return countryMapper.selectCountryById(id);
		}
	}

	@Override
	public Country getCountryByName(String name) {
		try (SqlSession session = SessionUtil.openSession()) {
			countryMapper = session.getMapper(CountryMapper.class);
			return countryMapper.selectCountryByName(name);
		}
	}

	@Override
	public ArrayList<Country> getCountries() {
		try (SqlSession session = SessionUtil.openSession()) {
			countryMapper = session.getMapper(CountryMapper.class);
			return countryMapper.selectCountries();
		}
	}

	@Override
	public void insertCountry(Country country) {
		try (SqlSession session = SessionUtil.openSession()) {
			countryMapper = session.getMapper(CountryMapper.class);
			countryMapper.insertCountry(country);
			session.commit();
		}
	}

	@Override
	public void updateCountry(Country country) {
		try (SqlSession session = SessionUtil.openSession()) {
			countryMapper = session.getMapper(CountryMapper.class);
			countryMapper.updateCountry(country);
			session.commit();
		}
	}

	@Override
	public void deleteCountry(Country country) {
		try (SqlSession session = SessionUtil.openSession()) {
			countryMapper = session.getMapper(CountryMapper.class);
			countryMapper.deleteCountry(country);
			session.commit();
		}
	}
}

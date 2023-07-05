package com.solvd.block3.services;

import com.solvd.block3.models.*;

import java.util.ArrayList;

public class SomeClass {
	public static void main(String[] args) {
		CountryServiceMyBatis cs = new CountryServiceMyBatis();
		ArrayList<Country> c = cs.getCountries();
		System.out.println(c);

		CityServiceMyBatis ci = new CityServiceMyBatis();
		City city = ci.getCity(4);
		System.out.println(city);

		AirportServiceMyBatis as = new AirportServiceMyBatis();
		Airport airport = as.getAirport(4);
		System.out.println(airport);

		AirlineServiceMyBatis asl = new AirlineServiceMyBatis();
		Airline airline = asl.getAirline(2);
		System.out.println(airline);

		FlightServiceMyBatis fs = new FlightServiceMyBatis();
		ArrayList<Flight> flights = fs.getFlightByAirline(1);
		System.out.println(flights);
	}
}

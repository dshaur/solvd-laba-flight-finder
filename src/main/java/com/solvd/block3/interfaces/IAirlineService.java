package com.solvd.block3.interfaces;

import java.util.ArrayList;

import com.solvd.block3.models.Airline;

public interface IAirlineService {
	Airline getAirline(int id);

	Airline getAirlineByName(String name);

	ArrayList<Airline> getAirlines();

	void insertAirline(Airline airline);

	void updateAirline(Airline airline);

	void deleteAirline(Airline airline);
}

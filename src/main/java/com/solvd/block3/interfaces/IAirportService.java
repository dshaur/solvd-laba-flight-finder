package com.solvd.block3.interfaces;

import java.util.ArrayList;

import com.solvd.block3.models.Airport;

public interface IAirportService {
	Airport getAirport(int id);

	Airport getAirportByName(String name);

	ArrayList<Airport> getAirports();

	void insertAirport(Airport airport);

	void updateAirport(Airport airport);

	void deleteAirport(Airport airport);
}

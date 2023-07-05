package com.solvd.block3.mappers;

import java.util.ArrayList;

import com.solvd.block3.models.Airport;

public interface AirportMapper {
	Airport selectAirportById(int id);

	Airport selectAirportByName(String name);

	ArrayList<Airport> selectAirports();

	void insertAirport(Airport airport);

	void updateAirport(Airport airport);

	void deleteAirport(Airport airport);
}

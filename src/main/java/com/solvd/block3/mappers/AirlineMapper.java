package com.solvd.block3.mappers;

import java.util.ArrayList;

import com.solvd.block3.models.Airline;

public interface AirlineMapper {
	Airline selectAirlineById(int id);

	Airline selectAirlineByName(String name);

	ArrayList<Airline> selectAirlines();

	void insertAirline(Airline airline);

	void updateAirline(Airline airline);

	void deleteAirline(Airline airline);
}

package com.solvd.block3.business_logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.block3.json.JsonMaker;
import com.solvd.block3.models.*;
import com.solvd.block3.services.AirportServiceMyBatis;
import com.solvd.block3.ui.UiUtils;
import com.solvd.block3.xml.XmlMaker;

public class Main 
{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String XML_PATH = "src/main/resources/Flights.xml";
    private static final String JSON_PATH = "src/main/resources/Flights.json";
    private static final AirportServiceMyBatis AIRPORT_SERVICE = new AirportServiceMyBatis();
    
    public static void main(String[] args) 
    {
        LOGGER.info("Welcome to the flight finder. Please input an origin city.");
        City origin = UiUtils.makeCity();

        LOGGER.info("Now input a destination.");
        City destination = UiUtils.makeCity();

        Airport oriTest = AIRPORT_SERVICE.getAirportByCity(origin);
        LOGGER.info(oriTest);
    }
}

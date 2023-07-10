package com.solvd.block3.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.block3.json.JsonMaker;
import com.solvd.block3.models.Airport;
import com.solvd.block3.models.City;
import com.solvd.block3.models.Flight;
import com.solvd.block3.services.AirportServiceMyBatis;
import com.solvd.block3.services.CityServiceMyBatis;
import com.solvd.block3.services.FlightServiceMyBatis;
import com.solvd.block3.xml.XmlMaker;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UiUtils 
{    
    private static final String XML_PATH = "src/main/resources/Flights.xml";
    private static final String JSON_PATH = "src/main/resources/Flights.json";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger(UiUtils.class);
    private static final Map<String, String> CITY_MAP = createCityMap();
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final CityServiceMyBatis CITY_SERVICE = new CityServiceMyBatis();
    private static final AirportServiceMyBatis AIRPORT_SERVICE = new AirportServiceMyBatis();
    private static final FlightServiceMyBatis FLIGHT_SERVICE = new FlightServiceMyBatis();

    private static Map<String, String> createCityMap() {
        Map<String, String> cityMap = new LinkedHashMap<>();
        cityMap.put("1", "Seoul");
        cityMap.put("2", "Denver");
        cityMap.put("3", "London");
        cityMap.put("4", "Dubai");
        cityMap.put("5", "Sydney");
        cityMap.put("6", "Lima");
        cityMap.put("7", "Paris");
        cityMap.put("8", "Berlin");
        cityMap.put("9", "Beijing");
        cityMap.put("10", "São Paulo");
        cityMap.put("11", "Toronto");
        cityMap.put("12", "Mumbai");
        cityMap.put("13", "Moscow");
        cityMap.put("14", "Amsterdam");
        cityMap.put("15", "Mexico City");
        cityMap.put("16", "Rome");
        cityMap.put("17", "Madrid");
        cityMap.put("18", "Istanbul");
        cityMap.put("19", "Tokyo");
        cityMap.put("20", "Cape Town");
        return cityMap;
    }

    public static String selectCity() {
        LOGGER.info("Available cities:");
        for (Map.Entry<String, String> entry : CITY_MAP.entrySet()) {
            LOGGER.info(entry.getKey() + ": " + entry.getValue());
        }

        String input = SCANNER.nextLine().trim();
        String cityId = null;
        if (NUMBER_PATTERN.matcher(input).matches()) {
            cityId = input;
        } else {
            for (Map.Entry<String, String> entry : CITY_MAP.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(input)) {
                    cityId = entry.getKey();
                    break;
                }
            }
        }

        while (cityId == null || !validateCity(cityId)) {
            LOGGER.error("Invalid input. Please enter a valid city ID or name.");
            input = SCANNER.nextLine().trim();
            if (NUMBER_PATTERN.matcher(input).matches()) {
                cityId = input;
            } else {
                for (Map.Entry<String, String> entry : CITY_MAP.entrySet()) {
                    if (entry.getValue().equalsIgnoreCase(input)) {
                        cityId = entry.getKey();
                        break;
                    }
                }
            }
        }

        return CITY_MAP.get(cityId);
    }

    public static boolean validateCity(String cityId) {
        return CITY_MAP.containsKey(cityId);
    }


    public static String getMode()
    {
        LOGGER.info("Enter 'c' for cheapest route, 's' for shortest route.");
        String mode = SCANNER.nextLine();

        while (true)
        {
            if (mode.equalsIgnoreCase("c") || mode.equalsIgnoreCase("s"))
            {
                return mode;
            }

            else
            {
                LOGGER.error("Invalid input.");
                LOGGER.info("Enter 'c' for cheapest route, 's' for shortest route.");
                mode = SCANNER.nextLine();
            }
        }
    }
}

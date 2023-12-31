package com.solvd.block3.ui;

import com.solvd.block3.models.City;
import com.solvd.block3.models.Flight;
import com.solvd.block3.services.AirportServiceMyBatis;
import com.solvd.block3.services.CityServiceMyBatis;
import com.solvd.block3.services.FlightServiceMyBatis;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;

public class UiUtils {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger(UiUtils.class);
    private static final Map<String, String> CITY_MAP = createCityMap();
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final CityServiceMyBatis CITY_SERVICE = new CityServiceMyBatis();
    private static final AirportServiceMyBatis AIRPORT_SERVICE = new AirportServiceMyBatis();
    private static final FlightServiceMyBatis FLIGHT_SERVICE = new FlightServiceMyBatis();

    private static final DecimalFormat df = new DecimalFormat("0.00"); // Round to 2 decimal places for display

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

    public static City selectCity() {
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

        String cityName = CITY_MAP.get(cityId);
        return CITY_SERVICE.getCityByName(cityName);
    }

    public static boolean validateCity(String cityId) {
        return CITY_MAP.containsKey(cityId);
    }


    public static String getMode() {
        LOGGER.info("Enter 's' to get the shortest route or 'c' for the cheapest");
        String mode = SCANNER.nextLine().trim();

        // Use regex to match variations of input
        if (Pattern.matches("(?i)^s(hort(est)?)?$", mode)) {
            return "s";
        } else if (Pattern.matches("(?i)^c(heap(est)?)?$", mode)) {
            return "c";
        } else {
            LOGGER.info("Invalid input. Try again.");
            return getMode(); // Recursive call to re-prompt for valid input
        }
    }


    public static List<Flight> findBestFlights(City source, City dest, boolean useDistance) {
        int sourceApId = AIRPORT_SERVICE.getAirportByCity(source).getAirportId();
        int destApId = AIRPORT_SERVICE.getAirportByCity(dest).getAirportId();

        List<Integer> airportIds = FLIGHT_SERVICE.findShortestPath(sourceApId, destApId, useDistance);

        return findFlightsByAirportIds(airportIds);
    }

    private static List<Flight> findFlightsByAirportIds(List<Integer> airportIds) {
        List<Flight> ret = new ArrayList<Flight>();

        for (int i = 0; i < airportIds.size() - 1; i++) {
            ArrayList<Flight> sourceFlights = FLIGHT_SERVICE.getFlightBySourceAirport(airportIds.get(i));
            for (Flight flight : sourceFlights) {
                if (flight.getDestinationAirport().getAirportId() == airportIds.get(i + 1)) {
                    ret.add(flight);
                }
            }
        }

        return ret;
    }

    public static void printFlightDirections(List<Flight> flights) {

        double totalPrice = 0.0; // total price

        LOGGER.info("Directions:");
        for (Flight flight : flights) {
            LOGGER.info(
                    "Take flight " +
                            flight.getAirline().getName() + " " +
                            flight.getFlightId() +
                            " from " +
                            flight.getSourceAirport().getName() + " " + "(" + flight.getSourceAirport().getCity().getName() + ")" +
                            " to " +
                            flight.getDestinationAirport().getName() + " " + "(" + flight.getDestinationAirport().getCity().getName() + ")");

            totalPrice += flight.getPrice();

        }

        LOGGER.info("Arrived at final destination.");
        LOGGER.info("Total price: $" + df.format(totalPrice));
    }

}

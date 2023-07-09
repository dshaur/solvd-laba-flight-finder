package com.solvd.block3.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UiUtils {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger(UiUtils.class);
    private static final Map<String, String> cityMap = createCityMap();

    private static Map<String, String> createCityMap() {
        Map<String, String> cityMap = new HashMap<>();
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
        for (Map.Entry<String, String> entry : cityMap.entrySet()) {
            LOGGER.info(entry.getKey() + ": " + entry.getValue());
        }

        String ret = SCANNER.nextLine();
        while (!validateCity(ret)) {
            LOGGER.error("City doesn't exist in the database. Please try again.");
            ret = SCANNER.nextLine();
        }

        return cityMap.get(ret);
    }

    public static boolean validateCity(String cityId) {
        return cityMap.containsKey(cityId);
    }
}

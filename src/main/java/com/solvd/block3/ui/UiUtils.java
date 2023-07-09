package com.solvd.block3.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UiUtils {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger(UiUtils.class);
    private static final Map<String, String> cityMap = createCityMap();
    private static final Pattern numberPattern = Pattern.compile("\\d+");

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

        String input = SCANNER.nextLine().trim();
        String cityId = null;
        if (numberPattern.matcher(input).matches()) {
            cityId = input;
        } else {
            for (Map.Entry<String, String> entry : cityMap.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(input)) {
                    cityId = entry.getKey();
                    break;
                }
            }
        }

        while (cityId == null || !validateCity(cityId)) {
            LOGGER.error("Invalid input. Please enter a valid option or the city name.");
            input = SCANNER.nextLine().trim();
            if (numberPattern.matcher(input).matches()) {
                cityId = input;
            } else {
                for (Map.Entry<String, String> entry : cityMap.entrySet()) {
                    if (entry.getValue().equalsIgnoreCase(input)) {
                        cityId = entry.getKey();
                        break;
                    }
                }
            }
        }

        return cityMap.get(cityId);
    }

    public static boolean validateCity(String cityId) {
        return cityMap.containsKey(cityId);
    }
}

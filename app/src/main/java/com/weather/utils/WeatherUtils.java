package com.weather.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class WeatherUtils {

    public final static String WEATHER_API_KEY = "90280acba28350cb";
    public final static String FARENHEIT_SYMBOL = " \u2109";
    public final static String DELIMETER = ", ";
    public final static String FORWARD_SLASH = "/";
    public final static String JSON_EXT = ".json";
    public final static String EMPTY = "";
    public final static String SPACE = " ";
    public final static String UNDERSCORE = "_";
    public final static String EMPTY_SPACES = "\\s";

    /***
     * This method will format the location string by splitting it and reversing the positions of CityName and StateName and appending .json extension to it.
     * @param locationName name of the location which was selected.
     * @return formatted string with .json appended to it.
     */
    public static String formatLocation(String locationName) {
        String formattedString = EMPTY;
        try {
            String[] locationNames = locationName.split(DELIMETER);
             formattedString = ((getStateCode(locationNames[1])) + FORWARD_SLASH + addUnderScore(locationNames[0]) + JSON_EXT);
        }
        catch (NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }
        catch (IndexOutOfBoundsException indexOutofBoundException){
            indexOutofBoundException.printStackTrace();
        }
        return formattedString;
    }

    /***
     * This method with remove all spaces in between the String and add empty String to it.
     * @param stringToBeTrimmed String which has empty spaces
     * @return String without any empty spaces
     */
    public static String trimString(String stringToBeTrimmed) {
        stringToBeTrimmed = stringToBeTrimmed.replaceAll(EMPTY_SPACES, EMPTY);
        return stringToBeTrimmed;
    }

    /***
     * This method add underscore to a string if a space exists to a string.
     * @param stringToBeFormatted String with a empty space
     * @return String with a under_score replacing a empty space.
     */
    public static String addUnderScore(String stringToBeFormatted) {
        stringToBeFormatted = stringToBeFormatted.replaceAll(SPACE, UNDERSCORE);
        return stringToBeFormatted;
    }

    /***
     * This method returns a state code taking a complete name as a input.
     * @param stateName Complete StateNname
     * @return State code with which StateName is mapped.
     */
    private static  String getStateCode(String stateName) {
        Map<String, String> states = new HashMap<String, String>();
        states.put("Alabama", "AL");
        states.put("Alaska", "AK");
        states.put("Alberta", "AB");
        states.put("American Samoa", "AS");
        states.put("Arizona", "AZ");
        states.put("Arkansas", "AR");
        states.put("Armed Forces (AE)", "AE");
        states.put("Armed Forces Americas", "AA");
        states.put("Armed Forces Pacific", "AP");
        states.put("British Columbia", "BC");
        states.put("California", "CA");
        states.put("Colorado", "CO");
        states.put("Connecticut", "CT");
        states.put("Delaware", "DE");
        states.put("District Of Columbia", "DC");
        states.put("Florida", "FL");
        states.put("Georgia", "GA");
        states.put("Guam", "GU");
        states.put("Hawaii", "HI");
        states.put("Idaho", "ID");
        states.put("Illinois", "IL");
        states.put("Indiana", "IN");
        states.put("Iowa", "IA");
        states.put("Kansas", "KS");
        states.put("Kentucky", "KY");
        states.put("Louisiana", "LA");
        states.put("Maine", "ME");
        states.put("Manitoba", "MB");
        states.put("Maryland", "MD");
        states.put("Massachusetts", "MA");
        states.put("Michigan", "MI");
        states.put("Minnesota", "MN");
        states.put("Mississippi", "MS");
        states.put("Missouri", "MO");
        states.put("Montana", "MT");
        states.put("Nebraska", "NE");
        states.put("Nevada", "NV");
        states.put("New Brunswick", "NB");
        states.put("New Hampshire", "NH");
        states.put("New Jersey", "NJ");
        states.put("New Mexico", "NM");
        states.put("New York", "NY");
        states.put("Newfoundland", "NF");
        states.put("North Carolina", "NC");
        states.put("North Dakota", "ND");
        states.put("Northwest Territories", "NT");
        states.put("Nova Scotia", "NS");
        states.put("Nunavut", "NU");
        states.put("Ohio", "OH");
        states.put("Oklahoma", "OK");
        states.put("Ontario", "ON");
        states.put("Oregon", "OR");
        states.put("Pennsylvania", "PA");
        states.put("Prince Edward Island", "PE");
        states.put("Puerto Rico", "PR");
        states.put("Quebec", "PQ");
        states.put("Rhode Island", "RI");
        states.put("Saskatchewan", "SK");
        states.put("South Carolina", "SC");
        states.put("South Dakota", "SD");
        states.put("Tennessee", "TN");
        states.put("Texas", "TX");
        states.put("Utah", "UT");
        states.put("Vermont", "VT");
        states.put("Virgin Islands", "VI");
        states.put("Virginia", "VA");
        states.put("Washington", "WA");
        states.put("West Virginia", "WV");
        states.put("Wisconsin", "WI");
        states.put("Wyoming", "WY");
        states.put("Yukon Territory", "YT");

        return states.get(stateName);
    }

}

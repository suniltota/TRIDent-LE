package com.actualize.mortgage.utils;

/**
 * This class is perform various operations such as conversions etc.,
 * @author sboragala
 *
 */
public class Convertor {
	
	/**
	 * converts a boolean to string
	 * @param status
	 * @return string
	 */
	public static String booleanToString(boolean status)
	{
		if(status)
			return "true";
		return "false";
	}
	
	/**
	 * converts a String to boolean
	 * @param status
	 * @return
	 */
	public static boolean stringToBoolean(String status)
	{
		if(status.equalsIgnoreCase("YES"))
			return true;
		return false;
	}
	
}

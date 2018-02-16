/**********************************************************************************************************************************
* @author : Lakshmi Ay 
**********************************************************************************************************************************************************************************/

package com.newtour.qa.util;

import java.util.ArrayList;

import com.newtour.qa.testbase.NewToursBase;

public class TestUtil extends NewToursBase {

	/**
	 * Declare some common parameters for scripts we can change them to adapt
	 * your environment
	 */
	public static final String BROWSER_CHROME = "chrome";
	public static final String BROWSER_FIREFOX = "firefox";
	public static final String BROWSER = BROWSER_CHROME;
	//public static final String BROWSER = BROWSER_FIREFOX;
	public static final String SERVER_URL = "http://newtours.demoaut.com/index.php";

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	static ReadExcel reader;

	public static ArrayList<Object[]> getDataFromExcel() {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {
			
			reader = new ReadExcel(loginValidTestDataFilePath);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int rowNum = 2; rowNum <= 2 ; rowNum++) {

			String userName = reader.getCellData("LoginTestData", "Username", rowNum);
			String password = reader.getCellData("LoginTestData", "Password", rowNum);

			System.out.println(userName);
			System.out.println(password);
			
			Object ob[] = { userName, password };
			myData.add(ob);

		}
		return myData;

	}

	
	public static ArrayList<Object[]> getInvalidCredentials () {
		
		ArrayList<Object[]> invalidData = new ArrayList<Object[]>();

		try {
			reader = new ReadExcel(loginInValidTestDataFilePath);
				
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int rowNum = 3; rowNum <= 3 ; rowNum++) {

			String userName = reader.getCellData("LoginTestData", "Username", rowNum);
			String password = reader.getCellData("LoginTestData", "Password", rowNum);

			Object ob[] = { userName, password };
			invalidData.add(ob);

		}
		return invalidData ;

	}
	
	
	
	
public static ArrayList<Object[]> getJourneyDataFromExcel() {
		
		ArrayList<Object[]> journeyData = new ArrayList<Object[]>();

		try {
			reader = new ReadExcel(journeyTestDataFilePath);
					
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int rowNum = 2; rowNum <= 2 ; rowNum++) {

			String pcount = reader.getCellData("JourneyData", "Passengercount", rowNum);
			String dport = reader.getCellData("JourneyData", "DepartingPort", rowNum);
			String dmonth = reader.getCellData("JourneyData", "DepartingMonth", rowNum);
			String dday = reader.getCellData("JourneyData", "DepartingDay", rowNum);
			String destport = reader.getCellData("JourneyData", "DestinationPort", rowNum);
			String returnmonth = reader.getCellData("JourneyData", "ReturningMonth", rowNum);
			String returnday = reader.getCellData("JourneyData", "ReturningDay", rowNum);
			String servclass = reader.getCellData("JourneyData", "ServiceClass", rowNum);
			String airlinepref = reader.getCellData("JourneyData", "AirlinePref", rowNum);
					
			
			
			Object ob[] = {pcount,dport,dmonth,dday,destport,returnmonth,returnday,servclass,airlinepref};
			journeyData.add(ob);

		}
		return journeyData ;
		

	}


public static ArrayList<Object[]> getRoundTripJourneyDataFromExcel() {
	
	ArrayList<Object[]> journeyData = new ArrayList<Object[]>();

	try {
		reader = new ReadExcel(journeyTestDataFilePath);
				
	} catch (Exception e) {
		e.printStackTrace();
	}

	for (int rowNum = 3; rowNum <= 3 ; rowNum++) {

		String pcount = reader.getCellData("JourneyData", "Passengercount", rowNum);
		String dport = reader.getCellData("JourneyData", "DepartingPort", rowNum);
		String dmonth = reader.getCellData("JourneyData", "DepartingMonth", rowNum);
		String dday = reader.getCellData("JourneyData", "DepartingDay", rowNum);
		String destport = reader.getCellData("JourneyData", "DestinationPort", rowNum);
		String returnmonth = reader.getCellData("JourneyData", "ReturningMonth", rowNum);
		String returnday = reader.getCellData("JourneyData", "ReturningDay", rowNum);
		String servclass = reader.getCellData("JourneyData", "ServiceClass", rowNum);
		String airlinepref = reader.getCellData("JourneyData", "AirlinePref", rowNum);
				
		
		
		Object ob[] = {pcount,dport,dmonth,dday,destport,returnmonth,returnday,servclass,airlinepref};
		journeyData.add(ob);

	}
	return journeyData ;
	

}



}

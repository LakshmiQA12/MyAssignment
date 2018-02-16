/*******************************************************************************************************************************************************************************
 * Test Scenario : Verify Flight Search for Round Trip 
 * Test Steps : 1)Launch URL 
                2)Verify login by entering valid Userdetails and password on the home page .
                3)Click Flights
                4)Select all the options required for searching flights for round trip .
                5)Click continue
                6)Verify whether flights details are being displayed  

   * @author : Lakshmi Ay 
**********************************************************************************************************************************************************************************/

package com.newtour.flightfinderfunctional.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newtour.qa.helper.WaitHelper;
import com.newtour.qa.testbase.NewToursBase;
import com.newtour.qa.util.CommonUtility;
import com.newtour.qa.util.TestUtil;

public class TC_KF_FF_02_VerifyRoundTripFlightSearchTest extends NewToursBase {

	String fileName = this.getClass().toString();

	@Test(priority = 0)
	public void verifyLaunchURLTest() throws Exception {

		loginpage.performLogin();

	}

	@Test(dataProvider = "getTestData", priority = 1, dependsOnMethods = { "verifyLaunchURLTest" })
	public void verifyCredentialsTest(String userName, String password) throws Exception {

		loginpage.enterCredentials(userName, password);

	}

	@Test(dataProvider = "getRoundTripJourneyTestData", priority = 2, dependsOnMethods = { "verifyCredentialsTest" })
	public void verifyRoundTripFlightSearchTest(String pCount, String dPort, String dMonth, String dDay, String aPort,
			String rMonth, String rDay, String servClass, String airlinePref) throws Exception {

		flightspage.searchRoundWayFlight(pCount, dPort, dMonth, dDay, aPort, rMonth, rDay, servClass, airlinePref);

	}

	@Test(priority = 3, dependsOnMethods = { "verifyRoundTripFlightSearchTest" })
	public void verifyFlightSearch() {
		boolean searchFlag = flightspage.isFlightSearchSuccessful();
		Assert.assertTrue(searchFlag);

	}

	@Test(priority = 4, dependsOnMethods = { "verifyFlightSearch" })
	public void verifyFlightDetailsList() {
		flightspage.verifyFlightDetailsList();

	}

	@Test(priority = 5, dependsOnMethods = { "verifyFlightDetailsList" })
	public void verifyReserveFlights() {
		boolean reserveFlag = flightspage.reserveFlights();
		Assert.assertTrue(reserveFlag);

	}
	
	@Test(priority = 6, dependsOnMethods = { "verifyReserveFlights" })
	public void verifySignOffTest() {

		signonpage.clickSignOff();

	}
	

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}

	@DataProvider
	public Iterator<Object[]> getRoundTripJourneyTestData() {
		ArrayList<Object[]> journeyTestData = TestUtil.getRoundTripJourneyDataFromExcel();
		return journeyTestData.iterator();
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {

			System.out.println(testResult.getStatus());
			methodName = testResult.getName().toString().trim();
			CommonUtility.takeFailedScreenshot(getWebDriver(), fileName);
		}
	}

	@AfterClass
	public void tearDown() throws IOException {

		CommonUtility.takeScreenshot(getWebDriver(), fileName);
		getWebDriver().quit();

	}

}

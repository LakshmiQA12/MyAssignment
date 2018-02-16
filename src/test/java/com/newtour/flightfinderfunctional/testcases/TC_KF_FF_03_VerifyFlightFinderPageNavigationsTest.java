/*******************************************************************************************************************************************************************************
 * Test Scenario : Flight Search Page- Navigation Test 
 * Test Steps :  1)Launch URL 
                 2)Verify login by entering valid username and /password on the home page .
                 3)Click Flights
                 4)Select all the options required for searching flights for one way trip 
                 5)Verify flight search is successful and forwarded to book flight page
                 6)Now navigate back
                 7)Verify Whether it's been navigated to flight search home page 
                 8)Now Navigate forward.
                 9)Verify Whether its been navigated forward to book a flight page
   * @author : Lakshmi Ay 
**********************************************************************************************************************************************************************************/

package com.newtour.flightfinderfunctional.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newtour.qa.testbase.NewToursBase;
import com.newtour.qa.util.CommonUtility;
import com.newtour.qa.util.TestUtil;

public class TC_KF_FF_03_VerifyFlightFinderPageNavigationsTest extends NewToursBase {

	@BeforeClass
	public void setUp() {

	}

	String fileName = this.getClass().toString();

	@Test(priority = 0)
	public void verifyLaunchURLTest() throws Exception {

		loginpage.performLogin();

	}

	@Test(dataProvider = "getTestData", priority = 1, dependsOnMethods = { "verifyLaunchURLTest" })
	public void verifyCredentialsTest(String userName, String password) throws Exception {

		loginpage.enterCredentials(userName, password);

	}

	@Test(dataProvider = "getJourneyTestData", priority = 2, dependsOnMethods = { "verifyCredentialsTest" })
	public void verifyOneWayFlightSearchTest(String pCount, String dPort, String dMonth, String dDay, String aPort,
			String aMonth, String aDay, String servClass, String airlinePref) throws Exception {

		flightspage.searchOneWayFlight(pCount, dPort, dMonth, dDay, aPort, aMonth, aDay, servClass, airlinePref);

	}

	@Test(priority = 3, dependsOnMethods = { "verifyOneWayFlightSearchTest" })
	public void verifyFlightSearch() {
		boolean searchFlag = flightspage.isFlightSearchSuccessful();
		Assert.assertTrue(searchFlag);

	}

	@Test(priority = 4, dependsOnMethods = { "verifyFlightSearch" })
	public void verifyNavigateBack() {
		boolean navigateBackFlg = flightspage.verifyNavigateBack();
		Assert.assertTrue(navigateBackFlg);

	}

	@Test(priority = 5, dependsOnMethods = { "verifyNavigateBack" })
	public void verifyNavigateForward() {
		boolean navigateFwdFlg = flightspage.verifyNavigateForward();
		Assert.assertTrue(navigateFwdFlg);

	}
	
	@Test(priority = 6, dependsOnMethods = { "verifyNavigateForward" })
	public void verifySignOffTest() {

		signonpage.clickSignOff();

	}
	
	

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}

	@DataProvider
	public Iterator<Object[]> getJourneyTestData() {
		ArrayList<Object[]> journeyTestData = TestUtil.getJourneyDataFromExcel();
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
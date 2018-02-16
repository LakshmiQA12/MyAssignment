/***********************************************************************************************************************************
* @author : Lakshmi Ay 
***********************************************************************************************************************************************************************************/

package com.newtour.qa.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newtour.qa.helper.JavascriptHelper;
import com.newtour.qa.helper.WaitHelper;
import com.newtour.qa.helper.XpathHelper;
import com.newtour.qa.testbase.NewToursBase;
import com.newtour.qa.util.TestUtil;

public class FlightsPage extends NewToursBase

{

	@FindBy(how = How.CSS, using = "input[value='roundtrip']")
	public WebElement roundTrip;

	@FindBy(how = How.CSS, using = "input[value='oneway']")
	public WebElement oneWay;

	@FindBy(how = How.NAME, using = "passCount")
	public WebElement passengercount;

	@FindBy(how = How.NAME, using = "fromPort")
	public WebElement departingPort;

	@FindBy(how = How.NAME, using = "fromMonth")
	public WebElement departingMonth;

	@FindBy(how = How.NAME, using = "fromDay")
	public WebElement departingDay;

	@FindBy(how = How.NAME, using = "toPort")
	public WebElement destinationPort;

	@FindBy(how = How.NAME, using = "toMonth")
	public WebElement arrivalMonth;

	@FindBy(how = How.NAME, using = "toDay")
	public WebElement arrivalDate;

	@FindBy(how = How.CSS, using = "input[value='Coach']")
	public WebElement economyClass;

	@FindBy(how = How.CSS, using = "input[value='Business']")
	public WebElement businessClass;

	@FindBy(how = How.CSS, using = "input[value='First']")
	public WebElement firstClass;

	@FindBy(how = How.NAME, using = "airline")
	public WebElement airline;

	@FindBy(how = How.NAME, using = "findFlights")
	public WebElement continueElt;

	@FindBy(how = How.NAME, using = "reserveFlights")
	public WebElement reserveFlight;

	public FlightsPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyFlightDetailsList() {

		List<WebElement> flightsList = driver.findElements(By.name("outFlight"));
		int listSize = flightsList.size();

		for (int i = 0; i < listSize; i++) {

			String flightName = flightsList.get(i).getAttribute("value");
			System.out.println(flightName);

			if (flightName.equalsIgnoreCase("Unified Airlines$363$281$11:24")) {

				flightsList.get(i).click();
				break;

			}

		}

		WebElement reserveFlightElement = WaitHelper.clickWhenReady(reserveFlight, 5);
		JavascriptHelper.flash(reserveFlightElement);
		reserveFlightElement.click();
		
		WaitHelper.simpleWait(2);

	}

	public void searchOneWayFlight(String pCount, String dPort, String dMonth, String dDay, String aPort, String rMonth,
			String rDay, String servClass, String airlinePref) throws Exception {

		WebElement oneWayElement = WaitHelper.waitUntilVisible(oneWay, 5);
		JavascriptHelper.flash(oneWayElement);
		if (oneWayElement.isSelected()) {
			System.out.println("one way is already selected ");
		} else {
			System.out.println("one way is not selected. ");
			oneWayElement.click();
		}

		System.out.println(pCount);
		System.out.println(servClass);
		
		WebElement passElement = WaitHelper.waitUntilVisible(passengercount, 5);
		JavascriptHelper.flash(passElement);
		if (passElement != null)

		{
			passElement.sendKeys(pCount);
		}

		WebElement dportElement = WaitHelper.waitUntilVisible(departingPort, 5);
		JavascriptHelper.flash(dportElement);
		dportElement.sendKeys(dPort);

		WebElement dmonthElement = WaitHelper.waitUntilVisible(departingMonth, 5);
		JavascriptHelper.flash(dmonthElement);
		dmonthElement.sendKeys(dMonth);

		WebElement dDayElement = WaitHelper.waitUntilVisible(departingDay, 5);
		JavascriptHelper.flash(dDayElement);
		dDayElement.sendKeys(dDay);

		WebElement arrivalPortElement = WaitHelper.waitUntilVisible(destinationPort, 5);
		JavascriptHelper.flash(arrivalPortElement);
		arrivalPortElement.sendKeys(aPort);

		WebElement returnMonthElement = WaitHelper.waitUntilVisible(arrivalMonth, 5);
		JavascriptHelper.flash(returnMonthElement);
		returnMonthElement.sendKeys(rMonth);

		WebElement returnDateElement = WaitHelper.waitUntilVisible(arrivalDate, 5);
		JavascriptHelper.flash(returnDateElement);
		returnDateElement.sendKeys(rDay);

		WebElement servClassElement = WaitHelper.waitUntilVisible(businessClass, 5);
		JavascriptHelper.flash(servClassElement);
		servClassElement.sendKeys(servClass);

		WebElement airlinePrefElement = WaitHelper.waitUntilVisible(airline, 5);
		JavascriptHelper.flash(airlinePrefElement);
		airlinePrefElement.sendKeys(airlinePref);

		WebElement continueElement = WaitHelper.clickWhenReady(continueElt, 5);
		JavascriptHelper.flash(continueElement);
		continueElement.click();

		WaitHelper.simpleWait(3);

	}

	public void searchRoundWayFlight(String pCount, String dPort, String dMonth, String dDay, String aPort, String rMonth,
			String rDay, String servClass, String airlinePref) throws Exception {

		WebElement roundTripElement = WaitHelper.waitUntilVisible(roundTrip, 5);
		JavascriptHelper.flash(roundTripElement);
		if (roundTripElement.isSelected()) {
			System.out.println("Round Trip is already selected ");
		} else {
			System.out.println("RoundTrip is not selected. ");
			roundTripElement.click();
		}

		System.out.println(pCount);
		System.out.println(servClass);
		WebElement passElement = WaitHelper.waitUntilVisible(passengercount, 5);
		JavascriptHelper.flash(passElement);
		if (passElement != null)

		{
			passElement.sendKeys(pCount);
		}

		WebElement dportElement = WaitHelper.waitUntilVisible(departingPort, 5);
		JavascriptHelper.flash(dportElement);
		dportElement.sendKeys(dPort);

		WebElement dmonthElement = WaitHelper.waitUntilVisible(departingMonth, 5);
		JavascriptHelper.flash(dmonthElement);
		dmonthElement.sendKeys(dMonth);

		WebElement dDayElement = WaitHelper.waitUntilVisible(departingDay, 5);
		JavascriptHelper.flash(dDayElement);
		dDayElement.sendKeys(dDay);

		WebElement arrivalPortElement = WaitHelper.waitUntilVisible(destinationPort, 5);
		JavascriptHelper.flash(arrivalPortElement);
		arrivalPortElement.sendKeys(aPort);

		WebElement returnMonthElement = WaitHelper.waitUntilVisible(arrivalMonth, 5);
		JavascriptHelper.flash(returnMonthElement);
		returnMonthElement.sendKeys(rMonth);

		WebElement returnDateElement = WaitHelper.waitUntilVisible(arrivalDate, 5);
		JavascriptHelper.flash(returnDateElement);
		returnDateElement.sendKeys(rDay);

		WebElement servClassElement = WaitHelper.waitUntilVisible(firstClass, 5);
		JavascriptHelper.flash(servClassElement);
		servClassElement.sendKeys(servClass);

		WebElement airlinePrefElement = WaitHelper.waitUntilVisible(airline, 5);
		JavascriptHelper.flash(airlinePrefElement);
		airlinePrefElement.sendKeys(airlinePref);

		WebElement continueElement = WaitHelper.clickWhenReady(continueElt, 5);
		JavascriptHelper.flash(continueElement);
		continueElement.click();

		WaitHelper.simpleWait(2);

	}
	
	
	public boolean isFlightPageLogoDisplayed() {
		WebElement selectFlightImageFileElement = WaitHelper.waitUntilVisible(
				XpathHelper.findByXPath("//img[contains(@src,'/images/masts/mast_flightfinder.gif')]"), 5);
		JavascriptHelper.flash(selectFlightImageFileElement);

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				selectFlightImageFileElement);

		if (!ImagePresent) {
			log.info("After Signon - Flight Finder Logo Image is not displayed.SignOn is not successful");
			System.out.println("After Signon - Flight Finder Logo Image is not displayed.SignOn is not successful");
			return false;

		} else {
			log.info("After Signon - Flight Finder Logo Image is  displayed.SignOn is successful");
			System.out.println("Select Flight  Logo Image is displayed.SignOn is successful");
			return true;

		}
	}

	public boolean isFlightSearchSuccessful() {
		WebElement selectFlightFileElement = WaitHelper.waitUntilVisible(
				XpathHelper.findByXPath("//img[contains(@src,'/images/masts/mast_selectflight.gif')]"), 5);
		JavascriptHelper.flash(selectFlightFileElement);

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				selectFlightFileElement);

		if (!ImagePresent) {
			log.info("Select Flight  Logo Image is not displayed.Flight Finder is not successful");
			System.out.println("Select Flight  Logo Image is not displayed.Flight Finder is not successful");
			return false;

		} else {
			log.info("Select Flight  Logo Image is displayed.Flight Finder is successful");
			System.out.println("Select Flight  Logo Image is displayed.Flight Finder is successful");
			return true;

		}
	}

	public boolean reserveFlights() {

		WebElement reserveFlightImageFileElement = WaitHelper
				.waitUntilVisible(XpathHelper.findByXPath("//img[contains(@src,'/images/masts/mast_book.gif')]"), 5);
		JavascriptHelper.flash(reserveFlightImageFileElement);

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				reserveFlightImageFileElement);

		if (!ImagePresent) {
			log.info("Book a Flight Screen is not displayed.");
			System.out.println("Book a Flight Screen is not displayed.");
			return false;

		} else {
			log.info("Book a Flight Screen is displayed.");
			System.out.println("Book a Flight Screen is displayed.");
			return true;

		}

	}

	public String validateFlightPageTitle() {
		return driver.getTitle();
	}

	
	public boolean verifyNavigateBack() {
		
		driver.navigate().back();
		
		WaitHelper.simpleWait(2);
		boolean navigateBackFlag = isFlightPageLogoDisplayed();
		return navigateBackFlag ;
		
		
		

	}

	public boolean verifyNavigateForward() {
		
		driver.navigate().forward();
		WaitHelper.simpleWait(2);
		
		boolean navigateFwdFlag = isFlightSearchSuccessful();
		return navigateFwdFlag ;
		
		
		

	}

}

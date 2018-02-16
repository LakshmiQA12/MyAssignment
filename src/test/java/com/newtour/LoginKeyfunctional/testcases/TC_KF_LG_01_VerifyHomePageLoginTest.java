/*******************************************************************************************************************************************************************************
 * Test Scenario : Login with Valid Username/password on Home Page 
 * Test Steps :  1)Launch URL 
                 2)Verify New Tour Home Page Logo and Title is being displayed on the home page .
                 3)Verify login by entering valid username /password
                 4)Login should be successful 

   * @author : Lakshmi Ay 
**********************************************************************************************************************************************************************************/

package com.newtour.LoginKeyfunctional.testcases;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newtour.qa.helper.WaitHelper;
import com.newtour.qa.testbase.NewToursBase;
import com.newtour.qa.util.CommonUtility;
import com.newtour.qa.util.TestUtil;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_KF_LG_01_VerifyHomePageLoginTest extends NewToursBase {

	String fileName = this.getClass().toString();

	@Test(priority = 0)
	public void verifyURLLaunchTest() throws Exception {

		loginpage.performLogin();

	}

	@Test(priority = 1, dependsOnMethods = { "verifyURLLaunchTest" })
	public void verifyHomePageTitleTest() throws Exception {

		String title = loginpage.validateNewToursPageTitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");
	}

	@Test(priority = 2, dependsOnMethods = { "verifyHomePageTitleTest" })
	public void verifyHomePageLogoTest() {

		boolean flag = loginpage.validateNewToursLogoImage();
		Assert.assertTrue(flag);
	}

	@Test(dataProvider = "getTestData", priority = 3, dependsOnMethods = { "verifyHomePageLogoTest" })
	public void verifyValidCredentialsTest(String userName, String password) throws Exception {

		loginpage.enterCredentials(userName, password);

	}

	@Test(priority = 4, dependsOnMethods = { "verifyValidCredentialsTest" })
	public void verifyIsLoginSuccessfulTest() {

		String title = flightspage.validateFlightPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Find a Flight: Mercury Tours:");

		boolean flg = loginpage.isLoginSuccessful();
		Assert.assertTrue(flg);

	}

	@Test(priority = 5, dependsOnMethods = { "verifyIsLoginSuccessfulTest" })
	public void verifySignOffTest() {

		signonpage.clickSignOff();

	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {

			System.out.println(testResult.getStatus());
			methodName = testResult.getName().toString().trim();
			CommonUtility.takeFailedScreenshot(getWebDriver(), fileName);

			System.out.println(CommonUtility.newFailedScreenShotFileName);

		}

	}

	@AfterClass
	public void tearDown() throws IOException {

		CommonUtility.takeScreenshot(getWebDriver(), fileName);
		getWebDriver().quit();

	}

}

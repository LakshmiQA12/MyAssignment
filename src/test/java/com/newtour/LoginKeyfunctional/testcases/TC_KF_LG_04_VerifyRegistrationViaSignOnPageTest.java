/*******************************************************************************************************************************************************************************
 * Test Scenario : Verify Login Scenario on the Signon Page
 * Test Steps : 1)Launch URL 
                2)Click sign on button
                3)Enter Valid Username/password 
                4)Login should be successful 

  * @author : Lakshmi Ay 
**********************************************************************************************************************************************************************************/

package com.newtour.LoginKeyfunctional.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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

public class TC_KF_LG_04_VerifyRegistrationViaSignOnPageTest extends NewToursBase {

	String fileName = this.getClass().toString();

	@Test(priority = 0)
	public void verifyURLLaunchTest() throws Exception {

		loginpage.performLogin();

	}

	@Test(priority = 1, dependsOnMethods = { "verifyURLLaunchTest" })
	public void verifySignonClickTest() throws Exception {

		signonpage.clickSignonPage();
		loginpage.validateMainLogo();
		
	}

	@Test(priority = 2, dependsOnMethods = { "verifySignonClickTest" })
	public void verifyNavigationToRegistrationTest() throws Exception {

		
		signonpage.clickRegistrationForm();
		loginpage.validateMainLogo();
		
		
	}

	@Test(priority = 3, dependsOnMethods = { "verifyNavigationToRegistrationTest" })
	public void verifyRegisterPageLogoTest() {

		boolean flag = registerpage.validateRegisterPageLogo();
		Assert.assertTrue(flag);
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

		}

	}

	@AfterClass
	public void tearDown() throws IOException {

		CommonUtility.takeScreenshot(getWebDriver(), fileName);
		getWebDriver().quit();

	}

}

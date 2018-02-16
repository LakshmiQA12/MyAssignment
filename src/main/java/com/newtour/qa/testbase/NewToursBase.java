/************************************************************************
* @author : Lakshmi Ay 
* Test Base Class
**********************************************************************************************************************************************************************************/

package com.newtour.qa.testbase;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.BeforeClass;

import com.newtour.qa.pages.FlightsPage;
import com.newtour.qa.pages.LoginPage;
import com.newtour.qa.pages.RegisterPage;
import com.newtour.qa.pages.SignonPage;
import com.newtour.qa.util.CommonConstants;
import com.newtour.qa.util.CommonUtility;
import com.newtour.qa.util.TestUtil;

abstract public class NewToursBase {

	protected static Logger log = Logger.getLogger(NewToursBase.class);

	protected static String SERVER_URL;
	protected static String BROWSER;
	protected static final String BROWSER_CHROME = "chrome";
	protected static final String BROWSER_FIREFOX = "firefox";

	protected static WebDriver driver;
	protected static Actions action;

	protected LoginPage loginpage;
	protected FlightsPage flightspage;
	protected SignonPage signonpage ;
	protected RegisterPage registerpage ;
	

	protected String datePattern = "dd/MM/yyyy";
	protected String dateInStringText = new SimpleDateFormat(datePattern).format(new Date());
	protected String methodName;

	protected static String loginValidTestDataFilePath = CommonConstants.VALIDLOGIN_TESTDATA_PATH + "//ValidLoginTestData.xlsx";
	protected static String loginInValidTestDataFilePath = CommonConstants.VALIDLOGIN_TESTDATA_PATH + "//InvalidLoginTestData.xlsx";
	protected static String journeyTestDataFilePath = CommonConstants.JOURNEY_TESTDATA_PATH + "//JourneyTestData.xlsx";
	

	static {

		System.setProperty("webdriver.chrome.driver", "ChromeDriver//chromedriver.exe");

		SERVER_URL = TestUtil.SERVER_URL;
		System.out.println("SERVER_URL: " + SERVER_URL);

		BROWSER = TestUtil.BROWSER;
		System.out.println("BROWSER: " + BROWSER);

	}

	@BeforeClass
	public void before() throws Exception {
		CommonUtility.createFolders();

		driver = createWebDriver(BROWSER);

		/** Creating Page Objects for Login and Flight Pages **/

		loginpage = new LoginPage();
		flightspage = new FlightsPage();
		signonpage = new SignonPage();
		registerpage = new RegisterPage();
		
		

		action = new Actions(driver);

	}

	protected static WebDriver createWebDriver(String browser) throws MalformedURLException, InterruptedException {

		driver = null;
		System.out.println("Running with [" + BROWSER + "]");

		if (browser.equals(BROWSER_CHROME)) {

			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			driver.manage().window().setPosition(new Point(0, 0));
			driver.manage().window().setSize(new Dimension(1920, 935));

		}

		if (browser.equals(BROWSER_FIREFOX)) {
			System.setProperty("webdriver.gecko.driver", "GeckoDriver//geckodriver.exe");
			driver = new FirefoxDriver();
		}

		return driver;
	}

	public static WebDriver getWebDriver() {
		return driver;
	}

}

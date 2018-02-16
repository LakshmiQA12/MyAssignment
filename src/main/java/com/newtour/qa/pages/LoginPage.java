/***********************************************************************************************************************************
* @author : Lakshmi Ay 
***********************************************************************************************************************************************************************************/

package com.newtour.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.newtour.qa.helper.JavascriptHelper;
import com.newtour.qa.helper.WaitHelper;
import com.newtour.qa.helper.XpathHelper;
import com.newtour.qa.testbase.NewToursBase;
import com.newtour.qa.util.TestUtil;

public class LoginPage extends NewToursBase {

	@FindBy(how = How.NAME, using = "userName")
	public WebElement userName;

	@FindBy(how = How.NAME, using = "password")
	public WebElement password;

	@FindBy(how = How.NAME, using = "login")
	public WebElement signin;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public void loginAndOpenModule(String moduleId) throws Exception {
		performLogin();

	}

	public void performLogin() {

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(TestUtil.SERVER_URL);

		log.info("Launching URL");
		WaitHelper.implicitWait(5);
		// simpleWait(5);

	}

	public void enterCredentials(String uname, String pwd) {

		
			WebElement unameElement = WaitHelper.waitUntilVisible(userName, 5);
			JavascriptHelper.flash(unameElement);
			if (unameElement != null) {
				unameElement.clear();
				unameElement.sendKeys(uname);
				log.info("Entering UserName");
			}

			WebElement pwdElement = WaitHelper.waitUntilVisible(password, 5);
			JavascriptHelper.flash(pwdElement);
			if (pwdElement != null) {
				pwdElement.clear();
				pwdElement.sendKeys(pwd);
				log.info("Entering Password");
			}

			WebElement signinElement = WaitHelper.clickWhenReady(signin, 5);
			JavascriptHelper.flash(signinElement);
			if (signinElement != null) {
				signinElement.click();
				log.info("click signin");
			}
			WaitHelper.simpleWait(1);

		

	}

	public String validateNewToursPageTitle() {
		return driver.getTitle();
	}

	public boolean validateNewToursLogoImage() {

		WebElement ImageFile = WaitHelper
				.waitUntilVisible(XpathHelper.findByXPath("//img[contains(@alt,'Mercury Tours')]"), 5);
		JavascriptHelper.flash(ImageFile);

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				ImageFile);

		if (!ImagePresent) {
			log.info("**NewTours Logo image is displayed****");
			System.out.println("Logo Image not displayed.");
			return false;

		} else {
			log.info("***NewTours Logo image is not displayed****");
			System.out.println("Logo Image displayed.");
			return true;

		}

	}

	public boolean isLoginSuccessful() {

		WebElement flightFinderImgFileElt = WaitHelper.waitUntilVisible(
				XpathHelper.findByXPath("//img[contains(@src,'/images/masts/mast_flightfinder.gif')]"),10);

		
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				flightFinderImgFileElt);

		if (!ImagePresent) {
			log.info("After Login from Home Page : Flight finder Logo Image is not displayed.Login is not successful");
			System.out.println(
					"After Login from Home Page : Flight Finder  Logo Image is not displayed.Login is not successful");
			return false;

		} else {
			log.info("After Login from Home Page : Flight finder Logo Image is displayed .Login is successful");
			System.out
					.println("After Login from Home Page : Flight finder  Logo Image is displayed.Login is successful");
			return true;

		}
		
		/*WebElement oneWayElement = WaitHelper.waitUntilVisible(XpathHelper.findByName("oneway"),70);
		JavascriptHelper.flash(oneWayElement);
		if(oneWayElement != null)
		{
			oneWayElement.click();
		}*/
				


	}

	public void validateMainLogo() {

		WebElement ImageFile = WaitHelper
				.waitUntilVisible(XpathHelper.findByXPath("//img[contains(@alt,'Mercury Tours')]"), 5);
		JavascriptHelper.flash(ImageFile);
	}

}

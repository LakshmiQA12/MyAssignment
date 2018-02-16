/***********************************************************************************************************************************
* @author : Lakshmi Ay 
***********************************************************************************************************************************************************************************/

package com.newtour.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.newtour.qa.helper.JavascriptHelper;
import com.newtour.qa.helper.WaitHelper;
import com.newtour.qa.helper.XpathHelper;
import com.newtour.qa.testbase.NewToursBase;
import com.newtour.qa.util.TestUtil;

public class SignonPage extends NewToursBase {

	@FindBy(how = How.NAME, using = "userName")
	public WebElement uName;

	@FindBy(how = How.NAME, using = "password")
	public WebElement pword;

	@FindBy(how = How.NAME, using = "login")
	public WebElement submit;

	@FindBy(how = How.LINK_TEXT, using = "SIGN-ON")
	public WebElement signOn;
	
	@FindBy(how = How.LINK_TEXT, using = "SIGN-OFF")
	public WebElement signOff;
	
	@FindBy(how = How.LINK_TEXT, using = "registration form")
	public WebElement register;
	
	

	public SignonPage() {

		PageFactory.initElements(driver, this);
	}

	

	public void clickSignonPage() {
		WebElement clickSignonLinkElement = WaitHelper.clickWhenReady(signOn, 5);
		JavascriptHelper.flash(clickSignonLinkElement);
		if (clickSignonLinkElement != null) {
			clickSignonLinkElement.click();
		}
		
		WaitHelper.simpleWait(1);

	}
	
	public void clickSignOff()
	{
		WebElement clickSignOffElement = WaitHelper.clickWhenReady(signOff, 5);
		JavascriptHelper.flash(clickSignOffElement);
		if (clickSignOffElement != null) {
			clickSignOffElement.click();
		}

	}
	

	public void enterSignOnCredentials(String uname, String pwd) {

		WebElement unameElement = WaitHelper.waitUntilVisible(uName, 5);
		JavascriptHelper.flash(unameElement);
		if (unameElement != null) {
			unameElement.clear();
			unameElement.sendKeys(uname);
			log.info("Entering UserName");
		}

		WebElement pwdElement = WaitHelper.waitUntilVisible(pword, 5);
		JavascriptHelper.flash(pwdElement); 
		if (pwdElement != null) {
			pwdElement.clear();
			pwdElement.sendKeys(pwd);
			log.info("Entering Password");
		}

		WebElement submitElement = WaitHelper.clickWhenReady(submit, 5);
		JavascriptHelper.flash(submitElement);
		if (submitElement != null) {
			submitElement.click();
			log.info("click signin");
		}
		WaitHelper.simpleWait(2);
		
	}

	public String validateSignOnPageTitle() {
		return driver.getTitle();
	}

	public void clickRegistrationForm()
	{
		
		WebElement clickRegisterElement = WaitHelper.clickWhenReady(register, 5) ;
		JavascriptHelper.flash(clickRegisterElement);
		if(clickRegisterElement != null)
		{
			clickRegisterElement.click();
		}
		
	}
	
	public boolean validateSignOnPageLogoImage() {

		WebElement ImageFile = driver.findElement(By.xpath("//img[contains(@src,'/images/masts/mast_signon.gif')]"));
		JavascriptHelper.flash(ImageFile);

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				ImageFile);

		if (!ImagePresent) {
			log.info("***SignOn Logo image is not displayed****");
			System.out.println("SignOn Logo Image not displayed.");
			return false;

		} else {
			log.info("***SignOn Logo image is displayed****");
			System.out.println("SignOn Logo Image displayed.");
			return true;

		}

	}

}

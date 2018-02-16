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

public class RegisterPage extends NewToursBase

{

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateRegisterPageLogo() {

		WebElement ImageFile = driver.findElement(By.xpath("//img[contains(@src,'/images/masts/mast_register.gif')]"));
		JavascriptHelper.flash(ImageFile);

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				ImageFile);

		if (!ImagePresent) {
			log.info("***Register Page Logo image is not displayed****");
			System.out.println("Register Page Logo image is not displayed***");
			return false;

		} else {
			log.info("***Register Page Logo image is displayed**");
			System.out.println("Register Page Logo image is displayed");
			return true;

		}

	}

}

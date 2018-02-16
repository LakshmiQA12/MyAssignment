/***********************************************************************************************************************************
* @author : Lakshmi Ay 
***********************************************************************************************************************************************************************************/

package com.newtour.qa.helper;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.newtour.qa.testbase.NewToursBase;

public class WaitHelper extends NewToursBase {

	static WebDriverWait wait;

	public static void implicitWait(int waitTimeSeconds) {
		driver.manage().timeouts().implicitlyWait(waitTimeSeconds, TimeUnit.SECONDS);
	}

	public static WebElement waitUntilLocated(By by, int waitTimeSeconds) {
		try {
			WebElement element = null;
			wait = new WebDriverWait(driver, waitTimeSeconds);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			System.out.println("text coming on screen to be located is  : " + element.getText());
			return element;
		}
		catch (Exception e) {
			return null;
		}

	}

	public static WebElement clickWhenReady(WebElement elt, int waitTimeSeconds) {
		try {
			WebElement element = null;
			wait = new WebDriverWait(driver, waitTimeSeconds);
			element = wait.until(ExpectedConditions.elementToBeClickable(elt));
			System.out.println("text coming on screen to be clicked  is : " + element.getText());
			
			return element;
		}
		catch (Exception e) {
			return null;
		}

	}

	public static WebElement waitUntilVisible(WebElement elt, int waitTimeSeconds) {
		try {
			WebElement element = null;
			wait = new WebDriverWait(driver, waitTimeSeconds);
			element = wait.until(ExpectedConditions.visibilityOf(elt));
			System.out.println("text coming on screen to be visible is  : " + element.getText());
			return element;
		}
		catch (Exception e) {
			return null;
		}

	}
	
	public static WebElement waitUntilElementToBeClickable(WebElement elt, int waitTimeSeconds) {
		try {
			WebElement element = null;
			wait = new WebDriverWait(driver, waitTimeSeconds);
			element = wait.until(ExpectedConditions.elementToBeClickable(element));
			
			return element;
		}
		catch (Exception e) {
			return null;
		}

	}

	
	
	

	public static WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	public static WebElement  waitForElementVisible(WebElement locator, int timeOutInSeconds, int pollingEveryInMiliSec) {

		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		return wait.until(ExpectedConditions.visibilityOf(locator));
	}

	public static WebElement waitForElement(WebDriver driver, long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElement(WebDriver driver, WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static WebElement waitForElementById(String id, int abortAfterSeconds) {
		try {
			driver.manage().timeouts().implicitlyWait(abortAfterSeconds, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, abortAfterSeconds);
			return wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		}
		catch (Exception e) {
			return null;
		}
	}

	public static WebElement waitForElementByXPath(String xpath, int abortAfterSeconds) {
		try {
			driver.manage().timeouts().implicitlyWait(abortAfterSeconds, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, abortAfterSeconds);
			return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		}
		catch (Exception e) {
			return null;
		}

	}

	public static void simpleWait(int waitTimeSeconds) {

		try {
			driver.manage().timeouts().implicitlyWait(waitTimeSeconds, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, waitTimeSeconds);
			ExpectedCondition<WebElement> ec = ExpectedConditions.visibilityOfElementLocated(By.id("invalid_id"));
			wait.until(ec);

		}
		catch (TimeoutException ex) {
			// Ignore the timeout
		}
		catch (UnhandledAlertException uae) {
			// We are in FF

		}

	}

	
	
}








	//By treatmentByLocator = By.id("Treatment") ;
	
	/*WebElement treatElt = WaitHelper.fluentWait(treatmentByLocator);
	if(treatElt != null)
	{
		treatElt.click();
	}*/
	
/*	WebElement treatElt = WaitHelper.waitUntilLocated(treatmentByLocator, 5) ;
	if(treatElt != null)
	{
		treatElt.click();
	}*/
	




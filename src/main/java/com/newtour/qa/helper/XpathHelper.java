/***********************************************************************************************************************************

* @author : Lakshmi Ay 
* 
**********************************************************************************************************************************************************************************/

package com.newtour.qa.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import com.newtour.qa.testbase.NewToursBase;

public class XpathHelper extends NewToursBase {

	public static WebElement findSelectOptionWithLabelAndOptionText(String label, String optionText) {
		return findByXPath("//div[contains(@class, 'x-form-label') and text()='" + label
				+ "']/following::select[1]/option[text()='" + optionText + "']");
	}

	public static WebElement findSelectOptionWithIdAndOptionText(String id, String optionText) {
		return findByXPath("//select[contains(@id, '" + id + "')]/option[text()='" + optionText + "']");
	}

	public static WebElement findSelectById(String id) {
		return findByXPath("//select[contains(@id, '" + id + "')]");
	}

	public static WebElement findCheckbox(String checkBoxId) {
		return findByXPath("//div[contains(@id, '" + checkBoxId + "')]/input[1]");
	}

	public static WebElement findSpanWithText(String text) {
		return findByXPath("//span[text()='" + text + "']");
	}

	public static void selectRightClickMenu(String menuDescription) {
		findElemByTypeAndText("a", menuDescription).click();
	}

	public static WebElement findByXPath(String xpath) {

		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement findByName(String name) {

		return driver.findElement(By.name(name));
	}

	public static WebElement safeFindWebElementById(String id) {
		try {
			return driver.findElement(By.id(id));
		} catch (NoSuchElementException nsee) {
			log.error("Failed to find web element with id " + id);
			return null;
		}
	}

	public static void rightClickWebElement(WebElement webElement) {
		// right click
		action.contextClick(webElement).perform();
	}

	public static WebElement findElemByTypeAndText(String elementType, String text) {
		return findByXPath("//" + elementType + "[text() = '" + text + "']");
	}

}

/***********************************************************************************************************************************
* @author : Lakshmi Ay 
***********************************************************************************************************************************************************************************/

package com.newtour.qa.helper;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.newtour.qa.testbase.NewToursBase;

public class DropDownHelper extends NewToursBase {

	public static void SelectUsingVisibleValue(WebElement element,String visibleValue) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleValue);
		log.info("Locator : " + element + " Value : " + visibleValue);
	}

	public static String getSelectedValue(WebElement element) {
		String value = new Select(element).getFirstSelectedOption().getText();
		log.info("WebELement : " + element + " Value : "+ value);
		return value;
	}
	
	public static void SelectUsingIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		log.info("Locator : " + element + " Value : " + index);
	}
	
	public static void SelectUsingVisibleText(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		log.info("Locator : " + element + " Value : " + text);
	}
	
	
	public static List<String> getAllDropDownValues(WebElement locator) {
		Select select = new Select(locator);
		List<WebElement> elementList = select.getOptions();
		List<String> optionsValueList = new LinkedList<String>();
		
		for (WebElement element : elementList) {
			log.info(element.getText());
			optionsValueList.add(element.getText());
		}
		return optionsValueList;
	}
}
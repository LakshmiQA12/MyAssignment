/***********************************************************************************************************************************
* @author : Lakshmi Ay 
***********************************************************************************************************************************************************************************/

package com.newtour.qa.helper;

import org.openqa.selenium.WebElement;

import com.newtour.qa.testbase.NewToursBase;

public class ActionsHelper extends NewToursBase {

	public static void doubleClickWebElement(WebElement webElement) {

		action.moveToElement(webElement, 10, 10).doubleClick().perform();

	}

	public static void rightClickWebElement(WebElement webElement) {
		// right click
		action.contextClick(webElement).perform();
	}

	public static void selectRightClickMenu(String menuDescription) {
		XpathHelper.findElemByTypeAndText("a", menuDescription).click();
	}

}

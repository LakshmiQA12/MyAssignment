/***********************************************************************************************************************************
* @author : Lakshmi Ay 
***********************************************************************************************************************************************************************************/

package com.newtour.qa.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.newtour.qa.testbase.NewToursBase;

public class JavascriptHelper extends NewToursBase {
	
	
	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		log.info(script);
		return exe.executeScript(script);
	}
	
	public static void flash(WebElement element)
	{
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        for (int i = 0; i <  30; i++) {
            changeColor("rgb(0,255,0)", element);//1  //Highlight Element 10 times 
            changeColor(bgcolor, element);//2 // Then move back to original colour 
        }
    }
	
	
    public static void changeColor(String color, WebElement element)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
     }

    
    
    

	public void scrollDownVertically() {
		executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollUpVertically() {
		executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public void scrollDownByPixel() {
		executeScript("window.scrollBy(0,1500)");
	}

	public void scrollUpByPixel() {
		executeScript("window.scrollBy(0,-1500)");
	}

	public void ZoomInBypercentage() {
		executeScript("document.body.style.zoom='40%'");
	}

	public void ZoomBy100percentage() {
		executeScript("document.body.style.zoom='100%'");
	}
	

}

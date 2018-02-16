/**********************************************************************************************************************************
* @author : Lakshmi Ay 
**********************************************************************************************************************************************************************************/

package com.newtour.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtility {

	// public static Date date = new Date();
	public static Date date;
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss-SSS");

	public static String path = CommonConstants.SCREEN_SHOTS_BASE_PATH + "\\" + CommonConstants.PASSED_METHODS_PATH
			+ "\\";
	public static String failedpath = CommonConstants.SCREEN_SHOTS_BASE_PATH + "\\"
			+ CommonConstants.FAILED_METHODS_PATH + "\\";

	public static String newScreenShotFileName;
	public static String newFailedScreenShotFileName;
	public static String screenShotFileNameWithTimeStamp;

	public static void createFolders() throws IOException {

		File passedFolder = new File(path);
		if (!passedFolder.exists()) {
			System.out.println("Folder doesnt exist. Create new folder for " + CommonConstants.PASSED_METHODS_PATH);
			passedFolder.mkdir();
		}

		File failedFolder = new File(failedpath);
		if (!failedFolder.exists()) {
			System.out.println("Folder doesnt exist. Create new folder for " + CommonConstants.FAILED_METHODS_PATH);
			failedFolder.mkdir();
		}

	}

	public static void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {

		System.out.println(screenshotName);

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		date = new Date();

		screenShotFileNameWithTimeStamp = dateFormat.format(date) + ".png";
		System.out.println(screenShotFileNameWithTimeStamp);

		newScreenShotFileName = path + screenshotName + "_" + screenShotFileNameWithTimeStamp;
		System.out.println(newScreenShotFileName);

		FileUtils.copyFile(scrFile, new File(newScreenShotFileName));

	}

	public static void takeFailedScreenshot(WebDriver driver, String screenshotName) throws IOException {
		
		System.out.println("pass");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println("pass");
		date = new Date();
		screenShotFileNameWithTimeStamp = dateFormat.format(date) + ".png";
		System.out.println(screenShotFileNameWithTimeStamp);

		newFailedScreenShotFileName = failedpath + screenshotName + "_" + screenShotFileNameWithTimeStamp;

		FileUtils.copyFile(scrFile, new File(newFailedScreenShotFileName));

	}

}

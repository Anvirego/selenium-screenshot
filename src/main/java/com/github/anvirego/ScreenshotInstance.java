package com.github.anvirego;

import java.io.FileNotFoundException;

import com.github.anvirego.interfaces.ScreenshotInterface;
import com.github.anvirego.interfaces.TestEvidenceInterface;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author Ing. Angelica Viridiana Rebolloza Gonzalez.
 * @version 1.0 03/2021. 
 * ScreenshotInstance: Defines and creates screenshot's instances to work with the Interface implemented.
 */
public class ScreenshotInstance {
	public static ScreenshotInterface getInstance (AppiumDriver<MobileElement> driver, TestEvidenceInterface evidence, String testName, String language) throws FileNotFoundException {
		ScreenshotInterface si = Screenshot.getInstance(driver, evidence, testName, language);
		return si;
	}//Method

}//Class

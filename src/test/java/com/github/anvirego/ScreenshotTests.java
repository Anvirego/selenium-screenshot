package com.github.anvirego;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.github.anvirego.interfaces.ScreenshotInterface;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author Ing. Angelica Viridiana Rebolloza Gonzalez.
 * @version 2.0 03/2021. 
 * ScreenshotTests: Examples of implementation.
 */
public class ScreenshotTests {
	
	public static void main(String args[]) throws FileNotFoundException, IOException {
		AppiumDriver<MobileElement> driver = null;
		ScreenshotInterface si = ScreenshotInstance.getInstance(null, TestEvidenceInstance.getInstance(null, null, null, null), "Angelica", "Android");

	}//Main

}//Class

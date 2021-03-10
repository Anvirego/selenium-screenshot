package com.github.anvirego;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.github.anvirego.interfaces.ScreenshotInterface;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ScreenshotTests {
	
	public static void main(String args[]) throws FileNotFoundException, IOException {
		AppiumDriver<MobileElement> driver = null;
		ScreenshotInterface si = ScreenshotInstance.getInstance(null, TestEvidenceInstance.getInstance(null, null, null, null), "Angelica", "Android");
		
		
	}//Main

}//Class

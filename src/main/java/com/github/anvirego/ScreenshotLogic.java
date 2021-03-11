package com.github.anvirego;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.github.anvirego.interfaces.ScreenshotInterface;

/**
 * @author Ing. Angelica Viridiana Rebolloza Gonzalez.
 * @version 2.0 03/2021.
 * ScreenshotLogic: Library main logic. 
 */
public class ScreenshotLogic implements ScreenshotInterface {
	private static File word;
	
	protected File setWordName(String name) {
		word = new File(name);
		return word;
	}//Method
//▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
	@Override
	public void getScreen(String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getScreen(String description, WebDriver driverWeb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeScreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public File getWordName() {
		// TODO Auto-generated method stub
		return null;
	}

}//Class
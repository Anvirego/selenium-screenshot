package com.github.anvirego.interfaces;

import java.io.File;

import org.openqa.selenium.WebDriver;

/**
 * @author Ing. Angelica Viridiana Rebolloza Gonzalez.
 * @version 1.0 03/2021.
 * ScreenshotInterface: Interface Implementation. 
 */
public interface ScreenshotInterface {
	
	//Takes screenshot using Mobile Driver with description.
	public void getScreen(String description);
	
	//Takes screenshot using Web Driver with description.
	public void getScreen(String description, WebDriver driverWeb);
	
	//Closes screenshot instance.
	public void closeScreen();
	
	//Gets the name of the word file.
	public File getWordName();

}//Interface

package com.github.anvirego.interfaces;

import java.io.File;

import org.openqa.selenium.WebDriver;

public interface ScreenshotInterface {
	
	public void getScreen(String description);
	
	public void getScreen(String description, WebDriver driverWeb);
	
	public void closeScreen();
	
	public File getWordName();

}//Interface

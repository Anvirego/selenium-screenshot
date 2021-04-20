package com.github.anvirego;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.Reporter;

import com.github.anvirego.interfaces.TestEvidenceInterface;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author Ing. Angelica Viridiana Rebolloza Gonzalez.
 * @version 2.2 03/2021.
 * Screenshot: Takes screenshot and creates the final Word Document Evidence.
 */
public final class Screenshot extends ScreenshotLogic {
	private static AppiumDriver<MobileElement> driver;
	private static String folderName;
	private int step;
	private static FileOutputStream outPicture;
	private TestEvidenceInterface evidence;
	private static Screenshot screenS;
	private static File word;
	private static File folder;

	public Screenshot(AppiumDriver<MobileElement> driver, TestEvidenceInterface evidence, String testName, String language) throws FileNotFoundException {
		System.out.println("::::: Screenshot AppiumDriver Constructor :::::");
		Screenshot.driver = driver;
		this.evidence = evidence;
		folderName= "temporal"+driver.getSessionId();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		Date date = cal.getTime();  
		SimpleDateFormat format = new SimpleDateFormat("HH_mm_ss");
		if (language.equalsIgnoreCase("English")) { word = setWordName(testName+"_"+format.format(date).toString()+".doc"); } else {
			word = language.equalsIgnoreCase("Spanish") ? setWordName(testName+"_Spanish"+"_"+format.format(date).toString()+".doc") : setWordName(testName+"_French"+"_"+format.format(date).toString()+".doc");
		};
		outPicture = new FileOutputStream("./"+evidence.returnFolderName()+"/"+word);
		System.out.println(".:.:: Document's name: "+word+" ::.:.");
	}//Constructor
//▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
	public static Screenshot getInstance(AppiumDriver<MobileElement> driver, TestEvidenceInterface evidence, String testName, String language) throws FileNotFoundException {
		System.out.println("==== Get Screenshot Instance =====");
		if (screenS == null) {
			System.out.println("New Instance");
			screenS = new Screenshot(driver, evidence, testName, language);
			return screenS;
		} else {
			System.out.println("Old Instance");
			return screenS;
		}
	}//Method
//▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
	public void getScreen(String description) {
		System.out.println("::::: getScreen Method ("+description+") :::::");
		try {
			File picture;
			picture = driver.getScreenshotAs(OutputType.FILE);
			folder = new File(evidence.returnFolderName()+"/"+folderName);
			folder.mkdir();
			FileUtils.copyFile(picture, new File (evidence.returnFolderName()+"/"+folderName+"/.png"));
			step++;
			evidence.setHeight(275);
			evidence.setWidth(190);
			evidence.createEvidence(folder.getAbsolutePath(), description, step);
		} catch (Exception e) {System.out.println("▓▓▓▓▓▓▓▓▓▓ getScreen: "+e+" ▓▓▓▓▓▓▓▓▓▓");}
	}//Method
//▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
	public void getScreen(String description, WebDriver driverWeb) {
		System.out.println("::::: getScreen Method ("+description+") :::::");			
		try {
			File picture;
			try {
				picture = ((RemoteWebDriver) driverWeb).getScreenshotAs(OutputType.FILE);
				folder = new File(evidence.returnFolderName()+"/"+folderName);
				folder.mkdir();
				FileUtils.copyFile(picture, new File (evidence.returnFolderName()+"/"+folderName+"/.png"));
				step++;
				evidence.setHeight(265);
				evidence.setWidth(468);
				evidence.createEvidence(folder.getAbsolutePath(), description, step);
			} catch (org.openqa.selenium.UnhandledAlertException e) {}
		} catch (Exception e) {System.out.println("▓▓▓▓▓▓▓▓▓▓ getScreen: "+e+" ▓▓▓▓▓▓▓▓▓▓");}
	}//Method
//▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄	
	public void closeScreen() {
		System.out.println("::::: closeScreen :::::");
		try  {
			evidence.closeWord(folder.getAbsolutePath(), outPicture);
			screenS = null;
		} catch (org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException r) {
		} catch (Exception e) {System.out.println("▓▓▓▓▓▓▓▓▓▓ closeScreen:  "+e+" ▓▓▓▓▓▓▓▓▓▓");}
	}//Method
//▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
	public File getWordName() {
		return word;
	}//Method
	
}//Class

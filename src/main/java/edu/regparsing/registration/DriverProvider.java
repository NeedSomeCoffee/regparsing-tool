package edu.regparsing.registration;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverProvider {
	
	public WebDriver getDriver () {
		System.setProperty("webdriver.chrome.driver", new File("./main/resources/drivers/chromedriver/chromedriver.exe").getAbsolutePath());
		
		return new ChromeDriver();
	}
}

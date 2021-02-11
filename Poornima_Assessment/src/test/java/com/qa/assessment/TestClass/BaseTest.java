package com.qa.assessment.TestClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.assessment.FileHandling.PropertyManager;



public class BaseTest {
	protected	WebDriver driver;
	@BeforeClass
	public void setUp() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", PropertyManager.getProperty("path.driver.chrome"));//accessing the web driver from property manager
		driver = new ChromeDriver();
		driver.get(PropertyManager.getProperty("url.app"));// accessing the url for testing
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
}
}
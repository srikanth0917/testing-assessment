package com.test.sqs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
/*
 *@Author Srikanth Gundam
 *Date: 23-07-2017
 */
public class ExceptionsTest {
	private WebDriver driver; 
	String appURL = "https://the-internet.herokuapp.com/challenging_dom";
	

	@BeforeClass
	public void testSetUp() throws InterruptedException {
	
		FirefoxDriverManager.getInstance().setup();
	
		driver = new FirefoxDriver();
		

	}

	@BeforeMethod
	public void setUp() throws InterruptedException{
		
		driver.get(appURL);
		Thread.sleep(2000);
	}
	
	@Test(expectedExceptions=NoSuchElementException.class)
	public void imageExceptionTest(){
		
			driver.findElement(By.xpath("html/body/div[1]/a/img"));
	}
	
	@Test(expectedExceptions=IndexOutOfBoundsException.class)
	public void numberOfRowsExceedsTest(){
		List<WebElement> rows= driver.findElements(By.xpath("html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr"));
		WebElement element=rows.get(11);
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.close();;
	}

}

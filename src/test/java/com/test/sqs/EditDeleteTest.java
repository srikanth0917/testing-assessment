package com.test.sqs;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class EditDeleteTest {
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
	
	@Test
	public void verify_edit_click() throws InterruptedException{
		driver.findElement(By.xpath("//a[@href='#edit']"))
		      .click();
		Thread.sleep(2000);
	assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/challenging_dom#edit");
		
	}
	
	@Test
	public void verify_Delete_click() throws InterruptedException{
		driver.findElement(By.xpath("//a[@href='#delete']"))
		      .click();
		Thread.sleep(2000);
	assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/challenging_dom#delete");
		
	}
	@AfterClass
	public void tearDown() {
		driver.close();;
	}

}

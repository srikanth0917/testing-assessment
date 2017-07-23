package com.test.sqs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class ButtonsTest {
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
	public void verify_Buttons(){
		List<WebElement> list=driver.findElements(By.xpath("//a[contains(@class,'button')]"));
		if(Optional.ofNullable(list)!=null)
			assertEquals(3,list.size());
	}

	
	@Test
	public void verify_First_Button_Click() throws InterruptedException {
		
		
		Object canvas=null;
		Object canvas1=null;
		if (driver instanceof JavascriptExecutor) {
			  canvas=((JavascriptExecutor) driver).executeScript("return document.getElementById('canvas').getContext('2d')");
		}
		
	   driver.findElement(By.className("button")).click();
	   Thread.sleep(2000);

	   if (driver instanceof JavascriptExecutor) {
			  canvas1=((JavascriptExecutor) driver).executeScript("return document.getElementById('canvas').getContext('2d')");
		}
	
		assertNotEquals(canvas,canvas1);
	}
	
	
	@Test
	public void verify_Second_Button_Click(){
		
		
		Object canvas=null;
		Object canvas1=null;
		if (driver instanceof JavascriptExecutor) {
			  canvas=((JavascriptExecutor) driver).executeScript("return document.getElementById('canvas').getContext('2d')");
		}
		driver.findElement(By.cssSelector(".button.alert")).click();
		if (driver instanceof JavascriptExecutor) {
			  canvas1=((JavascriptExecutor) driver).executeScript("return document.getElementById('canvas').getContext('2d')");
		}
		assertNotEquals(canvas,canvas1);
	}
	
	@Test
	public void verify_Thrid_Button_Click(){
	
		
		Object canvas=null;
		Object canvas1=null;
		if (driver instanceof JavascriptExecutor) {
			  canvas=((JavascriptExecutor) driver).executeScript("return document.getElementById('canvas').getContext('2d')");
		}
		driver.findElement(By.cssSelector(".button.success")).click();
		if (driver instanceof JavascriptExecutor) {
			  canvas1=((JavascriptExecutor) driver).executeScript("return document.getElementById('canvas').getContext('2d')");
		}
		assertNotEquals(canvas,canvas1);
	}

	
	
	@AfterClass
	public void tearDown() {
		driver.close();;
	}

}

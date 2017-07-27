package com.test.sqs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

/*
 *@Author Srikanth Gundam
 *Date: 23-07-2017
 */
public class HerokuappTest extends TestNG{
	
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
	public void verify_Click_linkTest() throws InterruptedException{
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).click();
		driver.navigate().to("http://elementalselenium.com/");
	
		System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().contains("Elemental Selenium"));
		
	}
	
	@Test
	public void verify_numberof_columns(){
		List<WebElement> headings=driver.findElements(By.xpath("html/body/div[2]/div/div/div/div/div[2]/table/thead/tr/th"));
		assertEquals(7, headings.size());
	}
	
	@Test
	public void verify_table_heading_names(){
		List<WebElement> headings=driver.findElements(By.xpath("html/body/div[2]/div/div/div/div/div[2]/table/thead/tr/th"));
		String[] h ={"Lorem","Ipsum","Dolor","Sit","Amet","Diceret","Action"};
		boolean columnnamesmatch=true;
		List<String> headingss=Arrays.asList(h);
		for(WebElement element:headings){
			if(!headingss.contains(element.getText())){
				columnnamesmatch=false;
				break;
			};
		}
		
		assertTrue(columnnamesmatch);
	}
	
	@Test
	public void verify_numberof_rows(){
		
		List<WebElement> rows= driver.findElements(By.xpath("html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr"));
		assertEquals(10, rows.size());
	}

	
	@Test
	public void verify_heading(){
		WebElement element=driver.findElement(By.xpath("//h3[text()='Challenging DOM']"));
		assertEquals("Challenging DOM",element.getText());
	}
	
	@Test
	public void verify_forkme_on_github(){
		WebElement element =driver.findElement(By.xpath("html/body/div[2]/a/img"));
		Actions builder=new Actions(driver);
		builder.moveToElement(element).click().build().perform();
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.close();;
	}
	
}
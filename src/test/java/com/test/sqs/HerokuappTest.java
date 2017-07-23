package com.test.sqs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



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
	
	@Test
	public void verify_Click_Element() throws InterruptedException{
		
		driver.findElement(By.xpath("html/body/div[2]/a/img")).click();
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("GitHub"));
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
	public void verify_edit_click(){
		driver.findElement(By.xpath("//a[@href='#edit']"))
		      .click();
	assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/challenging_dom#edit");
		
	}
	
	@Test
	public void verify_Delete_click(){
		driver.findElement(By.xpath("//a[@href='#delete']"))
		      .click();
	assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/challenging_dom#delete");
		
	}
	
	@Test
	public void verify_heading(){
		driver.findElement(By.xpath("//h3[text()='Challenging DOM']"));
	}
	
	
	
	//@AfterClass
	public void tearDown() {
		driver.close();;
	}
	
}
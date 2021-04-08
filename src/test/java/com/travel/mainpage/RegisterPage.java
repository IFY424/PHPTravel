package com.travel.mainpage;

import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class RegisterPage extends BasePage {
	final static Logger logger = Logger.getLogger(RegisterPage.class);

	public RegisterPage wait_ForRegisterPageLoad() {
		try {
			logger.info("Step>Wait For Register Page Load");
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement registerBtn = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".btn.btn-large.btn-primary"));
				}

			});
			assertNotNull(registerBtn);
		} catch (Exception e) {
			logger.error("Error!Waiting For Register Page Failed");
		}
		return this;

	}
public RegisterPage enter_PersonaInfo() {
	try {
		logger.info("Step>Enter Personal Information For Registration");
		driver.findElement(By.id("firstname")).sendKeys("Donald");
		driver.findElement(By.id("lastname")).sendKeys("Trump");
		driver.findElement(By.id("companyname")).sendKeys("Trump Tower");
		driver.findElement(By.id("email")).sendKeys("trump@gmail.com");
		driver.findElement(By.id("inputNewPassword1")).sendKeys("1234567@Dt");
		driver.findElement(By.id("inputNewPassword2")).sendKeys("1234567@Dt");
		driver.findElement(By.id("address1")).sendKeys("White House");
		driver.findElement(By.id("city")).sendKeys("Washington DC");
		driver.findElement(By.id("stateinput")).sendKeys("Washigton");
		driver.findElement(By.id("postcode")).sendKeys("13456");
		
		WebElement country=driver.findElement(By.id("country"));
		Select sel=new Select(country);
		sel.selectByValue("US");
		
		driver.findElement(By.id("phonenumber")).sendKeys("13139485948");
		WebElement hear=driver.findElement(By.id("customfield1"));
		Select selOne=new Select(hear);
		selOne.selectByValue("Google");
		
		driver.findElement(By.id("customfield2")).sendKeys("13139485948");
	}catch(Exception e) {
		logger.error("Error!It Did Not Enter One Of the Field");
		
	}
	return this;
	
}
	
 public RegisterPage click_OnRegister() {
	 try {
		 logger.info("Step>Click on Register");
		 JavascriptExecutor jav=(JavascriptExecutor)driver;
		 jav.executeScript("window.scrollBy(0,500)", "");
		 Thread.sleep(2000);
		 driver.findElement(By.cssSelector(".btn.btn-large.btn-primary")).click();
		 
	 }catch(Exception e) {
		 logger.error("Error! It Did Not Click On Register");
	 }
	return this;
	 
 }
	
	public RegisterPage verify_Alert() {
		try {
			logger.info("Step>Verify Alert Message");
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement alert = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".alert.alert-danger"));
				}

			});
			assertNotNull(alert);
			
		}catch(Exception e) {
			logger.error("Error!Verifing Alert Message Failed");
		}
		return this;
		
	}
	
	
}

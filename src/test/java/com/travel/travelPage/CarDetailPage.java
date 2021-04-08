package com.travel.travelPage;

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

public class CarDetailPage extends BasePage{
	final static Logger logger = Logger.getLogger(CarDetailPage.class);

	public CarDetailPage wait_ForCarDetailPageLoading() {

		try {
			logger.info("Step>Waiting for Car Detail Page");
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement bookNowBtn = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".btn.btn-block.btn-action.btn-lg"));
				}

			});
			assertNotNull(bookNowBtn);
		} catch (Exception e) {
			logger.error("Error! Waiting for Car Detai Page Failed");
		}
		return this;

	}

	public CarDetailPage select_PickUpOption() {

		try {
			logger.info("Step>Select Pick Up Option");
			Thread.sleep(2000);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)", "");
		    driver.findElement(By.id("s2id_pickuplocation")).findElement(By.className("select2-choice")).click();
		    Thread.sleep(3000);
	        driver.findElement(By.id("select2-drop")).findElement(By.className("select2-input")).sendKeys("dubai");
		    
	        driver.findElement(By.cssSelector(".select2-result-label")).click();
		
		
		} catch (Exception e) {
			logger.error("Error! It Did Not Select Pick Up Option");
		}
		return this;

	}
	public CarDetailPage select_DropOffOption() {

		try {
			logger.info("Step>Select Drop Off Option");
			 driver.findElement(By.id("s2id_droplocation")).findElement(By.className("select2-choice")).click();
			    Thread.sleep(3000);
		        driver.findElement(By.cssSelector(".select2-input.select2-focused")).sendKeys("dubai");
			    
		        driver.findElement(By.cssSelector(".select2-result-label")).click();
			
			
		} catch (Exception e) {
			logger.error("Error! It Did Not Select Drop Off Option");
		}
		return this;

	}
	public CarDetailPage select_PickUpDate() {

		try {
			logger.info("Step>Select Pick Up Date");
			driver.findElement(By.id("departcar2")).clear();
			driver.findElement(By.id("departcar2")).sendKeys("20/09/2017");
			
		} catch (Exception e) {
			logger.error("Error! It Did Not Select Pick Up Date");
		}
		return this;

	}
	
	public CarDetailPage select_PickUpTime() {

		try {
			logger.info("Step>Select Pick Up Time");
            WebElement pickUpTime=driver.findElement(By.name("pickupTime"));
            Select sel=new Select(pickUpTime);
            sel.selectByValue("08:30");
		} catch (Exception e) {
			logger.error("Error! It Did Not Select Pick Up Time");
		}
		return this;

	}
	public CarDetailPage select_DropOffDate() {

		try {
			logger.info("Step>Select Drop Off Date");
			driver.findElement(By.id("returncar2")).clear();
			driver.findElement(By.id("returncar2")).sendKeys("21/09/2017");
			
		} catch (Exception e) {
			logger.error("Error! It Did Not Select Drop Off Date");
		}
		return this;

	}
	public CarDetailPage select_DropOffTime() {

		try {
			logger.info("Step>Select Pick Up Time");
            WebElement dropOffTime=driver.findElement(By.name("dropoffTime"));
            Select sel=new Select(dropOffTime);
            sel.selectByValue("08:30");
		} catch (Exception e) {
			logger.error("Error! It Did Not Select Pick Up Time");
		}
		return this;

	}
	public CarDetailPage click_OnBookNow() {

		try {
			logger.info("Step>Click On Book Now Btn");
           driver.findElement(By.cssSelector(".btn.btn-block.btn-action.btn-lg")).click();
		} catch (Exception e) {
			logger.error("Error! It Did Not Click On Book Now Btn");
		}
		return this;

	}
	
	
	
	
	
	
	
}

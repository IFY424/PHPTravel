package com.travel.travelPage;

import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class TourBookingSummaryPage extends BasePage{
	final static Logger logger=Logger.getLogger(TourBookingSummaryPage.class);
	
	public TourBookingSummaryPage wait_UntilPageLoad() {
		try {
			logger.info("Step>Waiting For Booking Summary Page Load");
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement bookingSummary = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".col-md-4.go-left.right-content"));
				}

			});
			assertNotNull(bookingSummary);
		}catch(Exception e) {
			logger.error("Error!Waiting For Booking Summary Page Load Failed");
		}
		return this;
		
	}
	public TourBookingSummaryPage click_SignInBtn() {
		try {
			logger.info("Step>Click Sign In Button");
			driver.findElement(By.id("signintab")).click();
		}catch(Exception e) {
			logger.error("Error!Clicking Sign In Button Failed");
		}
		return this;
		
	}
	public TourBookingSummaryPage enter_UserNameAndPass() {
		try {
			logger.info("Step>Enter User name and Password");
			driver.findElement(By.id("username")).sendKeys("user@phptravels.com");
			Thread.sleep(2000);
			driver.findElement(By.id("password")).sendKeys("demouser");
		}catch(Exception e) {
			logger.error("Error!It Did Not Enter User name and Password");
		}
		return this;
		
	}
	public TourBookingSummaryPage select_Extras() {
		try {
			logger.info("Step>Select Extras");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)", "");
			driver.findElements(By.cssSelector(".switch-light.switch-ios")).get(1).click();
		}catch(Exception e) {
			logger.error("Error!It Did Not Select Extras");
		}
		return this;
		
	}
	public TourBookingSummaryPage enter_GuestInformation() {
		try {
			logger.info("Step>Enter Guest Information");
			driver.findElement(By.name("passport[1][name]")).sendKeys("nana");
			driver.findElement(By.name("passport[1][passportnumber]")).sendKeys("G1234");
			driver.findElement(By.name("passport[1][age]")).sendKeys("26");
			driver.findElement(By.name("passport[2][name]")).sendKeys("mama");
			driver.findElement(By.name("passport[2][passportnumber]")).sendKeys("G12345");
			driver.findElement(By.name("passport[2][age]")).sendKeys("28");
			driver.findElement(By.name("passport[3][name]")).sendKeys("LaLa");
			driver.findElement(By.name("passport[3][passportnumber]")).sendKeys("G123456");
			driver.findElement(By.name("passport[3][age]")).sendKeys("9");
			
			
			
		}catch(Exception e) {
			logger.error("Error!It Did Not Enter Guest Information");
		}
		return this;
		
	}
	public TourBookingSummaryPage click_OnBookingConfirmation() {
		try {
			logger.info("Step>Click on Booking Confirmation Button");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".btn.btn-action.btn-lg.btn-block.completebook")).click();
		}catch(Exception e) {
			logger.error("Error!It Did Not Click on Booking Confirmation Button");
		}
		return this;
		
	}

}

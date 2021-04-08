package com.travel.adminPage;

import static org.testng.Assert.assertNotNull;

import java.util.List;
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

public class QuickBookingPage extends BasePage{
	final static Logger logger=Logger.getLogger(QuickBookingPage.class);
	public QuickBookingPage wait_UntilQuickBookingPageComplete() throws Exception {
		logger.info("Step:>Waiting for Quick Booking Pageload Complete");
		try {
			Thread.sleep(2000);
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement bookNow = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".btn.btn-primary"));
				}

			});
			assertNotNull(bookNow);
		} catch (Exception e) {
			logger.error("Error!! Waiting Element Is Failed");
		}
		return this;

	}
	
	public QuickBookingPage select_CheckInCheckOutPage() {
		try {
			logger.info("Step>Select CheckInCheckOutPage");
			Thread.sleep(1000);
			driver.findElements(By.xpath(".//*[@id='Hotels']")).get(1).click();
			driver.findElements(By.xpath(".//*[@id='Hotels']")).get(1).sendKeys("20/09/2017");
			driver.findElements(By.xpath(".//*[@id='Hotels']")).get(1).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='bookingform']/div[3]/div[2]/div[2]/div/input")).click();
			driver.findElement(By.xpath(".//*[@id='bookingform']/div[3]/div[2]/div[2]/div/input")).sendKeys("22/09/2017");
			driver.findElement(By.xpath(".//*[@id='bookingform']/div[3]/div[2]/div[2]/div/input")).click();
		}catch(Exception e) {
			logger.error("Error! It Did Not Select CheckInCheckOutPage ");
		}
		return this;
		
	}
	
	public QuickBookingPage select_HotelName() {
		try {
			logger.info("Step>Select Hotel Name");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(2000);
			driver.findElement(By.id("s2id_autogen3")).findElement(By.className("select2-arrow")).click();
			List<WebElement>hotels=driver.findElement(By.id("select2-drop")).findElement(By.className("select2-results")).findElements(By.cssSelector(".select2-result-label"));
			 for(WebElement temp:hotels) {
				 System.out.println(temp.getText());
				 if(temp.getText().contains("Hyatt Regency Perth")){
					 temp.click();
					 break;
				 }
			 }
		}catch(Exception e) {
			logger.error("Error!It Did Not Select Hotel Name ");
		}
		return this;
		
	}
	
	public QuickBookingPage select_RoomName() {
		try {
			logger.info("Step>Select Room Name");
			Thread.sleep(1000);
			driver.findElement(By.id("s2id_poprooms")).findElement(By.className("select2-arrow")).click();
			List<WebElement>rooms=driver.findElement(By.id("select2-drop")).findElement(By.className("select2-results")).findElements(By.cssSelector(".select2-result-label"));
			 for(WebElement temp:rooms) {
				 if(temp.getText().contains("Executive Two-Bedrooms Apartment")){
					 temp.click();
					 break;
				 }
			 }
		}catch(Exception e) {
			logger.error("Error!It Did Not Select Room Name ");
		}
		return this;
		
	}
	
	


	public QuickBookingPage enter_PerNightPrice() {
		try {
			logger.info("Step>Enter Per Night Price");
			Thread.sleep(1000);
			driver.findElement(By.id("roomtotal")).clear();
			driver.findElement(By.id("roomtotal")).sendKeys("100");
		}catch(Exception e) {
			logger.error("Error! It Did Not Enter Per Night Price");
		}
		return this;
		
	}
	
	public QuickBookingPage enter_TotalDeposit() {
		try {
			logger.info("Step>Enter Total Deposit");
			Thread.sleep(1000);
			driver.findElement(By.id("totaltopay")).clear();
			driver.findElement(By.id("totaltopay")).sendKeys("100.00");
		}catch(Exception e) {
			logger.error("Error! It Did Not Enter Total Deposit ");
		}
		return this;
		
	}
	public QuickBookingPage click_OnExtras() {
		try {
			logger.info("Step>Click On Extras");
			Thread.sleep(1000);
			driver.findElement(By.id("extras_4")).click();
			
		}catch(Exception e) {
			logger.error("Error! It Did Not Click On Extras ");
		}
		return this;
		
	}
	
	
	public QuickBookingPage select_OnPyamentMethod() {
		try {
			logger.info("Step>Select Payment Method");
			Thread.sleep(1000);
		WebElement payments=driver.findElements(By.cssSelector(".form-control")).get(15);
		Select sel=new Select(payments);
		sel.selectByValue("payonarrival");
		
		}catch(Exception e) {
			logger.error("Error! It Did Not Select Payment Method ");
		}
		return this;
		
	}
	
	
	public QuickBookingPage click_OnBookNow() {
		try {
			logger.info("Step>Click On Book Now");
			
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg")).click();
			
		}catch(Exception e) {
			logger.error("Error! It Did Not Click On Book Now ");
		}
		return this;
		
	}
	

}

package com.travel.adminPage;

import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class EditBookingPage extends BasePage {
	final static Logger logger = Logger.getLogger(EditBookingPage.class);

	public EditBookingPage wait_UntilEditBookingPageComplete() throws Exception {
		logger.info("Step:>Waiting for Edit Booking Pageload Complete");
		try {
			Thread.sleep(2000);
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement updateBooking = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".btn.btn-primary.btn-block.btn-lg"));
				}

			});
			assertNotNull(updateBooking);
		} catch (Exception e) {
			logger.error("Error!! Waiting Element Is Failed");
		}
		return this;

	}

	public EditBookingPage enter_TotalDeposit() {
		try {
			logger.info("Step>Enter Total Deposit");
			Thread.sleep(1000);
			driver.findElement(By.id("totaltopay")).clear();
			driver.findElement(By.id("totaltopay")).sendKeys("100.00");
		} catch (Exception e) {
			logger.error("Error! It Did Not Enter Total Deposit ");
		}
		return this;

	}
	public EditBookingPage select_BookingStatus() {
		try {
			logger.info("Step>Select Booking Status");
		Thread.sleep(1000);
		WebElement status=driver.findElement(By.name("status"));
		Select sel=new Select(status);
		sel.selectByValue("paid");
		
		}catch(Exception e) {
			logger.error("Error! It Did Not Select Booking Status ");
		}
		return this;
		
}

	public EditBookingPage select_PaymentMethod() {
		try {
			logger.info("Step>Select Payment Method");
		Thread.sleep(3000);
		WebElement payMethod=driver.findElement(By.xpath(".//*[@id='content']/div/div[2]/div[1]/form/div[2]/div[2]/div/select"));
		Select selOne=new Select(payMethod);
		selOne.selectByValue("payonarrival");
		
		}catch(Exception e) {
			logger.error("Error! It Did Not Select Payment Method");
		}
		return this;
		
}

	public EditBookingPage click_OnUpdateBooking() {
		try {
			logger.info("Step>click On Update Booking");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-block.btn-lg")).click();
		
		}catch(Exception e) {
			logger.error("Error! It Did Not click On Update Booking");
		}
		return this;
		
}


}

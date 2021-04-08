package com.travel.travelPage;

import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class TourInvoicePage extends BasePage{
	final static Logger logger=Logger.getLogger(TourInvoicePage.class);
	
	public TourInvoicePage wait_ForInvoicePageLoad() {
		try {
			logger.info("Step>Wait For Invoice Page Load");
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement invoiceTable = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElements(By.cssSelector(".modal-body")).get(2);
			}

		});
		assertNotNull(invoiceTable);
		WebElement payOnArrival=driver.findElement(By.id("50"));
		assertNotNull(payOnArrival);
	}catch(Exception e) {
		logger.error("Error!Waiting For Invoice Page Load Failed");
	}
		return this;
		
	}

	public TourInvoicePage click_OnPayOnArrival() {
		try {
			logger.info("Step>Click On Pay On Arrival");
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement elem = driver.findElement(By.id("50"));
			js.executeScript("arguments[0].click();", elem);
			//driver.findElement(By.xpath(".//*[@id='50']")).click();
		}catch(Exception e) {
			logger.error("Error!It Did Not Click On Pay On Arrival");
		}
		
		return this;
		
	}
	
	public TourInvoicePage click_OnOk() {
		try {
			logger.info("Step>Click On Ok ");
			Thread.sleep(2000);
			Alert alt=driver.switchTo().alert();
			alt.accept();
		}catch(Exception e) {
			logger.error("Error!It Did Not Click On Ok");
		}
		return this;
		
	}
	
	public WebElement verify_Reserved() {
		WebElement dynamicElem=null;
		try {
			logger.info("Step>Verify Reserved");
			dynamicElem = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-success.btn-lg.btn-block.wow.flash.animted.animated")));
		
		}catch(Exception e) {
			logger.error("Error!Verifying Reserved Failed");
			
		}
		return dynamicElem;
		
	}
}

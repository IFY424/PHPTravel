package com.travel.travelPage;

import static org.testng.Assert.assertNotNull;

import java.util.List;
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

public class HotelInvoicePage extends BasePage {
	final static Logger logger = Logger.getLogger(HotelInvoicePage.class);

	public HotelInvoicePage wait_ForInvoicePageLoad() {
		try {
			logger.info("Step>Waiting For Hotel Invoice Page Load");
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement hotelInfo = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(
							".table.table-striped.table-hover.table-bordered.table-responsive>tbody>tr>td"));
				}

			});
			assertNotNull(hotelInfo);
		} catch (Exception e) {
			logger.error("Error! Waiting for Page Load Failed");
		}
		return this;

	}

	public HotelInvoicePage click_onPayNow() {
		try {
			logger.info("Step>Clicking on Pay Now Button");
			Thread.sleep(2000);
			List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
			for (WebElement btn : buttons) {
				if (btn.getText().contains("Pay Now")) {
					btn.click();
				}
			}
		} catch (Exception e) {
			logger.error("Error! It Did Not Click On Pay Now Button");
		}
		return this;

	}

	public HotelInvoicePage click_CreditCardOption() {
		try {
			logger.info("Step>Clicking on Credit Card Option");
			WebElement options = driver.findElement(By.id("gateway"));
			Select dropDown = new Select(options);
			dropDown.selectByValue("authorize");
		} catch (Exception e) {
			logger.error("Error! It Did Not Click On Credit Card Option");
		}

		return this;

	}

	public HotelInvoicePage enter_CreditCardInfo() {
		try {
			logger.info("Step>Enter Credit Card Information");
			driver.findElement(By.id("card-holder-firstname")).sendKeys("Mary");
			driver.findElement(By.id("card-holder-lastname")).sendKeys("John");
			driver.findElement(By.id("card-number")).sendKeys("6011000990139424");

			WebElement month = driver.findElement(By.id("expiry-month"));
			Select dropdow = new Select(month);
			dropdow.selectByValue("03");

			WebElement year = driver.findElement(By.id("expiry-year"));
			Select dropdowOne = new Select(year);
			dropdowOne.selectByValue("2021");

			driver.findElement(By.id("cvv")).sendKeys("004");
		} catch (Exception e) {
			logger.error("Error! It Did Not Enter Credit Card Info");
		}
		return this;

	}
    public HotelInvoicePage click_PayNowBtn() {
    	try {
    		logger.info("Step>Clicking On Pay Now Button");
    		Thread.sleep(1000);
    		driver.findElement(By.cssSelector(".btn.btn-success.btn-lg.paynowbtn.pull-left")).click();
    	     Thread.sleep(2000);
    	}catch(Exception e) {
    		logger.error("Error! It Did Not Click On Pay Now Button");
    	}
		return this;
    	
    }
	
	
	
	
}

package com.travel.mainpage;

import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class ShoppingCartPage extends BasePage {
	final static Logger logger = Logger.getLogger(ShoppingCartPage.class);

	public ShoppingCartPage wait_ForPageLoadComplete() {
		try {
			logger.info("Step>Waiting For Page Load Complete");

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement checkoutBtn = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg"));
				}

			});
			assertNotNull(checkoutBtn);
		} catch (Exception e) {
			logger.error("Error!Waiting For Page Load is Failed");
		}
		return this;
	}
	
	public ShoppingCartPage click_onCheckOutBtn() {
		try {
			Thread.sleep(2000);
			logger.info("Step>Clicking On Checkout Button");
			driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg")).click();
		}catch(Exception e) {
			logger.error("Error!! It Did Not Click On CheckOut Button");
		}
		return this;
		
	}
	

}

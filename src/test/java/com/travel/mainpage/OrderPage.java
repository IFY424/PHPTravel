package com.travel.mainpage;

import static org.testng.Assert.assertNotNull;

import java.util.List;
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

public class OrderPage extends BasePage{
	final static Logger logger=Logger.getLogger(OrderPage.class);
	
	public OrderPage waitUntilOrderPageComplete() throws Exception {
		Thread.sleep(2000);
		try {
		logger.info("Step:>Waiting for Order Pageload Complete");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement panels = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector(".title.text-center"));
			}

		});
		assertNotNull(panels);
		}catch(Exception e) {
			logger.error("Error! Waiting Element Is Failed!");
		}
		return this;

	}
	public OrderPage click_onOrderNow() {
		try {
		Thread.sleep(2000);
		logger.info("Step>Clicking On Order Now");
		Thread.sleep(3000);
		List<WebElement> orders=driver.findElements(By.cssSelector(".wow.fadeIn.btn.btn-success.btn-block.animated"));
		orders.get(1).findElement(By.className("text-center")).click();
		}catch(Exception e) {
			logger.error("Error!!It Did not Click on Order Now");
		}
		return this;
		
	}
	
	
	
	
		

}

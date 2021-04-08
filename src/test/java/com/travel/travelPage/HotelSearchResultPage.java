package com.travel.travelPage;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.common.Logger;

public class HotelSearchResultPage {
	final static Logger logger = Logger.getLogger(HotelSearchResultPage.class);
	WebDriver driver;

	public HotelSearchResultPage wait_OnHotelSearchResultPageLoad() {
		try {
			logger.info("Step>Waiting for Hotel Search Result Page Load");
			Thread.sleep(3000);
			WebElement dynamicElem=null;
			dynamicElem = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".searchbox")));
			assertNotNull(dynamicElem);
		} catch (Exception e) {
			logger.error("Error! Waiting for Hotel Search Result Failed");
		}
		return this;

	}

}

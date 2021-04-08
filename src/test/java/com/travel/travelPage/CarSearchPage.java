package com.travel.travelPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class CarSearchPage extends BasePage {
	final static Logger logger = Logger.getLogger(CarSearchPage.class);

	public CarSearchPage wait_ForCarSearchLoading() {

		try {
			logger.info("Step>Waiting for Car Search Page");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchform")));

		} catch (Exception e) {
			logger.error("Error! Waiting for Car Search Failed");
		}
		return this;

	}

	public CarSearchPage click_onNextPage() {

		try {
			logger.info("Step>Click On Next Page");
			Thread.sleep(2000);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,750)", "");
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[5]/div[3]/div/div[7]/ul/li[4]/a")).click();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			logger.error("Error! It Did Not Click On Next Page");
		}
		return this;

	}
	
	public WebElement wait_onDetailBtn() {
		WebElement dynamicElem = null;
		try {
			logger.info("Step>Wait For Detail Btn");
			dynamicElem = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[5]/div[3]/div/table/tbody/tr[3]/td/div/div[2]/div/div[1]/a/button")));
		}catch(Exception e) {
			logger.error("Error! Waiting For Detail Btn Failed ");
		}
			
		return dynamicElem;
		
	}

	public CarSearchPage click_OnDetail() {

		try {
			logger.info("Step>Click On Car Detail");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement detailBtn=driver.findElement(By.xpath("html/body/div[5]/div[3]/div/table/tbody/tr[3]/td/div/div[2]/div/div[1]/a/button"));
			js.executeScript("arguments[0].click();",detailBtn );
		} catch (Exception e) {
			
		
			logger.error("Error! It Did Not Click On Car Detail");
		}
		return this;

	}

}

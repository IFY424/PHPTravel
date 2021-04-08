package com.travel.supplierPage;

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

public class SupplierAccountPage extends BasePage{
	final static Logger logger = Logger.getLogger(SupplierAccountPage.class);

	public SupplierAccountPage wait_UntilSupplierAccountPageComplete() throws Exception {
		logger.info("Step:>Waiting for Supplier Account Pageload Complete");
		try {
			Thread.sleep(2000);
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement search = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".xcrud-search-toggle.btn.btn-default"));
				}

			});
			assertNotNull(search);
		} catch (Exception e) {
			logger.error("Error!! Waiting Element Is Failed");
		}
		return this;

	}
	
	public SupplierAccountPage verify_SupplierLogin() {
		try {
			logger.info("Step>Vefiry Supplier Login Page");
			WebElement demoSupplier=driver.findElement(By.cssSelector(".user.text-center>span"));
			assertNotNull(demoSupplier);
		}catch(Exception e) {
			logger.error("Error! Verifying Supplier Login Failed");
		}
		return this;
		
	}
	
	public SupplierAccountPage click_OnHotel() {
		try {
			logger.info("Step>Click On Hotel");
			driver.findElement(By.id("social-sidebar-menu")).findElements(By.tagName("li")).get(0).findElement(By.tagName("a")).click();
		}catch(Exception e) {
			logger.error("Error! It Did Not Click On Hotel");
		}
		return this;
		
	}
	
	public SupplierAccountPage click_AddRoom() {
		try {
			logger.info("Step>Click On Add Room");
			driver.findElement(By.id("Hotels")).findElements(By.tagName("li")).get(2).click();
		}catch(Exception e) {
			logger.error("Error! It Did Not Click On Add Room");
		}
		return this;
		
	}
	public SupplierAccountPage click_Extras() {
		try {
			logger.info("Step>Click On Extras");
			driver.findElement(By.id("Hotels")).findElements(By.tagName("li")).get(4).click();
		}catch(Exception e) {
			logger.error("Error! It Did Not Click On Etras");
		}
		return this;
		
	}
}

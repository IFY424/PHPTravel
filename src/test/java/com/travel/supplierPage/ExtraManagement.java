package com.travel.supplierPage;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class ExtraManagement extends BasePage{
	final static Logger logger = Logger.getLogger(ExtraManagement.class);

	public ExtraManagement wait_UntilExtraMngPageComplete() throws Exception {
		logger.info("Step:>Waiting for Extra Management Pageload Complete");
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
	public  ExtraManagement click_OnAssign() {
		try {
			logger.info("Step>Click Assign");
			
			Thread.sleep(2000);
			driver.findElements(By.cssSelector(".xcrud-row.xcrud-row-1>td>a")).get(0).click();
		}catch(Exception e) {
			logger.error("Error! It Did Not Click Assign");
		}
		return this;
		
	}
	
	public  WebElement wait_ForUpdateBtnVisibility() {
		WebElement dynamicElem=null;
		try {
			logger.info("Step>Wait For Update Button Visibility");
			
		WebElement update=driver.findElement(By.id("assign3")).findElement(By.className("modal-content"))		
		.findElement(By.className("modal-footer"))	.findElement(By.cssSelector(".btn.btn-primary"));	

		dynamicElem= (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(update));
		}catch(Exception e) {
			logger.error("Error! Waiting For Update Button Visiblility Failed");
			assertTrue(false);
		}
		return dynamicElem;
		
	}
	

public  ExtraManagement delete_HotelList() {
	try {
		logger.info("Step>Delete Hotel List");
		
		Thread.sleep(1000);
	List<WebElement>hotelList=driver.findElement(By.id("s2id_autogen19")).findElement(By.className("select2-choices")).findElements(By.tagName("li"));
	for(int i=0;i<3;i++) {
		Thread.sleep(2000);
		hotelList.get(i).findElement(By.className("select2-search-choice-close")).click();
	
	}}catch(Exception e) {
		logger.error("Error! It Did Not Delete Hotel List");
	}
	return this;
	
}
	
public  ExtraManagement click_OnUpdate() {
	try {
		logger.info("Step>Click On Update ");
		Thread.sleep(1000);
		WebElement update=driver.findElement(By.id("assign3")).findElement(By.className("modal-content"))		
				.findElement(By.className("modal-footer"))	.findElement(By.cssSelector(".btn.btn-primary"));	
	update.click();
	
	}catch(Exception e) {
		logger.error("Error! It Did Not Click on Update");
	}
	return this;
	
}
public  ExtraManagement verify_HotelListAfterDelt() {
	try {
		logger.info("Step>Verify Hotel List After Deltetion ");
		Thread.sleep(1000);
		List<WebElement>hotelList=driver.findElement(By.id("s2id_autogen19")).findElement(By.className("select2-choices")).findElements(By.tagName("li"));
		if(hotelList.size()>7) {
			assertTrue(false);
		}
	
	}catch(Exception e) {
		logger.error("Error! Verifying Hotel List After Deltetion Failed");
	}
	return this;
	
}


}

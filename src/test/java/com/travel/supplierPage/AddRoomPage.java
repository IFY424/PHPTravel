package com.travel.supplierPage;

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
import org.testng.Assert;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class AddRoomPage extends BasePage{
	final static Logger logger = Logger.getLogger(AddRoomPage.class);

	public AddRoomPage wait_UntilAddRoomPageComplete() throws Exception {
		logger.info("Step:>Waiting for Add Room Pageload Complete");
		try {
			Thread.sleep(2000);
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement submit = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.id("add"));
				}

			});
			assertNotNull(submit);
		} catch (Exception e) {
			logger.error("Error!! Waiting Element Is Failed");
		}
		return this;

	}
	public AddRoomPage select_RoomType() {
		try {
			logger.info("Step>Select Room Type");
			Thread.sleep(1000);
			driver.findElement(By.id("s2id_autogen1")).findElement(By.className("select2-arrow")).click();
			List<WebElement>rooms=driver.findElement(By.id("select2-drop")).findElement(By.className("select2-results")).findElements(By.cssSelector(".select2-result-label"));
			 for(WebElement temp:rooms) {
				 if(temp.getText().contains("Two-Bedroom Apartment")){
					 temp.click();
					 break;
				 }
			 }
		}catch(Exception e) {
			logger.error("Error!It Did Not Select Room Type ");
		}
		return this;
		
	}
	
	public  AddRoomPage enter_Text() {
		try {
			logger.info("Step>Enter Text");
			Thread.sleep(1000);
			WebElement iframe=driver.findElement(By.id("cke_1_contents")).findElement(By.cssSelector(".cke_wysiwyg_frame.cke_reset"));
			driver.switchTo().frame(iframe);
			Thread.sleep(1000);
			driver.findElement(By.tagName("body")).sendKeys("This Room Is Good For Family Size Travel");
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
		}catch(Exception e) {
			logger.error("Error! It Did Not Enter Text");
		}
		return this;
		
	}
	public  AddRoomPage enter_Price() {
		try {
			logger.info("Step>Enter Price");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)", "");
			driver.findElement(By.name("basicprice")).sendKeys("100");
		}catch(Exception e) {
			logger.error("Error! It Did Not Enter Price");
		}
		return this;
		
	}
	
	public  AddRoomPage enter_Quantity() {
		try {
			logger.info("Step>Enter Price");
			
			driver.findElement(By.name("quantity")).sendKeys("5");
		}catch(Exception e) {
			logger.error("Error! It Did Not Enter Quanitity");
		}
		return this;
		
	}public  AddRoomPage enter_MiniumStay() {
		try {
			logger.info("Step>Enter Minium Stay");
			
			driver.findElement(By.name("minstay")).sendKeys("2");
		}catch(Exception e) {
			logger.error("Error! It Did Not Enter Minium Stay");
		}
		return this;
		
	}
		
	public  AddRoomPage click_OnSubmit() {
		try {
			logger.info("Step>Click Submit");
			
			Thread.sleep(2000);
			driver.findElement(By.id("add")).click();
		}catch(Exception e) {
			logger.error("Error! It Did Not Click Submit");
		}
		return this;
		
	}
	

	public  AddRoomPage verify_ErrorMassage() {
		try {
			logger.info("Step>Verify Error Massage");
			Thread.sleep(2000);
		WebElement alert=driver.findElement(By.cssSelector(".alert.alert-danger>p"));
			Assert.assertEquals(alert.getText(), "The Hotel Name field is required.");
		}catch(Exception e) {
			logger.error("Error!Verifying Error Massage Failed ");
		}
		return this;
		
	}

}

package com.travel.travelPage;

import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

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

public class ContactUsPage extends BasePage{
	final static Logger logger = Logger.getLogger(ContactUsPage.class);

	public ContactUsPage wait_UntilPageLoad() {
		try {
			logger.info("Step>Waiting For Contact Us Page Load");
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement submitBtn = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".btn.btn-primary.btn-block.btn-lg.go-right"));
				}

			});
			assertNotNull(submitBtn);
		} catch (Exception e) {
			logger.error("Error!Waiting For Contact Us Page Load Failed");
		}
		return this;

	}
	
	public ContactUsPage enter_name() {
		try {
			logger.info("Step>Enter Name");
			Thread.sleep(2000);
		   driver.findElement(By.name("contact_name")).sendKeys("John");
		} catch (Exception e) {
			logger.error("Error!It Did Not Enter Name ");
		}
		return this;

	}
	
	public ContactUsPage enter_Email() {
		try {
			logger.info("Step>Enter Email");
			Thread.sleep(1000);
		   driver.findElement(By.name("contact_email")).sendKeys("john123@gmail.com");
		} catch (Exception e) {
			logger.error("Error!It Did Not Enter Email ");
		}
		return this;

	}public ContactUsPage enter_Subject() {
		try {
			logger.info("Step>Enter Subject");
			Thread.sleep(1000);
		   driver.findElement(By.name("contact_subject")).sendKeys("Bug Issue");
		} catch (Exception e) {
			logger.error("Error!It Did Not Subject ");
		}
		return this;

	}
	public ContactUsPage enter_Message() {
		try {
			logger.info("Step>Enter Massege");
			Thread.sleep(1000);
		   driver.findElement(By.name("contact_message")).sendKeys("Hello, You have lot of Bugs in youe website, pls fix it as soon as possible");
		} catch (Exception e) {
			logger.error("Error!It Did Not Massege ");
		}
		return this;

	}
	
	public ContactUsPage click_OnSubmitBtn() {
		try {
			logger.info("Step>Click On Submit Button");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".btn.btn-primary.btn-block.btn-lg.go-right")).click();
		     
		} catch (Exception e) {
			logger.error("Error!It Did Not Click On Submit Button");
		}
		return this;

	}
	
	public WebElement verify_MessageSent() {
		WebElement dynamicElem=null;
		try {
			logger.info("Step>Verify Massage Sent");
			dynamicElem=(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert.alert-success")));
		} catch (Exception e) {
			logger.error("Error!Verifying Massage Sent Failed");
		}
		return dynamicElem;

	}

}

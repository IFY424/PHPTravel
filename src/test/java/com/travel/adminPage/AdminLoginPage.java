package com.travel.adminPage;

import static org.testng.Assert.assertNotNull;

import java.util.List;
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

public class AdminLoginPage extends BasePage {
	final static Logger logger = Logger.getLogger(AdminLoginPage.class);
	
	public AdminLoginPage wait_ForAdminLoginPageLoad() {
		try {
			logger.info("Step>Wait For Admin Login Page Load");
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement loginBtn = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector(".btn.btn-primary.btn-block.ladda-button.fadeIn.animated"));
			}

		});
		assertNotNull(loginBtn);
		
		}catch(Exception e) {
			logger.error("Error!Waiting For Page Load Failed");
		}
		
		
		return this;
	}
	
	

	public AdminLoginPage enter_AdminEmail() {
		logger.info("Step>Entering Admin Email");
		try {
		List<WebElement> loginPanels = driver.findElements(By.className("form-control"));
		for (WebElement temp : loginPanels) {
			if (temp.getAttribute("name").contains("email")) {
				
			temp.sendKeys("admin@phptravels.com");
			break;
		}
		}}catch(Exception e) {
			logger.error("Error!Entering Admin Email Is Failed");
			
		}
		return this;

	}

	public AdminLoginPage enter_AdminPassword() throws Exception {
		logger.info("Step>Entering Admin Password");
		try {
		Thread.sleep(2000);;
		List<WebElement> loginPanels = driver.findElements(By.className("form-control"));
		for (WebElement temp : loginPanels) {
			if (temp.getAttribute("name").contains("password")) {
				temp.sendKeys("demoadmin");
				break;
			}
		}}catch(Exception e ) {
			logger.error("Error!Entering Admin Password Is Failed");	
			
		}
		return this;
	}
	public AdminLoginPage enter_InvalidAdminEmail() {
		logger.info("Step>Entering Invalid Admin Email");
		try {
		List<WebElement> loginPanels = driver.findElements(By.className("form-control"));
		for (WebElement temp : loginPanels) {
			if (temp.getAttribute("name").contains("email")) {
				
			temp.sendKeys("admin123@phptravels.com");
			break;
		}
		}}catch(Exception e) {
			logger.error("Error!Entering Invalid Admin Email Is Failed");
			
		}
		return this;

	}

	public AdminLoginPage enter_InvalidAdminPassword() throws Exception {
		logger.info("Step>Entering Invalid Admin Password");
		try {
		Thread.sleep(2000);;
		List<WebElement> loginPanels = driver.findElements(By.className("form-control"));
		for (WebElement temp : loginPanels) {
			if (temp.getAttribute("name").contains("password")) {
				temp.sendKeys("demoadmin123");
				break;
			}
		}}catch(Exception e ) {
			logger.error("Error!Entering Invalid Admin Password Is Failed");	
			
		}
		return this;
	}

	public AdminLoginPage click_LoginBtn() throws Exception {
		logger.info("Step>Clicking Login Button");
		try {
	     Thread.sleep(3000);;
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-block.ladda-button.fadeIn.animated")).click();
		
		}catch(Exception e) {
			logger.error("Error!!Clicking Login Button Is Failed");
		}
			return this;
		}
	
	public AdminLoginPage verify_ErrorText() {
		try {
			logger.info("Step>Verify Error Text");
			Thread.sleep(3000);
			WebElement Error=driver.findElement(By.cssSelector(".alert.alert-danger.loading.wow.fadeIn.animated.animated"));
			assertNotNull(Error);
		}catch(Exception e) {
			logger.error("Error! Verifying Error Text Failed");
		}
		return this;
		
	}
	
	}



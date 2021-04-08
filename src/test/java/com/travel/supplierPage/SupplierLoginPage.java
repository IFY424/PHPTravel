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
import com.travel.adminPage.AdminLoginPage;

import jxl.common.Logger;

public class SupplierLoginPage extends BasePage{
final static Logger logger = Logger.getLogger(AdminLoginPage.class);
	
	public SupplierLoginPage wait_ForSupplierLoginPageLoad() {
		try {
			logger.info("Step>Wait For Supplier Login Page Load");
		
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
	public SupplierLoginPage enter_UserNameAndPassWord() {
		try {
			logger.info("Step>Enter User Name And PassWord");
			Thread.sleep(1000);
		   driver.findElement(By.name("email")).sendKeys("supplier@phptravels.com");
		   driver.findElement(By.name("password")).sendKeys("demosupplier");
		
		} catch (Exception e) {
			logger.error("Error!It Did Not Enter User Name And PassWord");
		}
		return this;

	}
	
	public SupplierLoginPage click_onLoginBtn() {
		try {
			logger.info("Step>Click on Login Button");
			Thread.sleep(2000);
		   driver.findElement(By.cssSelector(".btn.btn-primary.btn-block.ladda-button.fadeIn.animated")).click();
		}catch(Exception e) {
			logger.error("Error!It Did NOt Click on Login Button");
		}
		return this;

	}
	public SupplierLoginPage enter_InvalidUserNameAndPassWord() {
		try {
			logger.info("Step>Enter User Name And PassWord");
			Thread.sleep(1000);
			driver.findElement(By.name("email")).sendKeys("supplier123@phptravels.com");
			  driver.findElement(By.name("password")).sendKeys("demosupplier123");
			
		
		} catch (Exception e) {
			logger.error("Error!It Did Not Enter Invalid User Name And PassWord");
		}
		return this;

	}
	
	public SupplierLoginPage  verify_ErrorText() {
		try {
			logger.info("Step>Vefiry Error Text");
			Thread.sleep(3000);
			WebElement Error=driver.findElement(By.cssSelector(".alert.alert-danger.loading.wow.fadeIn.animated.animated"));
			assertNotNull(Error);
		}catch(Exception e) {
			logger.error("Error! Verifying Error Text Failed");
		}
		return this;
		
	}
	
	
	

}

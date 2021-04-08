package com.travel.travelPage;

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

public class UserLoginPage extends BasePage{
	final static Logger logger = Logger.getLogger(UserLoginPage.class);

	public UserLoginPage wait_UntilUserLoginPageComplete() throws Exception {
		logger.info("Step:>Waiting for User Login Pageload Complete");
		try {
			Thread.sleep(2000);
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement forgetPass = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".right>a"));
				}

			});
			assertNotNull(forgetPass);
		} catch (Exception e) {
			logger.error("Error!! Waiting Element Is Failed");
		}
		return this;

	}
	
	public UserLoginPage enter_UserNameAndPassWord() {
		try {
			logger.info("Step>Enter User Name And PassWord");
			Thread.sleep(1000);
		   driver.findElements(By.cssSelector(".form-control.padding-10")).get(0).sendKeys("user@phptravels.com");
		   driver.findElements(By.cssSelector(".form-control.padding-10")).get(1).sendKeys("demouser");
		
		} catch (Exception e) {
			logger.error("Error!It Did NotEnter User Name And PassWord");
		}
		return this;

	}
	
	public UserLoginPage click_onLoginBtn() {
		try {
			logger.info("Step>Click on Login Button");
			Thread.sleep(2000);
		   driver.findElement(By.cssSelector(".btn.btn-action.btn-block.loginbtn")).click();
		}catch(Exception e) {
			logger.error("Error!It Did NOt Click on Login Button");
		}
		return this;

	}
	public UserLoginPage enter_InvalidUserNameAndPassWord() {
		try {
			logger.info("Step>Enter User Name And PassWord");
			Thread.sleep(1000);
		   driver.findElements(By.cssSelector(".form-control.padding-10")).get(0).sendKeys("nana@gmail.com");
		   driver.findElements(By.cssSelector(".form-control.padding-10")).get(1).sendKeys("demouser");
		
		} catch (Exception e) {
			logger.error("Error!It Did NotEnter User Name And PassWord");
		}
		return this;

	}
	
	public UserLoginPage verify_ErrorText() {
		try {
			logger.info("Step>Vefiry Error Text");
			Thread.sleep(3000);
			WebElement Error=driver.findElement(By.cssSelector(".alert.alert-danger"));
			assertNotNull(Error);
		}catch(Exception e) {
			logger.error("Error! Verifying Error Text Failed");
		}
		return this;
		
	}
	
	
	
	

}

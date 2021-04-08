package com.travel.mainpage;

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

public class LoginPage extends BasePage {
	final static Logger logger = Logger.getLogger(LoginPage.class);

	public LoginPage wait_UntilLoginPageComplete() throws Exception {
		logger.info("Step:>Waiting for Login Pageload Complete");
		try {
			Thread.sleep(2000);
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement loginBtn = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.id("login"));
				}

			});
			assertNotNull(loginBtn);
		} catch (Exception e) {
			logger.error("Error!! Waiting Element Is Failed");
		}
		return this;

	}

	public LoginPage click_OnRegiser() {
		try {
			logger.info("Step>Click On Register");
			Thread.sleep(3000);
			driver.findElement(By.id("Secondary_Navbar-Account")).findElement(By.className("dropdown-toggle")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Secondary_Navbar-Account-Register")).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Click On Register");
		}
		return this;

	}

}

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

public class JohnAccountPage extends BasePage {
	final static Logger logger = Logger.getLogger(JohnAccountPage.class);

	public JohnAccountPage wait_UntilJohnPageComplete() throws Exception {
		logger.info("Step:>Waiting for John Pageload Complete");
		try {
			Thread.sleep(2000);
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement newSettlerIcon = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".newsletter-icon"));
				}

			});
			assertNotNull(newSettlerIcon);
		} catch (Exception e) {
			logger.error("Error!! Waiting Element Is Failed");
		}
		return this;

	}
	
	public JohnAccountPage verify_JohnLogin() {
		try {
			logger.info("Step>Vefiry John Login Page");
			WebElement helloJohn=driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[1]"));
			assertNotNull(helloJohn);
		}catch(Exception e) {
			logger.error("Error! Verifying John Login Failed");
		}
		return this;
		
	}
	
	
	
	
	
	
}

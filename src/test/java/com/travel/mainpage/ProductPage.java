package com.travel.mainpage;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class ProductPage extends BasePage {
	final static Logger logger=Logger.getLogger(ProductPage.class);

	public ProductPage switch_ToNewWindow() throws Exception {
		Set<String> windows = driver.getWindowHandles();
		String browserUrl = "https://phptravels.org/cart.php?a=confproduct&i=1";
		for (String window : windows) {
			Thread.sleep(2000);
			driver.switchTo().window(window);
			String currentURL = driver.getCurrentUrl();
			if (browserUrl.contains(currentURL)) {
				break;
			}

		}
		return this;

	}

	public ProductPage wait_forContinueBtnVisibility() {
		logger.info("Step>Waiting for Continue Btn Visibility");
		try {
			Thread.sleep(3000);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)", "");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-primary.btn-lg")));
		} catch (Exception e) {
			logger.error("Error!!Waiting for ContinueBtn Is Failed");
			assertTrue(false);
		}
		return this;
	}

	public ProductPage click_OnContinueBtn() {
		logger.info("Step>Clicking On Continue Btn");
		try {
			driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg")).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Click On Continue Btn");
		}

		return this;
	}

}

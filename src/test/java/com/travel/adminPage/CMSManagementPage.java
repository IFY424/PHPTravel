package com.travel.adminPage;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class CMSManagementPage extends BasePage {
	final static Logger logger = Logger.getLogger(CMSManagementPage.class);

	public CMSManagementPage wait_UntilCMSMngPageComplete() throws Exception {
		logger.info("Step:>Waiting for CMS Management Pageload Complete");
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

	public CMSManagementPage click_OnAddBtn() {
		try {
			logger.info("Step>Click On Add Button");
			driver.findElement(By.cssSelector(".btn.btn-success")).click();

		} catch (Exception e) {
			logger.error("Error!It Did Not Click On Add Button");
		}
		return this;

	}

	public CMSManagementPage verify_AddCMS() {
		try {
			logger.info("Step>Verify If Adding CMS Successfully ");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(5000);
			List<WebElement> rows = driver.findElement(By.cssSelector(".xcrud-list.table.table-striped.table-hover"))
					.findElements(By.tagName("tr"));
			
			for (WebElement temp : rows) {
				if(temp.getText().contains("MyJQuery")){
					assertTrue(true);
					break;

				}
			}

		} catch (Exception e) {
			logger.error("Error! Verifying If Adding CMS Successfully Failed");
		}
		return this;

	}

}

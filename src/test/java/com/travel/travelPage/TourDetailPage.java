package com.travel.travelPage;

import static org.testng.Assert.assertNotNull;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class TourDetailPage extends BasePage {
	final static Logger logger = Logger.getLogger(TourDetailPage.class);

	public TourDetailPage wait_PageLoading() {
		try {
			logger.info("Step>Waiting For Page Load");
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement reviews = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".panel-heading.go-text-right.panel-yellow"));
				}

			});
			assertNotNull(reviews);
		} catch (Exception e) {
			logger.error("Error!Waiting For Page Load Failed");
		}

		return this;

	}

	public TourDetailPage scroll_DownDiscription() {
		try {
			logger.info("Step>Scrolling Down Discription");
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			List<WebElement> elems = driver.findElements(By.cssSelector(".main-title.go-right"));
			for (WebElement temp : elems) {
				js.executeScript("arguments[0].scrollIntoView(true);", temp);
				Thread.sleep(2000);
				if (temp.getText().contains("Exclusions"))
					break;

			}

		} catch (Exception e) {
			logger.error("Error!Scrolling Down Discription Failed");
		}

		return this;

	}

	public TourDetailPage select_TourMember() {
		try {
			logger.info("Step>Select Tour Member");
			Thread.sleep(2000);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(2000);
			WebElement adults = driver.findElement(By.id("selectedAdults"));
			WebElement child = driver.findElement(By.id("selectedChild"));
			Select sel = new Select(adults);
			Select selOne = new Select(child);
			sel.selectByValue("2");
			selOne.selectByValue("1");
			assertNotNull(driver.findElement(By.cssSelector(".well.well-sm.text-center.strong")));

		} catch (Exception e) {
			logger.error("Error!Selecting Tour Member Failed");
		}

		return this;

	}

	public TourDetailPage click_BookNow() {
		try {
			logger.info("Step>Click Book NOw");
			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".btn.btn-block.btn-action.btn-lg")).click();

		} catch (Exception e) {
			logger.error("Error!It Did Not Click Book NOw");
		}

		return this;

	}

}

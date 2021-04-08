package com.travel.travelPage;

import static org.testng.Assert.assertNotNull;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class TourListingsPage extends BasePage {
	final static Logger logger = Logger.getLogger(TourListingsPage.class);

	public TourListingsPage wait_ForPageLoad() {
		try {
			logger.info("Step>Waiting for Tour Listings Page Load");
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

			WebElement searchBtn = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.id("searchform"));
				}
			});

			assertNotNull(searchBtn);

		} catch (Exception e) {
			logger.error("Error!Waiting For Page Load Failed");
		}
		return this;

	}

	public TourListingsPage enter_Location() {
		try {
			logger.info("Step>Enter Location Site");
			driver.findElement(By.cssSelector(".select2-chosen")).click();
			driver.findElement(By.cssSelector(".select2-input.select2-focused")).sendKeys("dubai");
			Thread.sleep(2000);
			driver.findElements(By.cssSelector(".select2-result-label")).get(3).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Enter Location");
		}
		return this;

	}

	public TourListingsPage enter_CheckIn() {
		try {
			logger.info("Step>Enter Tour Check In Data");
			driver.findElement(By.cssSelector(".form.input-lg.tchkin")).clear();
			driver.findElement(By.cssSelector(".form.input-lg.tchkin")).sendKeys("20/09/2017");
			driver.findElement(By.cssSelector(".form.input-lg.tchkin")).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Enter Check In Date");
		}
		return this;

	}

	public TourListingsPage enter_NumOfAdult() {
		try {
			logger.info("Step>Enter Number Of Adults");
			Thread.sleep(3000);
			WebElement adults = driver.findElement(By.id("adults"));
			Select sel = new Select(adults);
			sel.selectByValue("3");
		} catch (Exception e) {
			logger.error("Error!It Did Not Enter Number Of Adults");
		}
		return this;

	}

	public TourListingsPage Select_TourType() {

		try {
			logger.info("Step>Select Tour Type");
			Thread.sleep(2000);
			WebElement tourType = driver.findElement(By.id("tourtype"));
			Select sel = new Select(tourType);
			sel.selectByValue("199");

		} catch (Exception e) {
			logger.error("Error!It Did Not Select Tour Type");
		}
		return this;

	}

	public TourListingsPage click_SearchBtn() {
		try {
			logger.info("Step>Click Search Button");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".btn-warning.btn.btn-lg.btn-block")).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Click Search Button");
		}
		return this;

	}

	public TourListingsPage verify_searchResult() {
		try {
			logger.info("Step>Verify Search Result ");
			Thread.sleep(2000);
			List<WebElement> dubaiTours = driver.findElements(By.cssSelector(".labelleft2.rtl_title_home"));
			List<WebElement> dynamicElem = null;
			dynamicElem = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfAllElements(dubaiTours));
			assertNotNull(dynamicElem);
		} catch (Exception e) {
			logger.error("Error!Verifying Search Result Is Failed");
		}
		return this;

	}

	public TourListingsPage click_OnDetails() {
		try {
			logger.info("Step>Click on Detail Button");
			Thread.sleep(3000);
			driver.findElements(By.cssSelector(".mt15.btn.btn-action.btn-block")).get(0).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Click on Detail");
		}
		return this;

	}

	public TourListingsPage verify_Language() {
		try {
			logger.info("Step>Verify Website Language");
			WebElement language = driver.findElement(By.cssSelector(".pull-left.width_change"))
					.findElement(By.className("dropdown-toggle"));
			if (!language.getText().contains("English")) {

				driver.findElement(By.cssSelector(".pull-left.width_change")).findElement(By.className("dropdown-menu"))
						.findElements(By.tagName("li")).get(1).click();
			}
			Thread.sleep(5000);

		} catch (Exception e) {
			logger.error("Error!Verifing Website Language Is Failed");
		}
		return this;

	}

}

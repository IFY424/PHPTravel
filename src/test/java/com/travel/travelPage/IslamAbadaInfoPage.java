package com.travel.travelPage;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class IslamAbadaInfoPage extends BasePage {
	final static Logger logger = Logger.getLogger(IslamAbadaInfoPage.class);

	public IslamAbadaInfoPage wait_forIslamAbadPageLoad() {
		try {
			logger.info("Step>Waiting for IsalmAbad Hotel Page Load");

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement headers = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".main-title.go-right"));
				}

			});
			assertNotNull(headers);
		} catch (Exception e) {
			logger.error("Error!Waiting For Elements Failed");
		}
		return this;

	}

	public IslamAbadaInfoPage scroll_DownDiscription() throws Exception {
		try {
			logger.info("Step>Scrolling Down Discription");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			List<WebElement> elems = driver.findElements(By.cssSelector(".main-title.go-right"));
			for (WebElement temp : elems) {
				if (temp.getText().contains("Check in")) {
					Thread.sleep(2000);
					js.executeScript("arguments[0].scrollIntoView(true);", temp);
					break;

				}
			}

		} catch (Exception e) {
			logger.error("Error!It Did not Scroll Down");
		}
		return this;
	}

	public IslamAbadaInfoPage click_OnHotelImages() throws Exception {
		try {
			logger.info("Step>Clicking on Hotel Image One by One");
			WebElement nextIcon = driver.findElement(By.cssSelector(".fotorama__arr.fotorama__arr--next"));
			for (int i = 0; i < 16; i++) {
				Thread.sleep(1000);
				nextIcon.click();
				if (nextIcon.getAttribute("class").contains("disabled")) {
					break;
				}

			}

		} catch (Exception e) {
			logger.error("Error!It Did Not Click On Hotel Images");

		}
		return this;

	}

	public IslamAbadaInfoPage enter_CheckInDate() {
		try {
			Thread.sleep(2000);
			logger.info("Step>Enter Check-in Date");
			WebElement checkInField = driver.findElement(By.cssSelector(".form-control.dpd1rooms"));
			checkInField.clear();
			checkInField.sendKeys("09/05/2017");
		} catch (Exception e) {
			logger.error("Error!It Did Not Enter Check-in Date");
		}
		return this;

	}

	public IslamAbadaInfoPage enter_CheckoutDate() {
		try {
			logger.info("Step>Enter Check-out Date");
			Thread.sleep(2000);
			WebElement checkoutField = driver.findElement(By.cssSelector(".form-control.dpd2rooms"));
			checkoutField.clear();
			checkoutField.sendKeys("09/08/2017");
		} catch (Exception e) {
			logger.error("Error!It Did Not Enter Check-out Date");
		}
		return this;

	}

	public IslamAbadaInfoPage enter_NumOfAdults() {
		try {
			logger.info("Step>Enter Number Of Adults");
			WebElement adultsField = driver.findElement(By.id("adults"));
			Select dropdown = new Select(adultsField);
			dropdown.selectByVisibleText("2");
		} catch (Exception e) {
			logger.error("Error!It Did not Enter Number of Adults");
			assertTrue(false);
		}
		return this;

	}

	public IslamAbadaInfoPage enter_NumOfChild() {
		try {
			logger.info("Step>Enter Number Of childs");
			WebElement childField = driver.findElement(By.id("child"));
			Select dropdown = new Select(childField);
			dropdown.selectByVisibleText("1");
		} catch (Exception e) {
			logger.error("Error!It Did not Enter Number of Child");
			assertTrue(false);
		}
		return this;

	}

	public IslamAbadaInfoPage click_OnModify() {
		try {
			logger.info("Step>Click on Modify Button");
			driver.findElement(By.cssSelector(".btn.btn-block.btn-success-small.textupper")).click();
		} catch (Exception e) {
			logger.error("Error! It Did Not Click on Modify Button");
		}
		return this;

	}

	public WebElement Wait_ForModifyResult() {
		WebElement dynamicElem = null;
		try {
			logger.info("Step>Waiting for Modify Results");
			dynamicElem = (new WebDriverWait(driver, 30))
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rooms-update")));
		} catch (Exception e) {
			logger.error("Error! Waiting for Modify Button Results Failed");
			assertNotNull(false);
		}
		return dynamicElem;

	}

	public IslamAbadaInfoPage scroll_DownToExecutiveRoom() throws Exception {
		try {
			logger.info("Step>Scrolling Down to Executive Room");
			JavascriptExecutor je = (JavascriptExecutor) driver;
			List<WebElement> elems = driver.findElements(By.cssSelector(".mtb0.RTL.go-text-right"));
			for (WebElement temp : elems) {
				if (temp.getText().contains("Executive Two-Bedrooms Apartment")) {
					Thread.sleep(2000);
					je.executeScript("arguments[0].scrollIntoView(true);", temp);
					break;

				}
			}
		} catch (Exception e) {
			logger.error("Error! It Did not Scroll Down Exectutive Room");
		}
		return this;
	}

	public IslamAbadaInfoPage click_OnBookNowBtn() {
		try {
			logger.info("Step>Click on Book NOw Button");
			driver.findElements(By.cssSelector(".btn.btn-action.btn-block.chk")).get(2).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Click on Book Now Button");
		}
		return this;

	}

}

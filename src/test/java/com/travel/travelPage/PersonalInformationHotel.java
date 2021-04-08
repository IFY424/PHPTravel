package com.travel.travelPage;

import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
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

public class PersonalInformationHotel extends BasePage {
	final static Logger logger = Logger.getLogger(PersonalInformationHotel.class);

	public PersonalInformationHotel wait_ForPerInPageLoad() {
		try {
			logger.info("Step>waiting For Page Load Complete");
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement confirmBookingBtn = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".btn.btn-action.btn-lg.btn-block.completebook"));
				}

			});
			assertNotNull(confirmBookingBtn);
		} catch (Exception e) {
			logger.error("Error!Waiting For Page Load Failed");
		}
		return this;
	}

	public PersonalInformationHotel click_OnBookAsGuestBtn() {
		try {
			logger.info("Step>Clicking On Book As Guest Button");
			driver.findElement(By.id("guesttab")).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Click On Book As Guest Button");
		}
		return this;

	}

	public PersonalInformationHotel enter_PersonalInformation() {
		try {
			logger.info("Step>Enter Personal Information");
			List<WebElement> infoFields = driver.findElements(By.className("form-group "));
			List<String> fieldsTag = new ArrayList<String>();
			fieldsTag.add("First Name");
			fieldsTag.add("Last Name");
			fieldsTag.add("Email");
			fieldsTag.add("Confirm Email");
			fieldsTag.add("Mobile Number");
			fieldsTag.add("Address");
			fieldsTag.add("Additional Requests");
			List<String> personalInfos = new ArrayList<String>();
			personalInfos.add("Marry");
			personalInfos.add("John");
			personalInfos.add("Mary@gmail.com");
			personalInfos.add("Mary@gmail.com");
			personalInfos.add("312456789");
			personalInfos.add("312 Market Street");
			personalInfos.add("I need free wifi");

			for (WebElement temp : infoFields) {
				for (int i = 0; i < fieldsTag.size(); i++) {
					if (temp.getText().contains(fieldsTag.get(i))) {
						Thread.sleep(1000);
						temp.findElement(By.className("form-control")).sendKeys(personalInfos.get(i));
						break;

					}
				}
			}

		} catch (Exception e) {
			logger.error("Error!Entering Personal Information Failed");
		}
		return this;

	}

	public PersonalInformationHotel enter_country() throws Exception {
		try {
		logger.info("Step>Enter Country");
		driver.findElement(By.cssSelector(".select2-chosen")).click();
		WebElement countires = driver.findElement(By.className("select2-results"));
		List<WebElement> countryList = countires.findElements(By.tagName("li"));
		for (WebElement country : countryList) {
			//System.out.println(country.getText());
			if (country.getText().contains("Uganda")) {
				country.findElement(By.className("select2-result-label")).click();
				break;
			}
		}
		}catch(Exception e) {
			logger.error("Error! It Did not Enter Country");
		}
		return this;
	}

	
	public PersonalInformationHotel click_OnConfirmBtn() {
		try {
			logger.info("Step>Clicking On Confirmation Button");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".btn.btn-action.btn-lg.btn-block.completebook")).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Click On Confirmation Button");
		}
		return this;

	}

}

package com.travel.adminPage;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class BookingManagementPage extends BasePage {
	final static Logger logger = Logger.getLogger(BookingManagementPage.class);

	public BookingManagementPage wait_UntilBookingMngPageComplete() throws Exception {
		logger.info("Step:>Waiting for Booking Management Pageload Complete");
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

	public BookingManagementPage verify_Booking() {
		try {
			logger.info("Step>Verify Admin Booking");
			WebElement john = driver.findElement(
					By.xpath(".//*[@id='content']/div/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]"));
			Assert.assertEquals(john.getText(), "John");
			WebElement hotels = driver.findElement(
					By.xpath(".//*[@id='content']/div/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[6]"));
			Assert.assertEquals(hotels.getText(), "hotels");
		} catch (Exception e) {
			logger.error("Error! Verifying Admin Booking Failed");
		}
		return this;

	}

	public BookingManagementPage Click_OnEditInvoice() {
		try {
			logger.info("Step>Click On Edit Invoice");

			List<WebElement> rows = driver.findElement(By.cssSelector(".xcrud-list.table.table-striped.table-hover"))
					.findElements(By.cssSelector(".xcrud-row.xcrud-row-1"));
			for (WebElement temp : rows) {
				Thread.sleep(3000);
				if (temp.findElements(By.tagName("td")).get(2).getText().contains("47")
						&& temp.findElements(By.tagName("td")).get(10)
								.findElement(By.cssSelector(".btn.btn-xs.btn-info")).getText().contains("Unpaid")) {
					temp.findElements(By.tagName("td")).get(11)
							.findElement(By.cssSelector(".btn.btn-default.btn-xcrud.btn.btn-warning")).click();
					break;
				}

			}

		} catch (Exception e) {
			logger.error("It Did Not Click On Edit Invoice");
		}
		return this;

	}

	public BookingManagementPage verify_UpdateBooking() {
		try {
			logger.info("Step>Verify Update Booking");
			List<WebElement> rows = driver.findElement(By.cssSelector(".xcrud-list.table.table-striped.table-hover"))
					.findElements(By.cssSelector(".xcrud-row.xcrud-row-1"));
			for (WebElement temp : rows) {
				Thread.sleep(1000);
				if (temp.findElements(By.tagName("td")).get(2).getText().contains("47")) {
					Assert.assertEquals(driver.findElement(By.xpath(
							".//*[@id='content']/div/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td[11]/span"))
							.getText(), "Paid");
					break;

				}
			}
		} catch (Exception e) {
			logger.error("Error! Verifying Update Booking Failed");
		}
		return this;

	}
	
	
	
	
	

	public BookingManagementPage download_File() throws IOException, InterruptedException {
		// Click on Download Text File link to download file.
		driver.findElements(By.cssSelector(".btn.btn-default.xcrud-in-new-window.xcrud-action")).get(1).click();
		// Execute Script To Download File.exe file to run AutoIt script. File location
		// = E:\\AutoIT\\
		Runtime.getRuntime().exec("C:\\Users\\nayila\\Documents\\DownloadFile.exe");
		Thread.sleep(3000);

		return this;

	}

}

package com.travel.adminPage;

import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class AdminAccountPage extends BasePage {
final static Logger logger = Logger.getLogger(AdminAccountPage.class);

		public AdminAccountPage wait_UntilAdminAccountPageComplete() throws Exception {
			logger.info("Step:>Waiting for Admin Account Pageload Complete");
			try {
				Thread.sleep(2000);
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
						.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				WebElement resetChart = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.cssSelector(".pull-right.btn.btn-xs.btn-danger.resetChart"));
					}

				});
				assertNotNull(resetChart);
			} catch (Exception e) {
				logger.error("Error!! Waiting Element Is Failed");
			}
			return this;

		}
		
		public AdminAccountPage verify_AdminLogin() {
			try {
				logger.info("Step>Vefiry Admin Login Page");
				WebElement superAdmin=driver.findElement(By.cssSelector(".user.text-center>span"));
				assertNotNull(superAdmin);
			}catch(Exception e) {
				logger.error("Error! Verifying Admin Login Failed");
			}
			return this;
			
		}
		
		
		public AdminAccountPage click_OnQuickBooking() {
			try {
				logger.info("Step>Click On Quick Booking");
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".btn.btn-danger.btn-block")).click();
			}catch(Exception e) {
				logger.error("Error! It Did Not Click On Quick Booking");
			}
			return this;
			
		}
		public AdminAccountPage select_TaxAndService() {
			try {
				logger.info("Step>Select On Tax And Service");
				Thread.sleep(1000);
				WebElement tax=driver.findElement(By.id("apply"));
				Select sel=new Select(tax);
				sel.selectByValue("yes");
				Thread.sleep(1000);
				WebElement service=driver.findElement(By.id("servicetype"));
				Select selOne=new Select(service);
				selOne.selectByValue("Hotels");
			
			}catch(Exception e) {
				logger.error("Error! It Did Not Select On Tax And Service");
			}
			return this;
			
		}
		public AdminAccountPage click_OnNext() {
			try {
				logger.info("Step>Click On Next");
				Thread.sleep(2000);
				driver.findElement(By.id("quickbook")).findElement(By.className("modal-footer")).findElement(By.cssSelector(".btn.btn-primary")).click();
			}catch(Exception e) {
				logger.error("Error! It Did Not Click On Next");
			}
			return this;
			
		}
		
		public AdminAccountPage click_OnBookingsBtn() {
			try {
				logger.info("Step>Click On Bookings");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-block")).click();
			}catch(Exception e) {
				logger.error("Error! It Did Not Click On Next");
			}
			return this;
			
		}
		
		public AdminAccountPage click_OnCMSBtn() {
			try {
				logger.info("Step>Click On CMS Button");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-info.btn-block")).click();
			}catch(Exception e) {
				logger.error("Error! It Did Not Click On CMSPages Button");
			}
			return this;
			
		}
		public AdminAccountPage click_OnBlogBtn() {
			try {
				logger.info("Step>Click On Blog Button");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-success.btn-block")).click();
			}catch(Exception e) {
				logger.error("Error! It Did Not Click On Blog Button");
			}
			return this;
			
		}
		
}

package com.selenium.Nayilalibrary;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BasePage {
	final static Logger logger = Logger.getLogger(BasePage.class);
	// it has to be static, child class will have to refer to same browser
	public static WebDriver driver;
	
		@BeforeTest
		public void setup() {
			try {
				System.setProperty("webdriver.chrome.driver", "/Users/husenjanemet/Desktop/IT class/Nayila Project/PhpTravel/src/test/resources/chromedriver");
				driver = new ChromeDriver();// this line open webbroser
				logger.info("chrome driver is starting");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();// maximize the browser window
				// below setting page load time from 0s up to 30s max
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			} catch (Exception e) {
				logger.error(e);
				assertTrue(false);
			}
		
		}
		
		@AfterTest
		public void tearDown() throws Exception {
			Thread.sleep(4 * 1000);
			driver.close();// close the current browser
			driver.quit();// close the driver object

		}

	}

	

	

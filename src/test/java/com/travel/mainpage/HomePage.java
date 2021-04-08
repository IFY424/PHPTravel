package com.travel.mainpage;

import static org.testng.Assert.assertNotNull;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class HomePage extends BasePage {
	final static Logger logger = Logger.getLogger(HomePage.class);
	private String HomePageUrl = "http://phptravels.com/demo/";
	// private WebDriver driver;

	public HomePage goto_PhpTravelSite() {
		logger.info("Step:> Go to PhpTravel Demo Main Page");
		try {
			driver.get(HomePageUrl);

			String pageTitle = driver.getTitle();
			System.out.println("actual page title is " + pageTitle);
			String expectedTitle = "Demo Script Test drive - PHPTRAVELS";
			Assert.assertEquals(pageTitle, expectedTitle);
			//return this;
		} catch (Exception e) {
			logger.error("Error!! It Did Not Go To Main Site!!");
		}
		return this;

	}

	public HomePage click_OnDemoButton() {
		logger.info("Step:>Clicking On Demo link");
		try {
			List<WebElement> topLinks = driver.findElement(By.id("main-menu")).findElements(By.className("lvl-1"));
			for (WebElement temp : topLinks) {
				if (temp.getText().contains("Demo")) {
					temp.click();
					break;
				}
			}
		} catch (Exception e) {
			logger.error("Error!!It Did Not Click on Demo Link");
		}
		return this;
	}

	public HomePage waitUntilPageLoadComplete() {
		logger.info("Step:>Waiting For Pageload Complete");
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement title = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".brand"));
				}

			});
			assertNotNull(title);
		} catch (Exception e) {
			logger.error("Error! Waitting Element Is Failed");
		}
		return this;

	}

	public HomePage click_OnOrderLink() {
		logger.info("Step:>Clicking On Order Link");
		try {

			List<WebElement> topLinks = driver.findElement(By.id("main-menu")).findElements(By.className("lvl-1"));
			for (WebElement temp : topLinks) {
				if (temp.getText().contains("Order")) {
					temp.click();
					break;
				}
			}
		} catch (Exception e) {
			logger.error("Error!! It Did not Click On Order link ");
		}
		return this;
	}

	public HomePage click_OnProductLink() {
		logger.info("Step:>Clicking On Product Link");
		try {
			List<WebElement> topLinks = driver.findElement(By.id("main-menu")).findElements(By.className("lvl-1"));
			for (WebElement temp : topLinks) {
				if (temp.getText().contains("Product")) {
					temp.click();
					break;
				}
			}
		} catch (Exception e) {
			logger.error("Error!! It Did not Click On Product link ");
		}
		return this;

	}

	public HomePage count_onDropDownElem() {
		logger.info("Step:>Counting Of Number of Dropdown Element in Product Link.");
		try {
			List<WebElement> dropDownElemsOfPro = driver.findElement(By.cssSelector(".nav.reset"))
					.findElements(By.tagName("li"));
			for (WebElement temp : dropDownElemsOfPro) {
				if (temp.getText().contains("Product")) {
					List<WebElement> dropDownList = temp.findElement(By.cssSelector(".menu.reset"))
							.findElements(By.tagName("li"));
					// System.out.println(dropDownList.size());
					if (dropDownList.size() == 10) {
						Assert.assertTrue(true);
						logger.info("Product Link Has 10 Elements!!!");
						break;

					} else {
						logger.info("Dropdown List Size Are Not Equal to 10!!");
						Assert.assertFalse(true);
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error! Counting Number Is Not Correct!");
		}
		return this;

	}

	public HomePage click_OnServicesLink() {
		logger.info("Step:>Clicking On Services Link");
		try {
			List<WebElement> topLinks = driver.findElement(By.id("main-menu")).findElements(By.className("lvl-1"));
			for (WebElement temp : topLinks) {
				if (temp.getText().contains("Services")) {
					temp.click();
					break;
				}
			}
		} catch (Exception e) {
			logger.error("Error!! It Did not Click On Service link ");
		}
		return this;
	}

	public HomePage count_onDropDownElemOfSer() {
		logger.info("Step:>Counting Of Number of Dropdown Element in Services Link.");
		try {
			List<WebElement> dropDownElemsOfSer = driver.findElement(By.cssSelector(".nav.reset"))
					.findElements(By.tagName("li"));
			for (WebElement temp : dropDownElemsOfSer) {
				if (temp.getText().contains("Services")) {
					List<WebElement> dropDownList = temp.findElement(By.cssSelector(".menu.reset"))
							.findElements(By.tagName("li"));
					if (dropDownList.size() == 6) {
						Assert.assertTrue(true);
						logger.info("Services Link Has 6 Elements!!!");
						break;
					} else {
						logger.info("Services Dropdown List Size Are Not Equal to 6!!");
						Assert.assertFalse(true);
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error!Counting Number is not Correct!");
		}
		return this;

	}

	public HomePage click_OnCompanyLink() {
		logger.info("Step:>Clicking On Company Link");
		try {
			List<WebElement> topLinks = driver.findElement(By.id("main-menu")).findElements(By.className("lvl-1"));
			for (WebElement temp : topLinks) {
				if (temp.getText().contains("Company")) {
					temp.click();
					break;
				}
			}
		} catch (Exception e) {
			logger.error("Error!It Did not Click On Company Link");
		}
		return this;

	}

	public HomePage count_onDropDownElemofCom() {
		logger.info("Step:>Counting Of Number of Dropdown Element Company Link.");
		try {

			List<WebElement> dropDownElemsOfCom = driver.findElement(By.cssSelector(".nav.reset"))
					.findElements(By.tagName("li"));
			for (WebElement temp : dropDownElemsOfCom) {
				if (temp.getText().contains("Company")) {
					List<WebElement> dropDownList = temp.findElement(By.cssSelector(".menu.reset"))
							.findElements(By.tagName("li"));
					if (dropDownList.size() == 10) {
						Assert.assertTrue(true);
						logger.info("Company Link Has 10 Elements!!!");
						break;
					} else {
						logger.info("Company Dropdown List Size Are Not Equal to 10!!");
						Assert.assertFalse(true);
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error!! Counting Number Is Not Correct!");
		}

		return this;

	}

	public HomePage click_OnAboutUsLink() {
		logger.info("Step:>Clicking On About Us in Company Link");
		try {
			List<WebElement> dropDownElemsOfCom = driver.findElement(By.cssSelector(".nav.reset"))
					.findElements(By.tagName("li"));
			for (WebElement temp : dropDownElemsOfCom) {
				if (temp.getText().contains("Company")) {
					List<WebElement> companyMenu = temp.findElement(By.cssSelector(".menu.reset"))
							.findElements(By.tagName("li"));
					for (WebElement tempOne : companyMenu) {
						if (tempOne.getText().contains("About Us")) {
							tempOne.findElement(By.tagName("a")).click();
							break;
						}
					}
					break;
				}
			}
		} catch (Exception e) {
			logger.error("Error!!It Did Not Click On About US Link");
		}

		return this;

	}

	public HomePage wait_untilAboutPageComplete() {
		logger.info("Step:>Waiting for About Us Pageload Complete");
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement aboutUsHeader = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".cw.wow.fadeIn.title.animated.animated"));
				}

			});
			assertNotNull(aboutUsHeader);
		} catch (Exception e) {
			logger.error("Error! Waitting Element Is Failed");
		}
		return this;

	}

	public HomePage click_OnLoginLink() {
		logger.info("Step:>Clicking On Login Link");
		try {
			driver.findElement(By.cssSelector(".login")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			logger.error("Error!It Did Not Click On Login Link");
		}
		return this;

	}
    public HomePage switch_OnLoginPage() {
    	try {
    		logger.info("Step>Switch On Login Page Window");
    		String browserURL="https://phptravels.org/clientarea.php";
    		Set<String> windows=driver.getWindowHandles();
    		for(String window:windows) {
    			Thread.sleep(1000);
    			driver.switchTo().window(window);
    			String CurrentURL=driver.getCurrentUrl();
    			if(browserURL.contains(CurrentURL)){
    				break;
    			}
    			
    		}		
    		
    	}catch(Exception e) {
    		logger.error("Error!It Did Not Switch On Login Page");
    	}
		return this;
    	
    }
	

	public HomePage click_OnHomepageFrontEndLink() throws Exception {
		try {
			logger.info("Step>Click On Home Page Front End Link");
			driver.findElements(By.cssSelector(".btn.btn-primary.btn-lg.btn-block")).get(0).click();
			Set<String> windows = driver.getWindowHandles();
			String browserUrl = "http://www.phptravels.net/";
			for (String window : windows) {
				Thread.sleep(2000);
				driver.switchTo().window(window);
				String currentURL = driver.getCurrentUrl();
				if (browserUrl.contains(currentURL)) {
					break;
				}

			}
			Thread.sleep(2000);
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement rowIcons = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".features.hidden-sm.hidden-xs"));
				}

			});
			assertNotNull(rowIcons);
		} catch (Exception e) {
			logger.error("Error!It Did Not Click On Home Page Front End Link");
		}
		return this;

	}

	public HomePage click_OnAdministratorBackEndLink() throws Exception {
		try {
		logger.info("Step>Click On Admin Back End Link");
		Thread.sleep(1000);
		driver.findElements(By.cssSelector(".btn.btn-primary.btn-lg.btn-block")).get(1).click();
		Thread.sleep(1000);
		Set<String> windows = driver.getWindowHandles();
		String browserUrl = "http://www.phptravels.net/admin";
		for (String window : windows) {
			Thread.sleep(1000);
			driver.switchTo().window(window);
			String currentURL = driver.getCurrentUrl();
			if (browserUrl.contains(currentURL)) {
				break;
			}

		}
	}catch(Exception e) {
		logger.error("Error!It Did Not Click On Admin Back End Link");
	}
		return this;
	}

	public HomePage click_OnSupplierBackEndLink() throws Exception {
		try {
		logger.info("Step>Click On Supplier Back End Link");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(1000);
		driver.findElements(By.cssSelector(".btn.btn-primary.btn-lg.btn-block")).get(2).click();
		Thread.sleep(1000);
		Set<String> windows = driver.getWindowHandles();
		String browserUrl = "http://www.phptravels.net/supplier";
		for (String window : windows) {
			Thread.sleep(1000);
			driver.switchTo().window(window);
			String currentURL = driver.getCurrentUrl();
			if (browserUrl.contains(currentURL)) {
				break;
			}

		}
	}catch(Exception e) {
		logger.error("Error!It Did Not Click On Supplier Back End Link");
	}
		return this;
	}

	
	
	
	
	
	
	
}

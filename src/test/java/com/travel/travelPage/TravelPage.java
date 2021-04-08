package com.travel.travelPage;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class TravelPage extends BasePage {
	final static Logger logger = Logger.getLogger(TravelPage.class);

	public TravelPage enter_HotelName() {
		try {
			logger.info("Step>Enter Hotel name");
			Thread.sleep(3000);
			List<WebElement> nameList = driver.findElement(By.id("s2id_autogen3"))
					.findElements(By.className("select2-chosen"));
			for (WebElement temp : nameList) {
				if (temp.getText().contains("Search by Hotel or City Name")) {
					temp.click();
					break;
				}
			}
			driver.findElement(By.cssSelector(".select2-input.select2-focused")).sendKeys("dau");
			List<WebElement> locationList = driver.findElements(By.cssSelector(".select2-result-label"));
			for (WebElement tempOne : locationList) {
				System.out.println(tempOne.getText());
				if (tempOne.getText().contains("phin, Canada")) {
					tempOne.click();
					break;
				}
			}

		} catch (Exception e) {
			logger.error("Error!Can Not Enter Hotel Name");
		}
		return this;

	}

	public TravelPage enter_CheckinDate() {
		try {
			Thread.sleep(2000);
			;
			logger.info("Step>Enter Check-in Date");
			WebElement checkInField = driver.findElement(By.cssSelector(".form.input-lg.dpd1"));
			checkInField.clear();
			checkInField.sendKeys("09/05/2017");
		} catch (Exception e) {
			logger.error("Error!It Did Not Enter Check-in Date");
		}
		return this;
	}

	public TravelPage enter_CheckOutDate() {
		try {
			logger.info("Step>Enter Check-out Date");
			Thread.sleep(2000);
			WebElement checkoutField = driver.findElement(By.cssSelector(".form.input-lg.dpd2"));
			checkoutField.clear();
			checkoutField.sendKeys("09/08/2017");
		} catch (Exception e) {
			logger.error("Error!It Did Not Enter Check-out Date");
		}
		return this;

	}

	public TravelPage enter_NumberAdults() {
		try {
			logger.info("Step>Enter Number Of Adults");
			WebElement adultsField = driver.findElement(By.id("adults"));
			Select dropdown = new Select(adultsField);
			dropdown.selectByVisibleText("4");
		} catch (Exception e) {
			logger.error("Error!It Did not Enter Number of Adults");
			assertTrue(false);
		}
		return this;
	}

	public TravelPage enter_numberChilds() {
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

	public TravelPage click_OnSearchButton() {
		try {
			logger.info("Step>Click on Search Button");
			driver.findElement(By.id("HOTELS")).findElement(By.cssSelector(".col-md-2.col-xs-12.xl"))
					.findElement(By.cssSelector(".btn-warning.btn.btn-lg.btn-block")).click();

		} catch (Exception e) {
			logger.error("Error!It Did Not Click On Search Button");

		}
		return this;

	}

	public TravelPage click_OnHotel() {
		try {
			logger.info("Step>Clicking on Hotel");
			List<WebElement> imageList = driver.findElements(By.className("strong"));
			for (WebElement temp : imageList) {
				if (temp.getText().contains("Islamabad Marriott Hotel")) {
					temp.click();
					break;
				}
			}
		} catch (Exception e) {
			logger.error("Error!It Did Not Click On Hotel");
		}
		return this;

	}

	public TravelPage scroll_DownWindow() throws Exception {
		try {
			logger.info("Step>Scrolling Down the Window Element");
			Thread.sleep(3000);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)", "");
		} catch (Exception e) {
			logger.error("Error!It Did Not Scroll Down The Window");
		}
		return this;

	}

	public TravelPage click_OnFlightIcon() {
		try {
			logger.info("Step>Clicking on Flight Icon");

			WebElement icon = driver.findElement(By.cssSelector(".nav.nav-tabs.RTL.tab_styling"));
			List<WebElement> iconList = icon.findElements(By.tagName("li"));
			for (WebElement temp : iconList) {
				System.out.println(temp.getText());
				if (temp.getText().contains("FLIGHTS")) {
					temp.click();
					break;
				}
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.error("Error! It Did Not Click On Flight Icon");
		}
		return this;

	}

	public TravelPage enter_Origin() {
		try {
			logger.info("Step>Enter Flight Origin");
			driver.findElement(By.id("flights-origin-prepop-e823caac1a24a0172d4ee792e5dad7d9")).sendKeys("PHL");
			driver.findElement(By.cssSelector(".mewtwo-autocomplete-list-item-info__name")).click();
		} catch (Exception e) {
			logger.error("Error! It Did Not Enter Origin Flight");
		}
		return this;

	}

	public TravelPage enter_Destination() {
		try {
			logger.info("Step>Enter Destination");
			Thread.sleep(2000);
			driver.findElement(By.id("flights-destination-prepop-e823caac1a24a0172d4ee792e5dad7d9"))
					.sendKeys("Honolulu");
			driver.findElement(By.cssSelector(".mewtwo-autocomplete-list-item-info__right_block")).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Enter Destination");
		}
		return this;

	}

	public TravelPage enter_DepartReturnDate() {
		try {
			logger.info("Step>Enter Depart Date");
			Thread.sleep(2000);
			driver.findElement(By.id("flights-dates-depart-prepop-e823caac1a24a0172d4ee792e5dad7d9")).clear();

			driver.findElement(By.id("mewtwo-datepicker-2017-9-12")).click();
			logger.info("Step>Enter Return Date");
			Thread.sleep(2000);
			driver.findElement(By.id("flights-dates-return-prepop-e823caac1a24a0172d4ee792e5dad7d9")).clear();
			driver.findElement(By.id("mewtwo-datepicker-2017-9-21")).click();
		} catch (Exception e) {
			logger.error("Error! It Did not Enter Depart Or Return Date");
		}
		return this;

	}

	public TravelPage enter_NumberOfPeople() {
		try {
			logger.info("Step>Enter Number of People");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".mewtwo-flights-trip_class-wrapper")).click();
			driver.findElement(By.xpath("html/body/div[18]/div/div/div[1]/div[2]/span[3]")).click();
			driver.findElement(By.xpath("html/body/div[18]/div/div/div[2]/div[2]/span[3]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[18]/div/div/div[4]/label/span[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".mewtwo-passengers-ready__button.mewtwo-popup_apply_button--desktop"))
					.click();
		} catch (Exception e) {
			logger.error("Error! It Did Not Enter Number of People");
		}
		return this;

	}

	public TravelPage click_OnSearch() {
		try {
			logger.info("Step>Click On Search Button");
			Thread.sleep(3000);
			driver.findElement(By.className("mewtwo-flights-submit_button")).click();
		} catch (Exception e) {
			logger.error("Error! It Did Not Click On Search Button");
		}
		return this;

	}

	public TravelPage switch_ToFlightResultWindow() throws Exception {
		try {
			logger.info("Step>Switch To New Window");
			Set<String> windows = driver.getWindowHandles();
			String browserUrl = "http://flights.phptravels.net/flights/PHL1209HNL2109210";
			for (String window : windows) {
				Thread.sleep(2000);
				driver.switchTo().window(window);
				String currentURL = driver.getCurrentUrl();
				if (browserUrl.contains(currentURL)) {
					break;
				}

			}
		} catch (Exception e) {
			logger.error("Error!Switch To New Window Failed");
		}
		return this;

	}

	public TravelPage click_OnTourOption() {
		try {
			logger.info("Step>Click On Tour Option");
			driver.findElement(By.cssSelector(".nav.navbar-nav.navbar-left.go-right")).findElements(By.tagName("li"))
					.get(3).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Click Tour Option");
		}
		return this;

	}

	public TravelPage click_OnCarOption() {
		try {
			logger.info("Step>Click On Car Option");
			driver.findElement(By.cssSelector(".nav.navbar-nav.navbar-left.go-right")).findElements(By.tagName("li"))
					.get(7).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Click Car Option");
		}
		return this;

	}

	public TravelPage click_OnContactUsOption() {
		try {
			logger.info("Step>Click On Contact US Option");
			driver.findElement(By.cssSelector(".nav.navbar-nav.navbar-left.go-right")).findElements(By.tagName("li"))
					.get(6).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Click On Contact Us Option");
		}
		return this;

	}

	public TravelPage verify_LanguageBtn() {
		try {
			logger.info("Step>Verify Website Language Function");
			// driver.findElements(By.cssSelector(".navbar-collapse.collapse")).get(0).findElements(By.tagName("li")).get(1).click();

			ArrayList<String> textList = new ArrayList<>();
			textList.add("Mais de 4,30,000 listas disponíveis");
			textList.add("Best locations and prices");
			textList.add("Більш 4,30,000 пропозиції про нерухомість");
			textList.add("Более 4,30,000 предложения о недвижимости");
			textList.add("En iyi yerler ve fiyatlar");
			textList.add("Lebih dari 4,30,000 daftar yang tersedia");
			textList.add("Over 4,30,000 listings available");
			textList.add("Plus de 4,30,000 annonces disponibles");
			textList.add("Oltre 4,30,000 annunci disponibili");
			textList.add("أكثر من 4،30،000 القوائم المتاحة");
			textList.add("המיקומים ומחירים הטובים ביותר");
			int i = 0;
			int j = 0;
			List<WebElement> languageList = driver.findElements(By.cssSelector(".navbar-collapse.collapse")).get(0)
					.findElements(By.tagName("li")).get(1).findElements(By.tagName("li"));
			while (i < languageList.size() && j < textList.size()) {

				driver.findElements(By.cssSelector(".navbar-collapse.collapse")).get(0).findElements(By.tagName("li"))
						.get(1).click();
				Thread.sleep(3000);
				List<WebElement> languageListOne = driver.findElements(By.cssSelector(".navbar-collapse.collapse"))
						.get(0).findElements(By.tagName("li")).get(1).findElements(By.tagName("li"));
				Thread.sleep(2000);
				languageListOne.get(i).click();
				WebElement language = driver.findElements(By.cssSelector(".col-md-8>h4")).get(0);
				ArrayList<String> textListOne = new ArrayList<>();
				textListOne.add("Mais de 4,30,000 listas disponíveis");
				textListOne.add("Best locations and prices");
				textListOne.add("Більш 4,30,000 пропозиції про нерухомість");
				textListOne.add("Более 4,30,000 предложения о недвижимости");
				textListOne.add("En iyi yerler ve fiyatlar");
				textListOne.add("Lebih dari 4,30,000 daftar yang tersedia");
				textListOne.add("Over 4,30,000 listings available");
				textListOne.add("Plus de 4,30,000 annonces disponibles");
				textListOne.add("Oltre 4,30,000 annunci disponibili");
				textListOne.add("أكثر من 4،30،000 القوائم المتاحة");
				textListOne.add("המיקומים ומחירים הטובים ביותר");
				Thread.sleep(3000);
				Boolean dynamicElem = (new WebDriverWait(driver, 30))
						.until(ExpectedConditions.textToBePresentInElement(language, textListOne.get(j)));
				assertTrue(dynamicElem);
				logger.info("each Language is Showing up");
				i++;
				j++;

			}

		} catch (Exception e) {
			logger.error("Error!Verifing Website Language Function Is Failed");
		}
		return this;
	}
	
	public TravelPage click_OnMyAccountLogin() {
		try {
			logger.info("Step>Click On My Account");
			Thread.sleep(1000);
			driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/ul/li[2]/a")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/ul/li[2]/ul/li[1]/a")).click();
		} catch (Exception e) {
			logger.error("Error!It Did Not Click My Account");
		}
		return this;

	}
	
	
	
	
	
	
	
	
}

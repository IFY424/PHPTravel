package com.travel.tests;

import org.testng.annotations.Test;

import com.selenium.Nayilalibrary.BasePage;
import com.travel.mainpage.CheckOutPage;
import com.travel.mainpage.HomePage;
import com.travel.mainpage.InvoicePage;
import com.travel.mainpage.LoginPage;
import com.travel.mainpage.OrderPage;
import com.travel.mainpage.ProductPage;
import com.travel.mainpage.RegisterPage;
import com.travel.mainpage.ShoppingCartPage;

import jxl.common.Logger;

public class HomePageFunctionalityTest extends BasePage{
	final static Logger logger=Logger.getLogger(HomePageFunctionalityTest.class);
	HomePage myHomePage=new HomePage();
	OrderPage myOrderPage=new OrderPage();
	ProductPage myProductPage=new ProductPage();
	ShoppingCartPage myShoppingCartPage=new ShoppingCartPage();
	CheckOutPage myCheckOutPage=new CheckOutPage();
	InvoicePage myInvoicePage=new InvoicePage();
	LoginPage myLoginPage=new LoginPage();
	RegisterPage myRegisterPage=new RegisterPage();
	
	@Test(enabled=false)
	public void accessingHomePage() throws Exception {
	logger.info("Test Case 1.1 Is Starting!");
     myHomePage.goto_PhpTravelSite();
     logger.info("Test Case 1.1 End!");
	}
	
	@Test(enabled=false)
      public void verifyDemoLink() {
		logger.info("Test Case 1.2 Is Starting!");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnDemoButton();
		myHomePage.waitUntilPageLoadComplete();
	    logger.info("Test Case 1.2 End!");} 
	
	@Test(enabled=false)
	public void verifyOrderFunctionality() throws Exception {
		logger.info("Test Case 1.3 Is Starting!");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnOrderLink();
		myOrderPage.waitUntilOrderPageComplete();
		myOrderPage.click_onOrderNow();
		myProductPage.switch_ToNewWindow();
		myProductPage.wait_forContinueBtnVisibility();
		myProductPage.click_OnContinueBtn();
		myShoppingCartPage.wait_ForPageLoadComplete();
		myShoppingCartPage.click_onCheckOutBtn();
		myCheckOutPage.wait_forCompleteOrderVisibility();
		myCheckOutPage.enter_UserInformation();
		myCheckOutPage.select_PaymentMethod();
		myCheckOutPage.click_OnCompleteOrder();
		myInvoicePage.wait_ForDownloadBtnLoading();
		myInvoicePage.verify_InvoiceDataInformation();
		logger.info("Test Case 1.3 End!");
		
	
	}
	
	@Test(enabled=false)
	public void testDownloadButton() throws Exception {
		logger.info("Test Case 1.4 Is Starting!");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnOrderLink();
		myOrderPage.waitUntilOrderPageComplete();
		myOrderPage.click_onOrderNow();
		myProductPage.switch_ToNewWindow();
		myProductPage.wait_forContinueBtnVisibility();
		myProductPage.click_OnContinueBtn();
		myShoppingCartPage.wait_ForPageLoadComplete();
		myShoppingCartPage.click_onCheckOutBtn();
		myCheckOutPage.wait_forCompleteOrderVisibility();
		myCheckOutPage.enter_UserInformation();
		myCheckOutPage.select_PaymentMethod();
		myCheckOutPage.click_OnCompleteOrder();
		myInvoicePage.wait_ForDownloadBtnLoading();
		myInvoicePage.verify_InvoiceDataInformation();
		myInvoicePage.download_File();
		logger.info("Test Case 1.4 End!");
		
	}
		
	@Test(enabled=false)
	public void chekingOnProductLink() {
		logger.info("Test Case 1.5 Is Starting!");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnProductLink();
		myHomePage.count_onDropDownElem();
		logger.info("Test Case 1.5 End!");
	}
	
	@Test(enabled=false)
	public void checkingOnServiceLink() {
		logger.info("Test Case 1.6 Is Starting!");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnServicesLink();
		myHomePage.count_onDropDownElemOfSer();
		logger.info("Test Case 1.6 Is End!");
		
	}
		
	@Test(enabled=false)
    public void checkingOnCompanyLink() {
		logger.info("Test Case 1.7 Is Starting!");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnCompanyLink();
		myHomePage.count_onDropDownElemofCom();
		logger.info("Test Case 1.7 End!");}
	
	@Test(enabled=false)
	public void checkingOnAboutUsLink() {
		logger.info("Test Case 1.8 Is Starting!");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnAboutUsLink();
		myHomePage.wait_untilAboutPageComplete();
		logger.info("Test Case 1.8 End!");
		}
	
	@Test(enabled=true)
	 public void checkingOnLoginLink() throws Exception {
		logger.info("Test Case 1.9 Is Starting!");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnLoginLink();
		myHomePage.switch_OnLoginPage();
		myLoginPage.wait_UntilLoginPageComplete();
		myLoginPage.click_OnRegiser();
		myRegisterPage.wait_ForRegisterPageLoad();
		myRegisterPage.enter_PersonaInfo();
		myRegisterPage.click_OnRegister();
		myRegisterPage.verify_Alert();
	
		logger.info("Test Case 1.9 Is Ending!");
		
	}

}

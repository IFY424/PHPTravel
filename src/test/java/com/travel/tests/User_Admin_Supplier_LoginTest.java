package com.travel.tests;

import org.testng.annotations.Test;

import com.selenium.Nayilalibrary.BasePage;
import com.travel.adminPage.AdminAccountPage;
import com.travel.adminPage.AdminLoginPage;
import com.travel.mainpage.HomePage;
import com.travel.supplierPage.SupplierAccountPage;
import com.travel.supplierPage.SupplierLoginPage;
import com.travel.travelPage.JohnAccountPage;
import com.travel.travelPage.TravelPage;
import com.travel.travelPage.UserLoginPage;

import jxl.common.Logger;

public class User_Admin_Supplier_LoginTest extends BasePage {
	final static Logger logger = Logger.getLogger(User_Admin_Supplier_LoginTest.class);
	HomePage myHomePage = new HomePage();
	AdminLoginPage myAdminLoginPage = new AdminLoginPage();
	TravelPage myTravelpage = new TravelPage();
	UserLoginPage myUserLoginPage = new UserLoginPage();
	JohnAccountPage myJohnAccountPage = new JohnAccountPage();
	AdminAccountPage myAdminAccountPage = new AdminAccountPage();
	SupplierLoginPage mySupplierLoginPage = new SupplierLoginPage();
	SupplierAccountPage mySupplierAccountPage = new SupplierAccountPage();

	@Test(enabled = false)
	public void testingHomePageLoginLink() throws Exception {
		logger.info("Text Case 3.1 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnHomepageFrontEndLink();
		myTravelpage.click_OnMyAccountLogin();
		myUserLoginPage.wait_UntilUserLoginPageComplete();
		myUserLoginPage.enter_UserNameAndPassWord();
		myUserLoginPage.click_onLoginBtn();
		myJohnAccountPage.wait_UntilJohnPageComplete();
		myJohnAccountPage.verify_JohnLogin();
		logger.info("Text Case 3.1 Is Ending");
	}

	@Test(enabled = false)
	public void testingHomePageLoginLinkWithInvalidDate() throws Exception {
		logger.info("Text Case 3.2 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnHomepageFrontEndLink();
		myTravelpage.click_OnMyAccountLogin();
		myUserLoginPage.wait_UntilUserLoginPageComplete();
		myUserLoginPage.enter_InvalidUserNameAndPassWord();
		myUserLoginPage.click_onLoginBtn();
		myUserLoginPage.verify_ErrorText();
		logger.info("Text Case 3.2 Is Ending");

	}

	@Test(enabled = false)
	public void testingAdministratorLoginPage() throws Exception {
		logger.info("Text Case 3.3 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnAdministratorBackEndLink();
		myAdminLoginPage.wait_ForAdminLoginPageLoad();
		myAdminLoginPage.enter_AdminEmail();
		myAdminLoginPage.enter_AdminPassword();
		myAdminLoginPage.click_LoginBtn();
		myAdminAccountPage.wait_UntilAdminAccountPageComplete();
		myAdminAccountPage.verify_AdminLogin();
		logger.info("Text Case 3.3 Is Ending");
	}

	@Test(enabled = false)
	public void testingAdministratorLoginPageWithInvalidDate() throws Exception {
		logger.info("Text Case 3.4 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnAdministratorBackEndLink();
		myAdminLoginPage.wait_ForAdminLoginPageLoad();
		myAdminLoginPage.enter_InvalidAdminEmail();
		myAdminLoginPage.enter_InvalidAdminPassword();
		myAdminLoginPage.click_LoginBtn();
		myAdminLoginPage.verify_ErrorText();
		logger.info("Text Case 3.4 Is Ending");

	}

	@Test(enabled = false)
	public void testingSupplierLoginPage() throws Exception {
		logger.info("Text Case 3.5 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnSupplierBackEndLink();
		mySupplierLoginPage.wait_ForSupplierLoginPageLoad();
		mySupplierLoginPage.enter_UserNameAndPassWord();
		mySupplierLoginPage.click_onLoginBtn();
		mySupplierAccountPage.wait_UntilSupplierAccountPageComplete();
		mySupplierAccountPage.verify_SupplierLogin();
		logger.info("Text Case 3.5 Is Ending");

	}
	@Test(enabled = false)
	public void testingSupplierLoginPageWithInValidData() throws Exception {
		logger.info("Text Case 3.6 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnSupplierBackEndLink();
		mySupplierLoginPage.wait_ForSupplierLoginPageLoad();
		mySupplierLoginPage.enter_InvalidUserNameAndPassWord();
		mySupplierLoginPage.click_onLoginBtn();
		mySupplierLoginPage.verify_ErrorText();
		logger.info("Text Case 3.6 Is Ending");
	
	
	
	
	
	
	
	
}}

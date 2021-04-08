package com.travel.tests;

import org.testng.annotations.Test;

import com.selenium.Nayilalibrary.BasePage;
import com.travel.adminPage.AddPage;
import com.travel.adminPage.AddPostPage;
import com.travel.adminPage.AdminAccountPage;
import com.travel.adminPage.AdminLoginPage;
import com.travel.adminPage.BlogManagementPage;
import com.travel.adminPage.BookingManagementPage;
import com.travel.adminPage.CMSManagementPage;
import com.travel.adminPage.EditBookingPage;
import com.travel.adminPage.QuickBookingPage;
import com.travel.mainpage.HomePage;

import jxl.common.Logger;

public class AdminPageFunctionalityTest extends BasePage {
	final static Logger logger = Logger.getLogger(AdminPageFunctionalityTest.class);
	HomePage myHomePage = new HomePage();
	AdminLoginPage myAdminLoginPage = new AdminLoginPage();
	AdminAccountPage myAdminAccountPage = new AdminAccountPage();
	QuickBookingPage myQuickBookingPage = new QuickBookingPage();
	BookingManagementPage myBookingManagementPage = new BookingManagementPage();
	EditBookingPage myEditBookingPage = new EditBookingPage();
	CMSManagementPage myCMSManagementPage = new CMSManagementPage();
	AddPage myAddPage = new AddPage();
	BlogManagementPage myBlogManagementPage = new BlogManagementPage();
	AddPostPage myAddPostPage = new AddPostPage();
	

	@Test(enabled = true)
	public void VerifyAdminQuickBookingFuncion() throws Exception {
		logger.info("Text Case 4.1 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnAdministratorBackEndLink();
		myAdminLoginPage.wait_ForAdminLoginPageLoad();
		myAdminLoginPage.enter_AdminEmail();
		myAdminLoginPage.enter_AdminPassword();
		myAdminLoginPage.click_LoginBtn();
		myAdminAccountPage.wait_UntilAdminAccountPageComplete();
		myAdminAccountPage.verify_AdminLogin();
		myAdminAccountPage.click_OnQuickBooking();
		myAdminAccountPage.select_TaxAndService();
		myAdminAccountPage.click_OnNext();
		myQuickBookingPage.wait_UntilQuickBookingPageComplete();
		myQuickBookingPage.select_CheckInCheckOutPage();
		myQuickBookingPage.select_HotelName();
		myQuickBookingPage.select_RoomName();
		myQuickBookingPage.enter_PerNightPrice();
		myQuickBookingPage.enter_TotalDeposit();
		myQuickBookingPage.click_OnExtras();
		myQuickBookingPage.select_OnPyamentMethod();
		myQuickBookingPage.click_OnBookNow();
		myBookingManagementPage.wait_UntilBookingMngPageComplete();
		myBookingManagementPage.verify_Booking();
		logger.info("Text Case 4.1 Is Ending");

	}

	@Test(enabled = false)
	public void VerifyAdminBookingFuncion() throws Exception {
		logger.info("Text Case 4.2 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnAdministratorBackEndLink();
		myAdminLoginPage.wait_ForAdminLoginPageLoad();
		myAdminLoginPage.enter_AdminEmail();
		myAdminLoginPage.enter_AdminPassword();
		myAdminLoginPage.click_LoginBtn();
		myAdminAccountPage.wait_UntilAdminAccountPageComplete();
		myAdminAccountPage.verify_AdminLogin();
		myAdminAccountPage.click_OnBookingsBtn();
		myBookingManagementPage.wait_UntilBookingMngPageComplete();
		myBookingManagementPage.Click_OnEditInvoice();
		myEditBookingPage.wait_UntilEditBookingPageComplete();
		myEditBookingPage.enter_TotalDeposit();
		myEditBookingPage.select_BookingStatus();
		myEditBookingPage.select_PaymentMethod();
		myEditBookingPage.click_OnUpdateBooking();
		myBookingManagementPage.wait_UntilBookingMngPageComplete();
		myBookingManagementPage.verify_UpdateBooking();
		myBookingManagementPage.download_File();
		logger.info("Text Case 4.2 Is Ending");

	}

	@Test(enabled = false)
	public void VerifyAdminCMSFuncion() throws Exception {
		logger.info("Text Case 4.3 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnAdministratorBackEndLink();
		myAdminLoginPage.wait_ForAdminLoginPageLoad();
		myAdminLoginPage.enter_AdminEmail();
		myAdminLoginPage.enter_AdminPassword();
		myAdminLoginPage.click_LoginBtn();
		myAdminAccountPage.wait_UntilAdminAccountPageComplete();
		myAdminAccountPage.verify_AdminLogin();
		myAdminAccountPage.click_OnCMSBtn();
		myCMSManagementPage.wait_UntilCMSMngPageComplete();
		myCMSManagementPage.click_OnAddBtn();
		myAddPage.wait_UntilAddPageComplete();
		myAddPage.enter_PageTitle();
		myAddPage.enter_Prelink();
		myAddPage.enter_Text();
		myAddPage.click_OnSubmit();
		myCMSManagementPage.wait_UntilCMSMngPageComplete();
		myCMSManagementPage.verify_AddCMS();
		logger.info("Text Case 4.3 Is Ending");

	}

	@Test(enabled = false)
	public void VerifyAdminBloggingFuncion() throws Exception {
		logger.info("Text Case 4.4 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnAdministratorBackEndLink();
		myAdminLoginPage.wait_ForAdminLoginPageLoad();
		myAdminLoginPage.enter_AdminEmail();
		myAdminLoginPage.enter_AdminPassword();
		myAdminLoginPage.click_LoginBtn();
		myAdminAccountPage.wait_UntilAdminAccountPageComplete();
		myAdminAccountPage.verify_AdminLogin();
		myAdminAccountPage.click_OnBlogBtn();
		myBlogManagementPage.wait_UntilBlogMngPageComplete();
		myBlogManagementPage.click_OnAddBtn();
		myAddPostPage.wait_UntilAddPostPageComplete();
		myAddPostPage.enter_PageTitle();
		myAddPostPage.enter_Prelink();
		myAddPostPage.enter_Text();
		myAddPostPage.insert_Images();
		myAddPostPage.select_Catagory();
		myAddPostPage.click_OnSubmit();
		myBlogManagementPage.wait_UntilBlogMngPageComplete();
		myBlogManagementPage.verify_AddPost();
		logger.info("Text Case 4.4 Is Ending");
	}

	
		
		
		
		
		
		
		
		
	}

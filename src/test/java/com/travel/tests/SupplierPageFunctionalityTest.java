package com.travel.tests;

import org.testng.annotations.Test;

import com.selenium.Nayilalibrary.BasePage;
import com.travel.mainpage.HomePage;
import com.travel.supplierPage.AddRoomPage;
import com.travel.supplierPage.ExtraManagement;
import com.travel.supplierPage.SupplierAccountPage;
import com.travel.supplierPage.SupplierLoginPage;

import jxl.common.Logger;

public class SupplierPageFunctionalityTest extends BasePage{
	final static Logger logger = Logger.getLogger(SupplierPageFunctionalityTest.class);
	HomePage myHomePage = new HomePage();
	SupplierLoginPage mySupplierLoginPage = new SupplierLoginPage();
	SupplierAccountPage mySupplierAccountPage = new SupplierAccountPage();
	AddRoomPage myAddRoomPage=new AddRoomPage();
	ExtraManagement myExtraManagement=new ExtraManagement();
	
	@Test(enabled = false)
	public void VerifySupplierAddRoomFuncionWithoutHotelName() throws Exception {
		logger.info("Text Case 5.1 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnSupplierBackEndLink();
		mySupplierLoginPage.wait_ForSupplierLoginPageLoad();
		mySupplierLoginPage.enter_UserNameAndPassWord();
		mySupplierLoginPage.click_onLoginBtn();
		mySupplierAccountPage.wait_UntilSupplierAccountPageComplete();
		mySupplierAccountPage.verify_SupplierLogin();
		mySupplierAccountPage.click_OnHotel();
		mySupplierAccountPage.click_AddRoom();
		myAddRoomPage.wait_UntilAddRoomPageComplete();
		myAddRoomPage.select_RoomType();
		myAddRoomPage.enter_Text();
		myAddRoomPage.enter_Price();
		myAddRoomPage.enter_Quantity();
		myAddRoomPage.enter_MiniumStay();
		myAddRoomPage.click_OnSubmit();
		myAddRoomPage.verify_ErrorMassage();
		logger.info("Text Case 5.1 Is Ending");}
		
		@Test(enabled = true)
		public void VerifySupplierAssignBtnFuncion() throws Exception {
			logger.info("Text Case 5.2 Is Starting");
			myHomePage.goto_PhpTravelSite();
			myHomePage.click_OnSupplierBackEndLink();
			mySupplierLoginPage.wait_ForSupplierLoginPageLoad();
			mySupplierLoginPage.enter_UserNameAndPassWord();
			mySupplierLoginPage.click_onLoginBtn();
			mySupplierAccountPage.wait_UntilSupplierAccountPageComplete();
			mySupplierAccountPage.verify_SupplierLogin();
			mySupplierAccountPage.click_OnHotel();
			mySupplierAccountPage.click_Extras();
			myExtraManagement.wait_UntilExtraMngPageComplete();
			myExtraManagement.click_OnAssign();
			myExtraManagement.wait_ForUpdateBtnVisibility();
			myExtraManagement.delete_HotelList();
			myExtraManagement.click_OnUpdate();
			myExtraManagement.click_OnAssign();
			myExtraManagement.verify_HotelListAfterDelt();
			logger.info("Text Case 5.2 Is Ending");
	
	
	
	
	
	

}}

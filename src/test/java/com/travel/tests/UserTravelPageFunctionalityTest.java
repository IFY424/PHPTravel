package com.travel.tests;

import org.testng.annotations.Test;

import com.selenium.Nayilalibrary.BasePage;
import com.travel.mainpage.HomePage;
import com.travel.travelPage.CarBookingSummary;
import com.travel.travelPage.CarDetailPage;
import com.travel.travelPage.CarInvoicePage;
import com.travel.travelPage.CarSearchPage;
import com.travel.travelPage.ContactUsPage;
import com.travel.travelPage.FlightSearchResultPage;
import com.travel.travelPage.HotelInvoicePage;
import com.travel.travelPage.HotelSearchResultPage;
import com.travel.travelPage.IslamAbadaInfoPage;
import com.travel.travelPage.PersonalInformationHotel;
import com.travel.travelPage.TourBookingSummaryPage;
import com.travel.travelPage.TourDetailPage;
import com.travel.travelPage.TourInvoicePage;
import com.travel.travelPage.TourListingsPage;
import com.travel.travelPage.TravelPage;

import jxl.common.Logger;

public class UserTravelPageFunctionalityTest extends BasePage {
	final static Logger logger = Logger.getLogger(UserTravelPageFunctionalityTest.class);
	TravelPage myTravelpage = new TravelPage();
	HomePage myHomePage = new HomePage();
	HotelSearchResultPage myHotelSearchResultPage = new HotelSearchResultPage();
	IslamAbadaInfoPage myHotel = new IslamAbadaInfoPage();
	PersonalInformationHotel myPersonalInfo = new PersonalInformationHotel();
	HotelInvoicePage myHotelInvoicePage = new HotelInvoicePage();
	FlightSearchResultPage myFlightResult = new FlightSearchResultPage();
	TourListingsPage myTourListPage = new TourListingsPage();
	TourDetailPage myTourDetailPage = new TourDetailPage();
	TourBookingSummaryPage myTourBookingPage = new TourBookingSummaryPage();
	TourInvoicePage myTourInvoicePage = new TourInvoicePage();
	CarSearchPage myCarSearchPage = new CarSearchPage();
	CarDetailPage myCarDetailPage = new CarDetailPage();
	CarBookingSummary myCarBookingSummaryPage = new CarBookingSummary();
	CarInvoicePage myCarInvoicePage = new CarInvoicePage();
	ContactUsPage myContactUsPage = new ContactUsPage();

	@Test(enabled = false)
	public void verifyHotelSearhing() throws Exception {
		logger.info("Test Case 2.1 is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnHomepageFrontEndLink();
		myTravelpage.enter_HotelName();
		myTravelpage.enter_CheckinDate();
		myTravelpage.enter_CheckOutDate();
		myTravelpage.enter_NumberAdults();
		myTravelpage.enter_numberChilds();
		myTravelpage.click_OnSearchButton();
		myHotelSearchResultPage.wait_OnHotelSearchResultPageLoad();

		logger.info("Test Case 2.1 is Ending");

	}

	@Test(enabled = false)
	public void verifyMyHotelSearching() throws Exception {
		logger.info("Test case 2.2 is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnHomepageFrontEndLink();
		myTravelpage.scroll_DownWindow();
		myTravelpage.click_OnHotel();
		myHotel.wait_forIslamAbadPageLoad();
		myHotel.scroll_DownDiscription();
		myHotel.click_OnHotelImages();
		myHotel.enter_CheckInDate();
		myHotel.enter_CheckoutDate();
		myHotel.enter_NumOfAdults();
		myHotel.enter_NumOfChild();
		myHotel.click_OnModify();
		myHotel.Wait_ForModifyResult();
		logger.info("Test Case 2.2 Is Ending");
	}

	@Test(enabled = false)
	public void VerifyMyHotelBooking() throws Exception {
		logger.info("Test Case 2.3 is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnHomepageFrontEndLink();
		myTravelpage.scroll_DownWindow();
		myTravelpage.click_OnHotel();
		myHotel.wait_forIslamAbadPageLoad();
		myHotel.scroll_DownDiscription();
		// myHotel.click_OnHotelImages();
		myHotel.enter_CheckInDate();
		myHotel.enter_CheckoutDate();
		myHotel.enter_NumOfAdults();
		myHotel.enter_NumOfChild();
		myHotel.click_OnModify();
		myHotel.Wait_ForModifyResult();
		myHotel.scroll_DownToExecutiveRoom();
		myHotel.click_OnBookNowBtn();
		myPersonalInfo.wait_ForPerInPageLoad();
		myPersonalInfo.click_OnBookAsGuestBtn();
		myPersonalInfo.enter_PersonalInformation();
		myPersonalInfo.enter_country();
		myPersonalInfo.click_OnConfirmBtn();
		myHotelInvoicePage.wait_ForInvoicePageLoad();
		myHotelInvoicePage.click_onPayNow();
		myHotelInvoicePage.click_CreditCardOption();
		myHotelInvoicePage.enter_CreditCardInfo();
		myHotelInvoicePage.click_PayNowBtn();
		logger.info("Test Case 2.3 Is Ending");
	}

	@Test(enabled = true)
	public void verifyFlightReservation() throws Exception {
		logger.info("Test Case 2.4 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnHomepageFrontEndLink();
		myTravelpage.click_OnFlightIcon();
		myTravelpage.enter_Origin();
		myTravelpage.enter_Destination();
		myTravelpage.enter_DepartReturnDate();
		myTravelpage.enter_NumberOfPeople();
		myTravelpage.click_OnSearch();
		myTravelpage.switch_ToFlightResultWindow();
		myFlightResult.wait_ForFlightSearchLoading();
		myFlightResult.select_BestTicket();
		myFlightResult.click_OnOneStop();
		myFlightResult.verify_OneStopResult();
		//myFlightResult.slide_DurationOfStop();
		myFlightResult.select_CheapestTicket();

		logger.info("Test Case 2.4 Is Ending");

	}

	@Test(enabled = false)
	public void verifyTourReservation() throws Exception {
		logger.info("Test Case 2.5 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnHomepageFrontEndLink();
		myTravelpage.click_OnTourOption();
		myTourListPage.wait_ForPageLoad();
		myTourListPage.verify_Language();
		myTourListPage.enter_Location();
		myTourListPage.enter_CheckIn();
		myTourListPage.enter_NumOfAdult();
		// myTourListPage.Select_TourType();
		myTourListPage.click_SearchBtn();
		myTourListPage.verify_searchResult();
		myTourListPage.click_OnDetails();
		myTourDetailPage.wait_PageLoading();
		myTourDetailPage.scroll_DownDiscription();
		myTourDetailPage.select_TourMember();
		myTourDetailPage.click_BookNow();
		myTourBookingPage.wait_UntilPageLoad();
		myTourBookingPage.click_SignInBtn();
		myTourBookingPage.enter_UserNameAndPass();
		myTourBookingPage.select_Extras();
		myTourBookingPage.enter_GuestInformation();
		myTourBookingPage.click_OnBookingConfirmation();
		myTourInvoicePage.wait_ForInvoicePageLoad();
		myTourInvoicePage.click_OnPayOnArrival();
		myTourInvoicePage.click_OnOk();
		myTourInvoicePage.verify_Reserved();
		logger.info("Test Case 2.5 Is Ending");

	}

	@Test(enabled = false)
	public void verifyCarReservation() throws Exception {
		logger.info("Test Case 2.6 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnHomepageFrontEndLink();
		myTravelpage.click_OnCarOption();
		myCarSearchPage.wait_ForCarSearchLoading();
		myCarSearchPage.click_onNextPage();
		myCarSearchPage.wait_onDetailBtn();
		myCarSearchPage.click_OnDetail();
		myCarDetailPage.wait_ForCarDetailPageLoading();
		myCarDetailPage.select_PickUpOption();
		myCarDetailPage.select_DropOffOption();
		myCarDetailPage.select_PickUpDate();
		myCarDetailPage.select_PickUpTime();
		myCarDetailPage.select_DropOffDate();
		myCarDetailPage.select_DropOffTime();
		myCarDetailPage.click_OnBookNow();
		logger.info("Test Case 2.6 Is Ending");

	}

	@Test(enabled = false)
	public void verifyCarReservationWithSignIn() throws Exception {
		logger.info("Test Case 2.7 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnHomepageFrontEndLink();
		myTravelpage.click_OnCarOption();
		myCarSearchPage.wait_ForCarSearchLoading();
		myCarSearchPage.click_onNextPage();
		myCarSearchPage.wait_onDetailBtn();
		myCarSearchPage.click_OnDetail();
		myCarDetailPage.wait_ForCarDetailPageLoading();
		myCarDetailPage.select_PickUpOption();
		myCarDetailPage.select_DropOffOption();
		myCarDetailPage.select_PickUpDate();
		myCarDetailPage.select_PickUpTime();
		myCarDetailPage.select_DropOffDate();
		myCarDetailPage.select_DropOffTime();
		myCarDetailPage.click_OnBookNow();
		myCarBookingSummaryPage.wait_UntilPageLoad();
		myCarBookingSummaryPage.click_SignInBtn();
		myCarBookingSummaryPage.enter_UserNameAndPass();
		myCarBookingSummaryPage.select_Extras();
		myCarBookingSummaryPage.click_OnBookingConfirmation();
		myCarInvoicePage.wait_ForInvoicePageLoad();
		myCarInvoicePage.click_OnPayOnArrival();
		myCarInvoicePage.click_OnOk();
		myCarInvoicePage.verify_Reserved();
		myCarInvoicePage.click_OnJohn();
		myCarInvoicePage.verify_CarInfo();
		logger.info("Test Case 2.7 Is Ending");

	}

	@Test(enabled = false)
	public void verifyContactUsFunctionality() throws Exception {
		logger.info("Test Case 2.8 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnHomepageFrontEndLink();
		myTravelpage.click_OnContactUsOption();
		myContactUsPage.wait_UntilPageLoad();
		myContactUsPage.enter_name();
		myContactUsPage.enter_Email();
		myContactUsPage.enter_Subject();
		myContactUsPage.enter_Message();
		myContactUsPage.click_OnSubmitBtn();
		myContactUsPage.verify_MessageSent();
		logger.info("Test Case 2.8 Is Ending");

	}

	@Test(enabled = false)
	public void verifyLanguageBtnFunctionality1() throws Exception {
		logger.info("Test Case 2.9 Is Starting");
		myHomePage.goto_PhpTravelSite();
		myHomePage.click_OnHomepageFrontEndLink();
		myTravelpage.verify_LanguageBtn();
		logger.info("Test Case 2.9 Is Ending");

	}
}

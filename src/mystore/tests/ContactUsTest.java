package mystore.tests;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import mystore.pageobjects.ApplicationPage;
import mystore.pageobjects.ContactUsPage;
import mystore.pageobjects.HomePage;

public class ContactUsTest extends BaseTest {

	@Test  //fill all fields
	public void a01_ContactusTest()  {
		ApplicationPage ap = new HomePage(driver);
		ap.contactUs();
		ContactUsPage cup=new ContactUsPage(driver);
		cup.OpenSelectOption();
		cup.SelectSubHeading("1");
		cup.FillEmailAddress("limor@gmail.com");
		cup.FillOrderRef("Test");
		//		cup.ChooseFileToUpload("D:\\limor backup\\LIMI\\הכנה למבחנים QA\\How to Upload & Download a File using Selenium Webdriver");
		cup.FillMessage("I'm Testing this site");
		cup.SendMessage();
		String actual = cup.GetSuccessMsg();
		String expected= ("Your message has been successfully sent to our team.");
		assertEquals(actual, expected);
		}
	
	@Test  //empty order number
	public void a02_ContactusTest() {
		ApplicationPage ap = new HomePage(driver);
		ap.contactUs();
		ContactUsPage cup=new ContactUsPage(driver);
		cup.OpenSelectOption();
		cup.SelectSubHeading("2");
		cup.FillEmailAddress("limor@gmail.com");
		cup.FillMessage("I'm Testing this site");
		cup.SendMessage();
		String actual = cup.GetSuccessMsg();
		String expected= ("Your message has been successfully sent to our team.");
		assertEquals(actual, expected);
		ap.signOutBtn();
	}

	@Test  // no subject selected
	public void a03_ContactusTest() {
		ApplicationPage ap = new HomePage(driver);
		ap.contactUs();
		ContactUsPage cup=new ContactUsPage(driver);
		cup.OpenSelectOption();
		cup.FillEmailAddress("limor@gmail.com");
		cup.FillOrderRef("Test");
		cup.FillMessage("I'm Testing this site");
		cup.SendMessage();
		String actual = cup.GetErrMsg();
		String expected= ("There is 1 error\nPlease select a subject from the list provided.");
		assertEquals(actual, expected);
	}

	@Test //Invalid email address
	public void a04_ContactusTest()  {
		ApplicationPage ap = new HomePage(driver);
		ap.contactUs();
		ContactUsPage cup=new ContactUsPage(driver);
		cup.OpenSelectOption();
		cup.SelectSubHeading("2");
		cup.FillEmailAddress("limor@gmail");
		cup.FillOrderRef("Test");
		cup.FillMessage("I'm Testing this site");
		cup.SendMessage();
		String actual = cup.GetErrMsg();
		String expected= ("There is 1 error\nInvalid email address.");
		assertEquals(actual, expected);
	}

	@Test // empty message
	public void a05_ContactusTest() {
		ApplicationPage ap = new HomePage(driver);
		ap.contactUs();
		ContactUsPage cup=new ContactUsPage(driver);
		cup.OpenSelectOption();
		cup.SelectSubHeading("2");
		cup.FillEmailAddress("limor@gmail.com");
		cup.FillOrderRef("Test");
		cup.SendMessage();
		String actual = cup.GetErrMsg();
		String expected= ("There is 1 error\nThe message cannot be blank.");
		assertEquals(actual, expected);
	}

}

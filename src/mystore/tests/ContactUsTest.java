package mystore.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import mystore.pageobjects.ApplicationPage;
import mystore.pageobjects.ContactUsPage;
import mystore.pageobjects.HomePage;

public class ContactUsTest extends BaseTest {

	@Test  ( description="Fill all fields")
	public void a01_ContactusTest()  {
		ApplicationPage ap = new HomePage(driver);
		ap.contactUs();
		ContactUsPage cup=new ContactUsPage(driver);
		cup.openSelectOption();
		cup.selectSubHeading("1");
		cup.fillEmailAddress("limor@gmail.com");
		cup.fillOrderRef("Test");
		cup.fillMessage("I'm Testing this site");
		cup.sendMessage();
		String actual = cup.getSuccessMsg();
		String expected= ("Your message has been successfully sent to our team.");
		assertEquals(actual, expected);
	}

	@Test   ( description="Empty order number")
	public void a02_ContactusTest() {
		ApplicationPage ap = new HomePage(driver);
		ap.contactUs();
		ContactUsPage cup=new ContactUsPage(driver);
		cup.openSelectOption();
		cup.selectSubHeading("2");
		cup.fillEmailAddress("limor@gmail.com");
		cup.fillMessage("I'm Testing this site");
		cup.sendMessage();
		String actual = cup.getSuccessMsg();
		String expected= ("Your message has been successfully sent to our team.");
		assertEquals(actual, expected);
		ap.signOutBtn();
	}

	@Test   ( description="No subject selected")
	public void a03_ContactusTest() {
		ApplicationPage ap = new HomePage(driver);
		ap.contactUs();
		ContactUsPage cup=new ContactUsPage(driver);
		cup.openSelectOption();
		cup.fillEmailAddress("limor@gmail.com");
		cup.fillOrderRef("Test");
		cup.fillMessage("I'm Testing this site");
		cup.sendMessage();
		String actual = cup.GetErrMsg();
		String expected= ("There is 1 error\nPlease select a subject from the list provided.");
		assertEquals(actual, expected);
	}

	@Test  ( description="Invalid email address")
	public void a04_ContactusTest()  {
		ApplicationPage ap = new HomePage(driver);
		ap.contactUs();
		ContactUsPage cup=new ContactUsPage(driver);
		cup.openSelectOption();
		cup.selectSubHeading("2");
		cup.fillEmailAddress("limor@gmail");
		cup.fillOrderRef("Test");
		cup.fillMessage("I'm Testing this site");
		cup.sendMessage();
		String actual = cup.GetErrMsg();
		String expected= ("There is 1 error\nInvalid email address.");
		assertEquals(actual, expected);
	}

	@Test  ( description="Empty message")
	public void a05_ContactusTest() {
		ApplicationPage ap = new HomePage(driver);
		ap.contactUs();
		ContactUsPage cup=new ContactUsPage(driver);
		cup.openSelectOption();
		cup.selectSubHeading("2");
		cup.fillEmailAddress("limor@gmail.com");
		cup.fillOrderRef("Test");
		cup.sendMessage();
		String actual = cup.GetErrMsg();
		String expected= ("There is 1 error\nThe message cannot be blank.");
		assertEquals(actual, expected);
	}
}

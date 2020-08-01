package mystore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import mystore.pageobjects.ApplicationPage;
import mystore.pageobjects.HomePage;
import mystore.pageobjects.AuthenticationPage;
import mystore.pageobjects.ForGetPswdPage;

public class ForGetYourPswdTest extends BaseTest {

	@Test ( description="Fill all fields")
	public void c01_ForGetYourPswd() {
		ApplicationPage ap = new HomePage(driver);
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.forGetYourPswd();
		ForGetPswdPage fg = new ForGetPswdPage(driver);
		String email="l@gmail.com";
		fg.fillForGetPswdDetails(email);
		String actual= fg.getSuccessMsg();
		String expected=("A confirmation email has been sent to your address: "+email);
		Assert.assertEquals(actual, expected);
	}

	@Test( description="Insert invalid email address")
	public void c02_ForGetYourPswd() {
		ApplicationPage ap = new HomePage(driver);
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.forGetYourPswd();
		ForGetPswdPage fg = new ForGetPswdPage(driver);
		String email="notemail";
		fg.fillForGetPswdDetails(email);
		String actual= fg.GetErrMsg();
		String expected=("There is 1 error\nInvalid email address."	);//   \n    line down
		Assert.assertEquals(actual, expected);
	}

	@Test ( description="Account not register")
	public void c03_ForGetYourPswd() {
		ApplicationPage ap = new HomePage(driver);
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.forGetYourPswd();
		ForGetPswdPage fg = new ForGetPswdPage(driver);
		String email="rrr@ggg.com";
		fg.fillForGetPswdDetails(email);
		String actual= fg.GetErrMsg();
		String expected=("There is 1 error\nThere is no account registered for this email address."	);
		Assert.assertEquals(actual, expected);
	}
}

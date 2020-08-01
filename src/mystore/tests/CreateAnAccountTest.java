package mystore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import mystore.pageobjects.ApplicationPage;
import mystore.pageobjects.AuthenticationPage;
import mystore.pageobjects.CreateAnAccountPage;

public class CreateAnAccountTest extends BaseTest{

	@Test  ( description="All Fields empty")
	public void b01_CreateAnAccount() {
		ApplicationPage ap = new ApplicationPage(driver);
		ap.signInBtn();
		AuthenticationPage aut =new AuthenticationPage(driver);
		aut.createAnAccount("limatti320@gmail.com");
		CreateAnAccountPage crt = new CreateAnAccountPage(driver);
		crt.registrBtn();
		String actual = crt.GetErrMsg();
		String expected =("There are 8 errors\nYou must register at least one phone number.\nlastname is required.\nfirstname is required.\npasswd is required.\naddress1 is required.\ncity is required.\nThe Zip/Postal code you've entered is invalid. It must follow this format: 00000\nThis country requires you to choose a State.");
		String message= ("You need to fill the Required field");
		Assert.assertEquals(actual, expected, message);
		System.out.println(message);
	}

	@Test ( description="Fill all Fields") 
	public void b02_CreateAnAccount() {
		ApplicationPage ap = new ApplicationPage(driver);
		ap.signInBtn();
		AuthenticationPage aut =new AuthenticationPage(driver);
		aut.createAnAccount("limatti320@gmail.com");
		CreateAnAccountPage crt = new CreateAnAccountPage(driver);
		crt.fillForm("limor", "ha","limatti320@gmail.com" , "12345", "15", "12", "1980", "limor", "ha", "data+", "emek", "ayalon", "Miami", "Florida", "75365", "United States", "testing", "035050505", "0505050505", "Israel");
		ap.signOutBtn();
	}

	@Test ( description="Fill only required Fields with new account")
	public void b03_CreateAnAccount() {
		ApplicationPage ap = new ApplicationPage(driver);
		ap.signInBtn();
		AuthenticationPage aut =new AuthenticationPage(driver);
		aut.createAnAccount("limatti321@gmail.com");
		CreateAnAccountPage crt = new CreateAnAccountPage(driver);
		crt.fillForm("limor", "ha","limatti321@gmail.com" , "12345", "", "", "", "limor", "ha", "", "emek", "", "Miami", "Florida", "75365", "United States", "", "", "0505050505", "home");
		ap.signOutBtn();
	}

	@Test ( description="Fill required Fields with exist account")
	public void b04_CreateAnAccount(){
		ApplicationPage ap = new ApplicationPage(driver);
		ap.signInBtn();
		AuthenticationPage aut =new AuthenticationPage(driver);
		aut.createAnAccount("limatti31@gmail.com");
		CreateAnAccountPage crt = new CreateAnAccountPage(driver);
		crt.fillForm("limor", "ha","limatti306@gmail.com" , "12345", "", "", "", "limor", "ha", "", "emek", "", "Miami", "Florida", "75365", "United States", "", "", "0505050505", "home");
		String actual= aut.GetErrMsg();
		String expected=("There is 1 error\nAn account using this email address has already been registered.");
		Assert.assertEquals(actual, expected);
	}
}



package mystore.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import mystore.pageobjects.ApplicationPage;
import mystore.pageobjects.AuthenticationPage;
import mystore.pageobjects.ForGetPswdPage;
import mystore.pageobjects.HomePage;
import mystore.pageobjects.MyAccountPage;

public class AlreadyRigistedTest extends BaseTest{
	@Test(dataProvider="getData", description="use unregister account") 
	public void d01_AlreadyRigistedTest(String email,String password) {
		ApplicationPage ap = new HomePage(driver);
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.alreadyRegistered(email, password);
		String actual= aut.GetErrMsg();
		String expected=("There is 1 error\nAuthentication failed.");
		Assert.assertEquals(actual, expected);
	}
		
		
	@Test // invalid password
	public void d02_AlreadyRigistedTest() {
		ApplicationPage ap = new HomePage(driver);
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.alreadyRegistered("l@gmail.com", "1");
		String actual= aut.GetErrMsg();
		String expected=("There is 1 error\nInvalid password.");
		Assert.assertEquals(actual, expected);
	}

	@Test // Invalid email address.
	public void d03_AlreadyRigistedTest() {
		ApplicationPage ap = new HomePage(driver);
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.alreadyRegistered("l", "12345");
		String actual= aut.GetErrMsg();
		String expected=("There is 1 error\nInvalid email address.");
		Assert.assertEquals(actual, expected);
	}

	@Test // no password
	public void d04_AlreadyRigistedTest() {
		ApplicationPage ap = new HomePage(driver);
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.alreadyRegistered("l@gmail.com", "");
		String actual= aut.GetErrMsg();
		String expected=("There is 1 error\nPassword is required.");
		Assert.assertEquals(actual, expected);
	}
	
//	//dataprovider from excel
//	@Test(dataProvider="getDataFromExcel", description="use unregister account") 
//	public void d05_AlreadyRigistedTest() {
//		ApplicationPage ap = new HomePage(driver);
//		ap.signInBtn();
//		AuthenticationPage aut = new AuthenticationPage(driver);
//		aut.alreadyRegistered("limatti@gmail.com", "12345");
//		MyAccountPage map = new MyAccountPage(driver);
//		String actual= map.MyAccountMsgPage();
//		String expected=("Welcome to your account. Here you can manage all of your personal information and orders.");
//		Assert.assertEquals(actual, expected);
//		ap.signOutBtn();
//	  }
	
	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"yonit333@gmail.com","12345"},
				{"limi222@gmail.com","12345"},
				{"yonit@gmail.com","1#444"},
				{"limi@gmail.com","123456878"},
		};
		return myData;
}
	
//	@DataProvider
//	public Object[][] getDataFromExcel(){
//		String excelPath = System.getProperty("user.dir") + "\\src\\mystore.data\\accountalreadyexist.xlsx";
//		System.out.println(excelPath);
//		Object[][] table = Excel.getTableArray(excelPath, "Login");
//		return table;
//	}
}




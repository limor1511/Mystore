package mystore.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import mystore.pageobjects.ApplicationPage;
import mystore.pageobjects.AuthenticationPage;
import mystore.pageobjects.HomePage;
import mystore.utils.Excel;

public class AlreadyRigistedTest extends BaseTest{

	@Test(dataProvider="getDataFromExcel", description="Use unregister account") 
	public void d01_AlreadyRigistedTest(String email,String password) {
		ApplicationPage ap = new HomePage(driver);
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.alreadyRegistered(email, password);
		String actual= aut.GetErrMsg();
		String expected=("There is 1 error\nAuthentication failed.");
		Assert.assertEquals(actual, expected);
	}

	@Test ( description="Insert invalid password") 
	public void d02_AlreadyRigistedTest() {
		ApplicationPage ap = new HomePage(driver);
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.alreadyRegistered("l@gmail.com", "1");
		String actual= aut.GetErrMsg();
		String expected=("There is 1 error\nInvalid password.");
		Assert.assertEquals(actual, expected);
	}

	@Test ( description="Insert invalid email address") 
	public void d03_AlreadyRigistedTest() {
		ApplicationPage ap = new HomePage(driver);
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.alreadyRegistered("l", "12345");
		String actual= aut.GetErrMsg();
		String expected=("There is 1 error\nInvalid email address.");
		Assert.assertEquals(actual, expected);
	}

	@Test ( description="Empty password")
	public void d04_AlreadyRigistedTest() {
		ApplicationPage ap = new HomePage(driver);
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.alreadyRegistered("l@gmail.com", "");
		String actual= aut.GetErrMsg();
		String expected=("There is 1 error\nPassword is required.");
		Assert.assertEquals(actual, expected);
	}

	@DataProvider // Check get data from getData
	public Object[][] getData(){
		Object[][] myData = {
				{"yonit333@gmail.com","12345"},
				{"limi222@gmail.com","12345"},
				{"yonit@gmail.com","1#444"},
				{"limi@gmail.com","123456878"},
		};
		return myData;
	}

	@DataProvider  //Check get data from excel
	public Object[][] getDataFromExcel(){
		String excelPath = System.getProperty("user.dir") + "\\src\\mystore\\data\\input.xlsx";
		System.out.println(excelPath);
		Object[][] table = Excel.getTableArray(excelPath, "Login");
		return table;
	}
}












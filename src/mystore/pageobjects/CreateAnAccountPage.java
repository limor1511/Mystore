package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage extends ApplicationPage {

	@FindBy(css="#id_gender1")
	private WebElement rbMr ;	
	@FindBy(css="#id_gender2")
	private WebElement rbMrs ;
	@FindBy(css="#customer_firstname")
	private WebElement firstname1Field;
	@FindBy(css="#customer_lastname")
	private WebElement lastName1Field;
	@FindBy(css="#email")
	private WebElement email ;
	@FindBy(css="#passwd")
	private WebElement passwd ;
	@FindBy(css="#days")
	private WebElement days ;
	@FindBy(css="#months.form-control")
	private WebElement months;
	@FindBy(css="#years")
	private WebElement years ;
	@FindBy(css="#newsletter")
	private WebElement signNewsletterCb ;
	@FindBy(css="#optin")
	private WebElement rcvSpecialOfferCb ;
	@FindBy(css="#firstname")
	private WebElement firstnameforaddress ;
	@FindBy(css="#lastname")
	private WebElement lastnameforaddress;
	@FindBy(css="#company")
	private WebElement company ;
	@FindBy(css="#address1")
	private WebElement address1Line;
	@FindBy(css="#address2")
	private WebElement address2Line;
	@FindBy(css="#city")
	private WebElement city ;
	@FindBy(css="#id_state")
	private WebElement state ;
	@FindBy(css="#postcode")
	private WebElement postcode ;
	@FindBy(css="#id_country")
	private WebElement country ;
	@FindBy(css="#other")
	private WebElement addInfo ;
	@FindBy(css="#phone")
	private WebElement homePhone ;
	@FindBy(css="#phone_mobile")
	private WebElement mobilePhone ;
	@FindBy(css="#alias")
	private WebElement aliasAddress ;
	@FindBy(css="#submitAccount")
	private WebElement submitAccountBtn;

	public CreateAnAccountPage(WebDriver driver) {
		super(driver);
	}

	public void fillForm (String Firstname ,String LastName,String Email, 
			String Password ,String dd ,String mm,String yyyy,
			String Firstname2 , String LastName2 , String Company, String Address1Line,
			String Address2Line, String City, String State, String PostCode , String Country ,
			String AdditionalInfo , String HomePhone , String MobilePhone , String AliasAddress ) {
		sleepSec(5);		
		click(rbMrs);
		fillText(firstname1Field, Firstname);
		fillText(lastName1Field, LastName);
		fillText(email, Email);
		fillText(passwd, Password);
		selectByValue(days, dd);
		selectByValue(months, mm);
		selectByValue(years, yyyy);
		click(signNewsletterCb);
		click(rcvSpecialOfferCb);
		fillText(firstnameforaddress, Firstname2);
		fillText(lastnameforaddress, LastName2);
		fillText(company, Company);
		fillText(address1Line, Address1Line);
		fillText(address2Line, Address2Line);
		fillText(city, City);
		selectByVisableText(state, State);
		fillText(postcode, PostCode);
		selectByVisableText(country, Country);
		fillText(addInfo, AdditionalInfo);
		fillText(homePhone, HomePhone);
		fillText(mobilePhone, MobilePhone);
		fillText(aliasAddress, AliasAddress);
		registrBtn();
	}

	public void chooseRbMr() {
		sleepSec(5);		
		if (rbMr.isSelected()==true) {
			System.out.println(" radio button Mr checked");
		}else
			System.out.println(" radio button Mr Not check");
	}

	public void chooseRbMrs() {
		sleepSec(5);		
		click(rbMrs);
		if (rbMrs.isSelected()==true) {
			System.out.println(" radio button Mrs checked");
		}else
			System.out.println(" radio button Mrs Not check");
	}

	public void fillFirstName(String FirstName) {
		fillText(firstname1Field, FirstName);
	}

	public void fillLastName(String LastName) {
		fillText(lastName1Field, LastName);
	}

	public void fillEmail(String Email) {
		fillText(email, Email);
	}

	public void fillPassword(String Password) {
		fillText(passwd, Password);
	}

	public void selectBirthDate(String dd ,String mm,String yyyy ) {
		selectByValue(days, dd);
		selectByValue(months, mm);
		selectByValue(years, yyyy);
	}

	public void chooseCbSignNewsletter() {
		click(signNewsletterCb);
		if (signNewsletterCb.isSelected()==true) {
			System.out.println(" check box SignNewsletter checked");
		}else
			System.out.println(" check box SignNewsletter Not check");
	}

	public void chooseCbRcvSpecialOfferCb() {
		click(rcvSpecialOfferCb);
		if (rcvSpecialOfferCb.isSelected()==true) {
			System.out.println(" check box RcvSpecialOffer checked");
		}else
			System.out.println(" check box RcvSpecialOffer Not check");
	}

	public void fillFirstNameForAddress(String FirstName) {
		fillText(firstnameforaddress, FirstName);
	}

	public void fillLastNameForAddress(String LastName) {
		fillText(lastnameforaddress, LastName);
	}

	public void fillCompanyName(String CompanyName) {
		fillText(company, CompanyName);
	}

	public void fillCompanyAddress1line(String CompanyAddress1line) {
		fillText(address1Line, CompanyAddress1line);
	}

	public void fillCompanyAddress2line(String CompanyAddress2line) {
		fillText(address2Line, CompanyAddress2line);
	}

	public void fillCity(String City) {
		fillText(city, City);
	}

	public void chooseState(String State) {
		selectByVisableText(state, State);
	}

	public void fillPostCode(String PostCode) {
		fillText(postcode, PostCode);
	}

	public void chooseCountry(String Country) {
		selectByVisableText(country, Country);
	}

	public void fillAdditionalInfo(String AdditionalInfo) {
		fillText(addInfo, AdditionalInfo);
	}

	public void fillHomePhone(String HomePhone) {
		fillText(homePhone, HomePhone);
	}

	public void fillMobilePhone(String MobilePhone) {
		fillText(mobilePhone, MobilePhone);
	}

	public void fillAliasAddress(String AliasAddress) {
		fillText(aliasAddress, AliasAddress);
	}

	public void registrBtn() {
		waitForElement(submitAccountBtn, 3000);
		click(submitAccountBtn);
	}
}

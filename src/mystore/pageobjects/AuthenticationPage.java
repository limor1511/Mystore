package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AuthenticationPage extends ApplicationPage{

	@FindBy(css="#email_create")
	private WebElement emailCreate;
	@FindBy(css="#SubmitCreate")
	private WebElement createAnAccountBtn;

	@FindBy(css="#email")
	private WebElement emailAddress;
	@FindBy(css="#passwd")
	private WebElement passwordField;
	@FindBy(css="#SubmitLogin")
	private WebElement signInBtn;

	@FindBy(css=".lost_password.form-group >a")
	private WebElement forGetPswdLink;

	@FindBy(css=".account")
	private WebElement myAccount;



	public AuthenticationPage(WebDriver driver) {
		super(driver);
	}

	public void createAnAccount(String email) {
		fillText(emailCreate, email);
		click(createAnAccountBtn);
	}

	public void alreadyRegistered(String email , String password ) {
		fillText(emailAddress, email);
		fillText(passwordField, password);
		click(signInBtn);
	}

	public void forGetYourPswd() {
		click(forGetPswdLink);
	}

	public void checksignInAccount() {
		myAccount.getText();

	}	
}


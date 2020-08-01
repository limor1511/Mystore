package mystore.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart2SignInPage extends ApplicationPage {

	@FindBy(css= ".standard-checkout")
	private WebElement  ProceedToCheckout  ;
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

	public ShoppingCart2SignInPage(WebDriver driver) {
		super(driver);
	}

	public void ProceedToCheckout() {
		click(ProceedToCheckout);
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

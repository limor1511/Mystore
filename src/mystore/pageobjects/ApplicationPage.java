package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationPage extends BasePage {

	@FindBy(css="a.login")
	private WebElement SignInLink;
	@FindBy(css="a.logout")
	private WebElement SignOutLink;
	@FindBy(css="#contact-link")
	private WebElement contactUs;
	@FindBy(css="#search_query_top")
	private WebElement searchFiled;
	@FindBy(css=".button-search")
	private WebElement searchBtn;
	@FindBy(css="span .ajax_cart_quantity")
	private WebElement cartNumber;
	@FindBy(css =".alert.alert-success")
	private WebElement successMsg;
	@FindBy(css =".alert.alert-danger")
	private WebElement errMsg;
	@FindBy(css =".header_user_info")
	private WebElement signinheader;

	public ApplicationPage(WebDriver driver) {
		super(driver);
	}

	public void signInBtn() {
		click(SignInLink);
	}

	public void signOutBtn() {
		click(SignOutLink);
	}

	public void contactUs() {
		click(contactUs);
	}

	public void searchProduct(String SearchFiled) {
		fillText(searchFiled, SearchFiled);
		click(searchBtn);
	}

	public String checkIfSignIn() {	
		return signinheader.getText();
	}

	public void back() {
		driver.navigate().back();
	}

	public void numberOfProductsAtCart() {
		System.out.println(cartNumber.getText());
	}

	public String getSuccessMsg() {
		return successMsg.getText();
	}

	public String GetErrMsg() {
		return errMsg.getText();
	}
}

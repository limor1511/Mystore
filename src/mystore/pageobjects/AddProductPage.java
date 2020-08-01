package mystore.pageobjects;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductPage extends ApplicationPage {

	@FindBy(css= ".continue.exclusive-medium")
	private WebElement continueShoppingBtn; 
	@FindBy(css= ".button.button-medium")
	private WebElement checkoutBtn; 
	@FindBy(css = "[title='Close window']")
	private WebElement closewindowsBtn;


	public AddProductPage(WebDriver driver) {
		super(driver);
	}

	public void continueShopping() {
		click(continueShoppingBtn);
	}

	public void proceedToCheckoutBtn() {
		waitForElement(checkoutBtn, 5);
		click(checkoutBtn);
	}

	public void closewindows() {
		click(closewindowsBtn);
	}
}

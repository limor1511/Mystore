package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart3AddressPage extends ApplicationPage {

	@FindBy(css= "[type='submit'].button-medium")
	private WebElement  ProceedToCheckout  ;

	public ShoppingCart3AddressPage(WebDriver driver) {
		super(driver);
	}

	public void proceedToCheckout() {
		click(ProceedToCheckout);
	}
}

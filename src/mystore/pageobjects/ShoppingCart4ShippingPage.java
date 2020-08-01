package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart4ShippingPage extends ApplicationPage {

	@FindBy(css= ".standard-checkout")
	private WebElement  ProceedToCheckout  ;
	@FindBy(css= "#uniform-cgv")
	private WebElement  AgreeCB  ;

	public ShoppingCart4ShippingPage(WebDriver driver) {
		super(driver);
	}

	public void proceedToCheckout() {
		click(ProceedToCheckout);
	}

	public void AgreeCB() {
		click(AgreeCB);
	}
}

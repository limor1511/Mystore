package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart1SummaryPage extends ApplicationPage {

	@FindBy(css= ".standard-checkout")
	private WebElement  ProceedToCheckout  ;

	public ShoppingCart1SummaryPage(WebDriver driver) {
		super(driver);
	}

	public void proceedToCheckout() {
		click(ProceedToCheckout);
	}
}

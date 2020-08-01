package mystore.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart1SummaryPage extends ApplicationPage {

	@FindBy(css= ".standard-checkout")
	private WebElement  ProceedToCheckout  ;

	public ShoppingCart1SummaryPage(WebDriver driver) {
		super(driver);
	}

	public void ProceedToCheckout() {
		click(ProceedToCheckout);
	}

}

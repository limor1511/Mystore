package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends ApplicationPage{

	@FindBy(css ="#add_to_cart")
	private WebElement addToCartBtn;
	@FindBy(css ="#color_15")
	private WebElement chooseColorGreen;
	@FindBy(css ="#group_1")
	private WebElement selectSize ;

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public void addProductToCart() {
		click(addToCartBtn);
	}

	public void chooseColorGreen() {
		click(chooseColorGreen);
	}

	public void selectSize(String title) {
		selectByVisableText(selectSize, title);
	}
}

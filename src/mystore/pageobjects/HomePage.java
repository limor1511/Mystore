package mystore.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ApplicationPage {

	@FindBy(css="#newtask_submit")
	private WebElement btnSubmit;
	@FindBy(css="span .ajax_cart_quantity")
	private WebElement totalLabel;
	@FindBy(css="#homefeatured a.product-name ")
	private List<WebElement> popularListName;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void choosePopularProduct(String productname) {
		for (WebElement el : popularListName) {
			if (getText(el).equalsIgnoreCase(productname)) {
				click(el);
				break;
			}
		}
	}

	public int getNumOfProduct() {
		String s =getText(totalLabel);
		System.out.println("s="+ s);
		int result = Integer.parseInt(s);	
		return result;
	}
}

package mystore.pageobjects;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SearchProductPage extends ApplicationPage {

	@FindBy(css="div .product-container .product-name")
	private List<WebElement> productList ;
	@FindBy(css=".ajax_add_to_cart_button")
	private WebElement cartbtn ;
	@FindBy(css="a.quick-view")
	private List<WebElement> quickViewList ;



	public SearchProductPage(WebDriver driver) {
		super(driver);
	}

	public void showList() {
		for (WebElement el : productList) {
			System.out.println(el.getText());
		}
	}

	public void  chooseProduct( String productName) {
		for (WebElement el : productList) {
			if (el.getAttribute("title").toLowerCase().contains(productName.toLowerCase()))  {
				sleepSec(1000);
				click(el);
				break;
			}
		}
	}

	public void addTocart (String productName) {
		for (WebElement el : productList) {
			if (el.getAttribute("title").toLowerCase().contains(productName.toLowerCase()))  {
				sleepSec(1000);
				click(cartbtn);
				break;
			}
		}
	}


	public void quickView (String productName) {
		for (WebElement el : quickViewList) {
			if (el.getAttribute("title").toLowerCase().contains(productName.toLowerCase()))  {
				sleepSec(500);
				click(el);
				break;
			}
		}
	}

}



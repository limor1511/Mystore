package mystore.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart5PaymentPage extends ApplicationPage {

	@FindBy(css= ".bankwire")
	private WebElement  PayByBankWire  ;
	@FindBy(css= ".cheque")
	private WebElement  PayByBankcheck  ;
		@FindBy(css= ".button-medium[type='submit']")
	private WebElement  ConfirmMyOrder  ;
	@FindBy(css= ".cheque-indent")
	private WebElement  ConfirmationMsgbyWire  ;
	@FindBy(css= ".alert-success")   //#order-confirmation
	private WebElement  ConfirmationMsgbycheck  ;
	
	
	public ShoppingCart5PaymentPage(WebDriver driver) {
		super(driver);
	}

	public void PayByBankWire() {
		click(PayByBankWire);
	}
	
	public void PayByBankcheck() {
		click(PayByBankcheck);
	}
	
	
	public void ConfirmMyOrder() {
		click(ConfirmMyOrder);
	}

	public String ConfirmationMsg() {
		return	getText(ConfirmationMsgbyWire);
	}

	public String ConfirmationMsgbycheck() {
		return	getText(ConfirmationMsgbycheck);
	}

}

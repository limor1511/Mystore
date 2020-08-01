package mystore.pageobjects;

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
	@FindBy(css= ".alert-success")   
	private WebElement  ConfirmationMsgbycheck  ;

	public ShoppingCart5PaymentPage(WebDriver driver) {
		super(driver);
	}

	public void payByBankWire() {
		click(PayByBankWire);
	}

	public void payByBankCheck() {
		click(PayByBankcheck);
	}

	public void confirmMyOrder() {
		click(ConfirmMyOrder);
	}

	public String confirmationMsg() {
		return	getText(ConfirmationMsgbyWire);
	}

	public String confirmationMsgByCheck() {
		return	getText(ConfirmationMsgbycheck);
	}
}

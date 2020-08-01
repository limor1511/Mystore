package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends ApplicationPage {

	@FindBy(css=".info-account")
	private WebElement MsgMyAccout;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String myAccountMsgPage() {	
		return MsgMyAccout.getText();
	}
 }

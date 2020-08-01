package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ForGetPswdPage extends ApplicationPage{

	@FindBy(css="#email")
	private WebElement emailAddress;
	@FindBy(css=" .submit .icon-chevron-right.right")
	private WebElement retrievePasswordBtn;


	public ForGetPswdPage(WebDriver driver) {
		super(driver);
	}

	public void fillForGetPswdDetails(String email) {
		fillText(emailAddress, email);
		click(retrievePasswordBtn);
	}


}


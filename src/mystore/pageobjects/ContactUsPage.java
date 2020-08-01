package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends ApplicationPage {

	@FindBy(css ="#id_contact")
	private WebElement SubjectHeading;
	@FindBy(css = ".selector")
	private WebElement SubjectHeadingArrow;
	@FindBy(css ="#email")
	private WebElement emailaddress;
	@FindBy(css ="#id_order")
	private WebElement orderreferance;
	@FindBy(css ="#uniform-fileUpload")  
	private WebElement uploadfile;
	@FindBy(css ="#message")
	private WebElement message;
	@FindBy(css ="#submitMessage")
	private WebElement submitMessage;

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	public void selectSubHeading(String subjectHeading) {
		selectByValue(SubjectHeading, subjectHeading);
	}

	public void openSelectOption() {
		click(SubjectHeadingArrow);		
	}

	public void fillEmailAddress(String Email) {
		fillText(emailaddress, Email);
	}

	public void fillOrderRef(String Orderreferance) {
		fillText(orderreferance, Orderreferance);
	}

	public void fillMessage(String Message) {
		fillText(message, Message);
	}

	public void sendMessage() {
		click(submitMessage);		
	}
}

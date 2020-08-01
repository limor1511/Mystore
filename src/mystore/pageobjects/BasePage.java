package mystore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage  {
	WebDriver driver;

	//Contractor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Elements

	protected void highlightElement(WebElement el, String color) {
		//keep the old style to change it back
		String originalStyle = el.getAttribute("style");
		String newStyle = "border: 2px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Change the style-highlight 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				el);
		// Change the style back after few miliseconds-unhighlight
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", el);
	}


	public void fillText(WebElement el,String text) {
		waitForElement(el, 5);
		highlightElement(el, "red");
		el.clear();
		el.sendKeys(text);
	}

	public void click(WebElement el) {
		highlightElement(el, "red");
		el.click();
	}

	public String getText(WebElement el) {
		waitForElement(el, 5);
		return el.getText();
	}

	public void selectByValue(WebElement el,String value) {
		Select select= new Select(el);
		select.selectByValue(value);
		}

	public void selectByVisableText(WebElement el,String text) {
		Select select= new Select(el);
		select.selectByVisibleText(text);
		highlightElement(el, "red");
	}

	public void print(WebElement el) {
		System.out.println(el.getText());
	}

	public void chooseList(WebElement el) {
		waitForElement(el, 5);
	}

	public void alertOK(String text) {
		//insert name to alert
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}

	public void sleepSec(long seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void waitForElement(WebElement el ,long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds); 
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}
	
	public void sleepMili(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
		}
	//	public void chooseFileToUpload(WebElement el,String text) {
	//	waitForElement(el, 5);
	//		highlightElement(el);
	//		el.clear();
	//		el.sendKeys(text);
	//	}




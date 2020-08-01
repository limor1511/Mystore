package mystore.pageobjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage  {
	WebDriver driver;

	BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	void fillText(WebElement el,String text) {
		waitForElement(el, 5);
		highlightElement(el, "red");
		el.clear();
		el.sendKeys(text);
	}

	void click(WebElement el) {
		highlightElement(el, "red");
		el.click();
	}

	String getText(WebElement el) {
		waitForElement(el, 5);
		return el.getText();
	}

	void selectByValue(WebElement el,String value) {
		Select select= new Select(el);
		select.selectByValue(value);
	}

	void selectByVisableText(WebElement el,String text) {
		Select select= new Select(el);
		select.selectByVisibleText(text);
		highlightElement(el, "red");
	}

	void print(WebElement el) {
		System.out.println(el.getText());
	}

	void chooseList(WebElement el) {
		waitForElement(el, 5);
	}

	void alertOK(String text) {
		//insert text to alert
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}
	

	// 3 wait options
	void sleepSec(long seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	void waitForElement(WebElement el ,long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds); 
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	void sleepMili(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void highlightElement(WebElement el, String color) {
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
}





package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlight {

	public WebDriver driver;

	public SelectFlight(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(css = "#air-booking-product-2")
	@CacheLookup
	private WebElement continueButton;

	@FindBy(xpath = "//*[contains(text(),'Sorry, we found some errors...')]")
	@CacheLookup
	private WebElement errorMessage;

	public WebElement abc() {
		return continueButton;
	}

	public WebElement def() {
		return errorMessage;
	}

}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By login = By.xpath("//*[contains(@class,'login')]");
	By username = By.cssSelector("#username");
	By password = By.cssSelector("#password");
	By submit = By.cssSelector("[value='Log in']");

	By depart = By.cssSelector("#air-city-departure");
	By arrive = By.cssSelector("#air-city-arrival");
	By searchButton = By.cssSelector("#jb-booking-form-submit-button");

	public WebElement abc() {
		return driver.findElement(login);
	}

	public WebElement def() {
		return driver.findElement(username);
	}

	public WebElement ghi() {
		return driver.findElement(password);
	}

	public WebElement jkl() {
		return driver.findElement(submit);
	}

	public WebElement depart() {
		return driver.findElement(depart);
	}

	public WebElement arrive() {
		return driver.findElement(arrive);
	}

	public WebElement search() {
		return driver.findElement(searchButton);
	}

}

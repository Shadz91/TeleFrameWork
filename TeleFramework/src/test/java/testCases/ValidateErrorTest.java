package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import org.apache.logging.log4j.*;
import pageObjects.SelectFlight;
import resources.Base;

public class ValidateErrorTest extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test
	public void x() throws Exception {

		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		log.info("Page is Loaded successfully");

		HomePage homePage = new HomePage(driver);
		homePage.depart().sendKeys("DAL");
		homePage.arrive().sendKeys("HOU");
		homePage.search().click();
		log.debug("Clicking on the Search button");

		SelectFlight selectFlight = new SelectFlight(driver);
		selectFlight.abc().click();
		log.debug("Clicking on the Continue button");

	}

}

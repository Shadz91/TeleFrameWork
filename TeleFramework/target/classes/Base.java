package resources;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeBrowser() throws Exception {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\M1036018\\oxygen-workspace\\TeleFramework\\src\\main\\java\\resources\\data.properties");

		prop = new Properties();
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browserName.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public void getScreenshot(String result) throws Exception {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//" + result + "screenshot.png"));

	}

	public Object[][] pullData(String sheetName) throws Exception {

		Object[][] data = null;
		FileInputStream fis = new FileInputStream("C:\\Users\\M1036018\\Documents\\Selenium_Udemy\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int count = workbook.getNumberOfSheets();

		for (int i = 0; i < count; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				int r = sheet.getLastRowNum();
				r++;

				int c = sheet.getRow(0).getLastCellNum();

				data = new Object[r][c];

				for (int x = 0; x < r; x++) {// 5
					for (int y = 0; y < c; y++) {// 2
						data[x][y] = sheet.getRow(x).getCell(y).getStringCellValue();
					}
				}
			}
		}

		return data;
	}

}

package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;

public class ReadData extends Base {

	@Test(dataProvider = "getData")
	public void pass(String username, String password) throws Exception {
		System.out.print(username + " " + password);
		System.out.println();
	}

	@DataProvider
	public Object[][] getData() throws Exception {
		Object[][] data = pullData("Sheet1");
		return data;
	}

}
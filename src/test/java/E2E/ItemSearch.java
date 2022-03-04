package E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;

import pageLocators.HomePage;
import pageLocators.PDPPage;

public class ItemSearch extends Base {
	
	public WebDriver driver;
	
	@BeforeTest(groups= {"Smoke"})
	public void intialize() throws IOException
	{
		driver = intializeDriver();
		driver.get(URL());
	}
	
	@Test(groups= {"Smoke"})
	public void SearchWithItemNumber()
	{
		HomePage hp = new HomePage(driver);
		hp.getSearch().sendKeys("A469130");
		hp.getSearchBtn().click();
		PDPPage pdp = new PDPPage(driver);
		String number = pdp.getItemNo().getText();
		Assert.assertEquals(number,"A469130");
	}
	
	@AfterTest(groups= {"Smoke"})
	public void teardown() 
	{
		driver.close();
	}

}

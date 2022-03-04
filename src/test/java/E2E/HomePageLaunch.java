package E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Resources.Base;

public class HomePageLaunch extends Base {
	
	public WebDriver driver;
	
	@Test(groups= {"Smoke"})
	public void LaunchQvc() throws IOException
	{
		driver = intializeDriver();
		driver.get(URL());
	}
	
	@AfterTest(groups= {"Smoke"})
	public void teardown() 
	{
		driver.close();
	}
	

}

package E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageLocators.ForgotPasswordPage;
import pageLocators.HomePage;
import pageLocators.MAALoginPage;
import pageLocators.MyAccount;

public class LoginFunction extends Base {
	
	public WebDriver driver;
	HomePage hp;
	MyAccount ma;
	MAALoginPage mlp;
	
	@BeforeTest(groups= {"Smoke"})
	public void intialize() throws IOException
	{
		driver = intializeDriver();
		
	}
	
	@Test(dataProvider="getUserData")
	public void Login(String username, String password) throws IOException
	{
		driver.get(URL());
		hp = new HomePage(driver);
		ma = new MyAccount(driver);
		mlp = new MAALoginPage(driver);
		hp.myAccount().click();
		overlay();
		ma.OrderStatus().click();
		mlp.getEmail().sendKeys(username);
		mlp.getContinue().click();
		mlp.getPassword().sendKeys(password);
		mlp.getSignIn().click();
		String name = hp.getgreetName().getText();	
		if(!name.equalsIgnoreCase("Guest"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider
	public Object[][] getUserData()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "Krishnan.saan@gmail.com";
		data[0][1]="mesut#11";
		data[1][0]="dhivya@gmail.com";
		data[1][1]="Dhivya10$";
		return data;
	}
	
	@Test(groups= {"Smoke"})
	
public void forgotpassword() throws IOException
{
		driver.get(URL());
		hp = new HomePage(driver);
		ma = new MyAccount(driver);
		mlp = new MAALoginPage(driver);
		hp.myAccount().click();
		overlay();
		ma.OrderStatus().click();
		mlp.getEmail().sendKeys("Krishnan.saan@gmail.com");
		mlp.getContinue().click();
		ForgotPasswordPage fpp = mlp.getforgotPassword();
		fpp.entersecurityAns().sendKeys("19380");
		fpp.submitAnswer().click();
		
}
	
	@AfterTest(groups= {"Smoke"})
	public void teardown() 
	{
		driver.close();
	}
	

}

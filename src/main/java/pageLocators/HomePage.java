package pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	private By myAccount = By.cssSelector("div[class*='acctGreeting']:nth-child(1)");
	private By greetName = By.xpath("(//p[@class='signInGreet'] //strong[@class='greetingLong'])[1]");
	private By search = By.id("txtMastheadSearch");
	private By searchBtn = By.id("btnMastheadSearch");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement myAccount()
	{
		System.out.println("Test");
		return driver.findElement(myAccount);
		
	}
	public WebElement getgreetName()
	{
		return driver.findElement(greetName);
	}
	public WebElement getSearch()
	{
		return driver.findElement(search);
	}
	public WebElement getSearchBtn()
	{
		return driver.findElement(searchBtn);
	}
}

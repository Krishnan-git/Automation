package pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MAALoginPage {
	
	public WebDriver driver;
	
	public MAALoginPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	By email = By.cssSelector("input[name='email']");
	By Continue = By.cssSelector("button[class*='btnContinue']");
	By password = By.cssSelector("input[name='pw']");
	By SignIn = By.cssSelector("button[class*='btnContinue']");
	By forgotPassword = By.linkText("Reset or Create Your Password");
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getContinue()
	{
		return driver.findElement(Continue);		
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);		
	}
	public WebElement getSignIn()
	{
		return driver.findElement(SignIn);		
	}
	public ForgotPasswordPage getforgotPassword()
	{
		driver.findElement(forgotPassword).click();
		ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
		return fpp;
		
	}
 
}

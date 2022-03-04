package pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
	public WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By securityAns = By.cssSelector("input[name='securityQnAnswer']");
	By submit = By.xpath("//button[contains(text(),'Submit')]");
	
	public WebElement entersecurityAns()
	{
		return driver.findElement(securityAns);
	}
	public WebElement submitAnswer()
	{
		return driver.findElement(submit);
	}
	

}

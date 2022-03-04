package pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount {
	
	public WebDriver driver;
	
	public MyAccount(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	By OrderStatus = By.linkText("Order Status");
	
	public WebElement OrderStatus()
	{
		return driver.findElement(OrderStatus);
	}
	

}

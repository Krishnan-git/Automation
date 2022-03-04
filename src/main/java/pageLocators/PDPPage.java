package pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PDPPage {
	
	public WebDriver driver;
	
	public PDPPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By itemNo = By.cssSelector("div[class='itemNo']");
	
	public WebElement getItemNo()
	{
		return driver.findElement(itemNo);
	}

}

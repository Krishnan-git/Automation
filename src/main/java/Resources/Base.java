package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	FileInputStream fis;
	Properties prop;
	
	public WebDriver intializeDriver() throws IOException {
		prop = new Properties();
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Data.properties");
		prop.load(fis);
		//mvn test -Dbrowser=chrome
		//String browserName=System.getProperty("browser");
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
			ChromeOptions cp = new ChromeOptions();
			if(browserName.contains("headless"))
			{
			cp.addArguments("headless");
			}
			driver = new ChromeDriver(cp);
			driver.manage().window().maximize();
		}else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
			
	}
	
	public String URL() throws IOException
	{
		prop.load(fis);
		return prop.getProperty("URL");
	}
	
	
	
	public void overlay()
	{
		if(driver.findElement(By.className("fancybox-skin")).isDisplayed())
		{
			driver.findElement(By.className("fancybox-close")).click();
		}
	}
	
	public String captureScreenshot(String TestcaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Src =  ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+TestcaseName+".png";
		FileUtils.copyFile(Src,new File(destinationFile));
		return destinationFile;
		
	}
	
	
	

}


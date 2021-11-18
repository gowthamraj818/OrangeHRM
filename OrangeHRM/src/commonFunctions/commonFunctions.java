package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class commonFunctions {

	public static WebDriver driver = null;
	public static Properties properties = null;
	Logger logger = Logger.getLogger(commonFunctions.class);

	public Properties loadPropertyFile() throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(fileInputStream);

		return properties;
	}

	@BeforeSuite
	public void launchBrowser() throws IOException
	{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("loading the property file");
		loadPropertyFile();
		
		logger.info("Browser start");
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String driverlocation = properties.getProperty("DriverLocation");

		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",driverlocation);
			//logger.info("Lanching chrome");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",driverlocation);
			//logger.info("Lanching Firefox");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		//logger.info("Open the Application");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void browserClose()
	{
		driver.quit();
		logger.info("All process done and driver as close");
	}
}

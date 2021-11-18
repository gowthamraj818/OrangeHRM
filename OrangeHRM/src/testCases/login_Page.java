package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunctions.commonFunctions;
import pageObjects.loginpage_Page_Objects;

public class login_Page extends commonFunctions {
	static Logger logger = Logger.getLogger("login_Page");

	@Test
	public void loginpageverify()
	{
		PageFactory.initElements(driver,loginpage_Page_Objects.class);
		logger.info("login page");
		loginpage_Page_Objects.uname.sendKeys(properties.getProperty("username"));
		loginpage_Page_Objects.pword.sendKeys(properties.getProperty("password"));
		loginpage_Page_Objects.btnlogin.click();

	}	
}
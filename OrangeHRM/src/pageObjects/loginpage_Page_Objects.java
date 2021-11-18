package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage_Page_Objects {


	@FindBy(xpath = "//input[@id='txtUsername']")
	public static WebElement  uname;
	
	@FindBy(xpath = "//input[@id='txtPassword']")
	public static WebElement pword;
	
	@FindBy(xpath = "//input[@id='btnLogin']")
	public static WebElement btnlogin;
}

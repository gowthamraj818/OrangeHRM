package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_Role_Page_Objects {

	@FindBy(xpath = "//*[@id='menu_admin_viewAdminModule']")
	public static WebElement adminlink;
	
	@FindBy(xpath = "//*[@id='menu_admin_UserManagement']")
	public static WebElement usermanagementlink;
	
	@FindBy(xpath = "//*[@id='menu_admin_viewSystemUsers']")
	public static WebElement userlink;
	
	@FindBy(id = "searchSystemUser_userType")
	public static WebElement userRole;
	
	@FindBy(id = "searchSystemUser_status")
	public static WebElement userstatus;
	
	@FindBy(id = "searchBtn")
	public static WebElement searchbtn;

	@FindBy(xpath = "//tr/td[3]")
	public static WebElement userrolevalue;
	
	@FindBy(xpath = "//tr/td[5]")
	public static WebElement userstatusvalue;
	
}

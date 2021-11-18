package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.commonFunctions;
import pageObjects.User_Role_Page_Objects;

public class Test_User_Role extends commonFunctions {
	static Logger logger = Logger.getLogger("Test_User_Role");

	public void movertouserpage()
	{
		logger.info("open user page");
		Actions actions = new Actions(driver);
		actions.moveToElement(User_Role_Page_Objects.adminlink);
		actions.moveToElement(User_Role_Page_Objects.usermanagementlink);
		actions.moveToElement(User_Role_Page_Objects.userlink);
		actions.click().build().perform();
	}
	
	public void selectuserrole(){
		logger.info("select userRole and userStatus");
		Select selectRole = new Select(User_Role_Page_Objects.userRole);
		selectRole.selectByIndex(1);
	}
	public void selectStatus() {
		Select selectStatus = new Select(User_Role_Page_Objects.userstatus);
		selectStatus.selectByIndex(1);
	}

	@Test
	public void  checkUserRole() {
		PageFactory.initElements(driver,User_Role_Page_Objects.class);
		logger.info("To check userRole and status values");
		movertouserpage();
		selectuserrole();
		selectStatus();
		User_Role_Page_Objects.searchbtn.click();
		
		String role = User_Role_Page_Objects.userrolevalue.getText();
		String status = User_Role_Page_Objects.userstatusvalue.getText();
		
		Assert.assertEquals(role, "Admin");
		Assert.assertEquals(status, "Enabled");
		
	}
}

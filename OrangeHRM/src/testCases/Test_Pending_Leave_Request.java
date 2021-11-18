package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.commonFunctions;
import pageObjects.Dashboard_Page_Objects;

public class Test_Pending_Leave_Request extends commonFunctions {

	static Logger logger = Logger.getLogger("Test_Pending_Leave_Request");

	@Test
	public void  checkLeaveRequest()
	{
		PageFactory.initElements(driver,Dashboard_Page_Objects.class);

		logger.info("Leave_Request");
		String actualmessage =  Dashboard_Page_Objects.request.getText();
		//System.out.println(actualmessage);

		Assert.assertEquals(actualmessage, "No Records are Available");

	}

}

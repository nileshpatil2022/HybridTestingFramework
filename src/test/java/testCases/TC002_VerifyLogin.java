package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_VerifyLogin extends BaseClass
{
	@Test(groups= {"Sanity", "Master"})
	public void Verify_Login()
	{
		try {
		logger.info("******Starting TC002_VerifyLogin*******");
		HomePage hm=new HomePage(driver);
		hm.clickMyAccount();
		hm.clickOnLoginLink();
		
		logger.info("User is on Login Page");
		
		LoginPage lp=new LoginPage(driver);
		lp.sendEmailId(p.getProperty("email"));
		lp.sendPasswordId(p.getProperty("password"));
		lp.clickLoginBtn();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetText=map.isMyAccountExist();
		
		Assert.assertEquals(targetText, true, "login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
			
			logger.debug("Test case is failed");
		}
				
		
		
		logger.info("******Finished TC002_VerifyLogin*******");
	}

}

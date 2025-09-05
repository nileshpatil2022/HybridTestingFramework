package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass
{
	//public WebDriver driver;
	
	
	
	@Test(groups= {"Regression", "Master"})
	public void verify_Account_Registration()
	{
		logger.info("*****Starting TC001_AccountRegistrationTest***********");
		
		try {
		HomePage hm=new HomePage(driver);
		hm.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		hm.clickRegister();
		logger.info("Clicked on Register link");

		AccountRegistrationPage page=new AccountRegistrationPage(driver);
		
		logger.info("Providing User details..............");
		
		page.setFirstName(randomString().toUpperCase());
		page.setLastName(randomString().toUpperCase());
		page.setEmail(randomString() + "@gmail.com");
		page.setTelephone(randomNumber());
		
		String password=randomAlphaNumber();
		
		page.setPassword(password);
		page.setConfirmPassword(password);
		page.clickCheckBox();
		page.clickContinueBtn();
		
		logger.info("Validating expected message");
		
	  String getConfirmMsg=	page.getConfirmMessage();
	  if(getConfirmMsg.equals("Your Account Has Been Created!"))
	  {
		Assert.assertTrue(true);
	  }
	  else
	  {
		  logger.error("Test failed");
		  logger.debug("Debug logs..........");
		  Assert.assertTrue(false);
	  }
	  
	  //Assert.assertEquals(getConfirmMsg, "Your Account Has Been Created!!!");
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("*****Finished TC001_AccountRegistrationTest ***********");
	}
	
	
}


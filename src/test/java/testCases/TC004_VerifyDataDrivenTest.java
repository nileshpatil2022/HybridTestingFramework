package testCases;


import org.testng.Assert;

/*Valid data - login success - test pass - logout
 * valid data - login fail - test fail
 * 
 * invalid data- login success - test fail- logout
 * invalid data -login fail - test pass
 */

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC004_VerifyDataDrivenTest extends BaseClass
{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verifyDataDrivenTest(String email, String psw, String Exp)
	{
		logger.info("*****Starting TC004_VerifyDataDrivenTest******");
		
		try {
		HomePage hm=new HomePage(driver);
		hm.clickMyAccount();
		hm.clickOnLoginLink();
		
		LoginPage lp=new LoginPage(driver);
		lp.sendEmailId(email);
		lp.sendPasswordId(psw);
		lp.clickLoginBtn();
		
		
		MyAccountPage macp=new MyAccountPage(driver);
		boolean targetPage=macp.isMyAccountExist();
	
		
		/*Valid data - login success - test pass - logout
		 * valid data - login fail - test fail
		 * 
		 * invalid data- login success - test fail- logout
		 * invalid data -login fail - test pass
		 */
		
		if(Exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				macp.clickOnLogOutLink();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		
		if(Exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				macp.clickOnLogOutLink();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		
		
		logger.info("*****Finished TC004_VerifyDataDrivenTest******");
		
		
		
	}
	

}

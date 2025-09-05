package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement getMyAccount;
	
	@FindBy(xpath="//div[@class='list-group']/child::a[text()='Logout']")
	private WebElement logOutLink;
	
	
	
	public boolean isMyAccountExist()
	{
		try {
		return (getMyAccount.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickOnLogOutLink()
	{
		logOutLink.click();
		
	}

}

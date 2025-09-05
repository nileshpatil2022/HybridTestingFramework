package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement linkMyAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement linkRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginLink;
	
	
	public void clickMyAccount()
	{
		linkMyAccount.click();
	}
	
	public void clickRegister()
	{
		linkRegister.click();
		
	}
	
	public void clickOnLoginLink()
	{
		loginLink.click();
	}
	
	

}

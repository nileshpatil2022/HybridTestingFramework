package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailText;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordText;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginLink;
	
	
	public void sendEmailId(String email)
	{
		emailText.sendKeys(email);
	}
	

	public void sendPasswordId(String pwd)
	{
		passwordText.sendKeys(pwd);
	}
	
	public void clickLoginBtn()
	{
		loginLink.click();
	}
}

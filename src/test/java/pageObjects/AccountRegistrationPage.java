package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement checkPolicyCheckbox;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement clickContinueBtn;
	
	@FindBy(xpath="//div[@id='content']/child::h1")
	private WebElement getConfirmMessage;
	
	
	public void setFirstName(String firstName)
	{
		txtFirstName.sendKeys(firstName);
		
	}
	
	public void setLastName(String lastName)
	{
		txtLastName.sendKeys(lastName);
		
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmpassword)
	{
		txtConfirmPassword.sendKeys(confirmpassword);
		
	}
	
	public void clickCheckBox()
	{
		checkPolicyCheckbox.click();
	}
	
	
	public void clickContinueBtn()
	{
		clickContinueBtn.click();
	}
	
	public String getConfirmMessage()
	{
		try {
			return (getConfirmMessage.getText());
		}
	
	catch(Exception e)
		{
		return (e.getMessage());
		
		}
	}
	
	
	
	
	

}

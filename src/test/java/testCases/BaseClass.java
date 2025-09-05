package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger;     //log4j

public class BaseClass
{
	public Logger logger;  //log4j
	public static WebDriver driver;
	
	public Properties p;
	
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException
	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			
			//for OS
			if(os.equalsIgnoreCase("window"))
			{
				cap.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
				
			}
			else
			{
				System.out.println("No matching OS");
				return;
			}
			
			//for browser

            switch(br.toLowerCase())
            {
            case "chrome" : cap.setBrowserName("chrome"); break;
            case "edge"   : cap.setBrowserName("MicrosoftEdge"); break;
            default: System.out.println("No matching browser");return;
            
            }
            
            driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			
		}
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge"   : driver= new EdgeDriver(); break;
			case "firefox" : driver= new FirefoxDriver(); break;
			
			default: System.out.println("invalid browser name"); return;
			
			}
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		//driver.get("https://demo.opencart.com/");
		
		driver.manage().window().maximize();
		
		
	}

	@AfterClass(groups={"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		@SuppressWarnings("deprecation")
		String generateString=RandomStringUtils.randomAlphabetic(7);
		return generateString;
	}
	
	public String randomNumber()
	{
		@SuppressWarnings("deprecation")
		String generateNumber=RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}
	
	
	public String randomAlphaNumber()
	{
		@SuppressWarnings("deprecation")
		String generateAlphaNumber=RandomStringUtils.randomAlphabetic(5);
		@SuppressWarnings("deprecation")
		String generateNumber=RandomStringUtils.randomNumeric(5);
		return (generateAlphaNumber+"@"+generateNumber);
	}
	
	
	
	public String capturScreen1(String tName) throws IOException
	{
		SimpleDateFormat d1=new SimpleDateFormat("yyyyMMddhhmmss");
		Date d=new Date();
		String timestamp=d1.format(d);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath= System.getProperty("user.dir")+ "\\screenshots\\" + tName +"_" +timestamp + ".png";
		File destinationFile=new File(targetFilePath);
		FileHandler.copy(sourceFile, destinationFile);
		
		return targetFilePath;
		
	}
	
	
//	public String captureScreen(String tname) throws IOException {
//
//		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//				
//		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//		
//		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
//		File targetFile=new File(targetFilePath);
//		
//		//sourceFile.renameTo(targetFile);
//		FileHandler.copy(sourceFile, targetFile);
//			
//		return targetFilePath;
//
//	}
	
	
	
	
	

}

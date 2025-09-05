package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class ExtentReportManager2 implements ITestListener
{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	public void onStart(ITestContext context) 
	{
		SimpleDateFormat d1=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
		Date d=new Date();
		String timestamp= d1.format(d);
		repName="Test-Report-" + timestamp + ".html";
		
		sparkReporter =new ExtentSparkReporter(".\\reports\\"+repName);
		
		//sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/MyReport1.html");
		
		sparkReporter.config().setDocumentTitle("Opencart Automation report");
		sparkReporter.config().setReportName("Opencart Functional Test");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("sub module", "customer");
		extent.setSystemInfo("username", System.getProperty("user.name"));
		
		//extent.setSystemInfo("os", "windows10");
		//extent.setSystemInfo("browser name", "chrome");
		
		String os=context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating system", os);
		
		String browser=context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("browser", browser);
		
		List<String> includeGroup=context.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroup.isEmpty())
		{
			extent.setSystemInfo("Groups", includeGroup.toString());
		}

	}

	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() +" got successfully executed");
	   
	}
	
	
	public void onTestFailure(ITestResult result) 
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+" got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try 
		{
			String imgaePath=new BaseClass().capturScreen1(result.getName());
			test.addScreenCaptureFromPath(imgaePath);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	
	}

	  public void onTestSkipped(ITestResult result)
      {
		 test= extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.SKIP,result.getName()+  " got skipped");
		
	    
	  }
	  
	  public void onFinish(ITestContext context) 
	  {
		  extent.flush();
	  }
	
	
	
	

}

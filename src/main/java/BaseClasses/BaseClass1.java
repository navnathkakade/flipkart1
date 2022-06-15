package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	
	static ExtentHtmlReporter htmlReporter;
	
	static ExtentReports report;
	static ExtentTest test;
 public static WebDriver getwebdriver(String browser) {
	 WebDriver driver = null;
 if(browser.equals("chrome"))
 {
	 WebDriverManager.chromedriver().setup();
	//System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Browser\\chromedriver.exe");
	
	 driver = new ChromeDriver();
 }
 else if(browser.equals("firefox"))
 {
	 WebDriverManager.firefoxdriver().setup();
	// System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browser\\geckodriver.exe");
		driver =new FirefoxDriver();
	  
 }
 driver.get("https://www.flipkart.com/");
 driver.manage().window().maximize();
 
 return driver;
}

	public static ExtentTest getTestForReporter(String useCase)
	{
		
		return test = report.createTest(useCase);
	}
	
	public static ExtentHtmlReporter getHtmlReporter()
	{
		if(htmlReporter == null)
		{
			htmlReporter = new ExtentHtmlReporter("ExtentReporter.html");
			
		}
		
		return htmlReporter;
	}
	
	public static ExtentReports getExtentReport()
	{
		if(report == null)
		{
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
		}
		
		return report;
	}

}
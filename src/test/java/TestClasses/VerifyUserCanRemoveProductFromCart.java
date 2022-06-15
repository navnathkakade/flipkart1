package TestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClasses.BaseClass1;
import PomClasses.Cart_Page;
import PomClasses.Home_Page;
import PomClasses.Login_Page;
import PomClasses.ProductDetail_Page;

public class VerifyUserCanRemoveProductFromCart {
WebDriver driver;
		Login_Page lp;
		Home_Page hp;
		ProductDetail_Page pdp;
		Cart_Page cp;
		ExtentHtmlReporter htmlReporter;
		ExtentReports report;
		ExtentTest test;
	   
		@Parameters("browser")
		@BeforeClass
		public void beforeClass() {
			 htmlReporter = BaseClass1.getHtmlReporter();
			  report =BaseClass1.getExtentReport();
			   test= BaseClass1.getTestForReporter("VerifyUserCanRemoveProductFromCart");
				 driver=BaseClass1.getwebdriver("chrome");
			 
		}
		@BeforeMethod
		  public void beforeMethod() {
			   lp=new Login_Page(driver);
			   hp=new Home_Page(driver);
			   pdp =new ProductDetail_Page(driver);
			   cp =new Cart_Page(driver);
		}
		  @Test(priority=1)
		  public void VerifyUserCanLogin() throws InterruptedException, IOException {
			  lp. putemail();
			  lp.putpassword();
			  lp.putloginbutton();
			  SoftAssert soft= new SoftAssert();
			  soft.assertTrue(hp.isprofileNamevisible());
			  soft.assertAll();
			  
			  
		  }
		  @Test(priority=2)
		  public void VerifyUserCanSearchProduct() throws EncryptedDocumentException, IOException {
//		String data=hp.getDataFromExcelSheet("sheet1", 0, 0);
			  hp.entersearchfield();
			  hp.clicksearchbutton();
	         Assert.assertTrue(hp.isproductlistAppeared());
//		  hp.isproductlistAppeared();
		  }
		  @Test(priority=3)
		  public void VerifyUserCanSelectFirstProductGoToProductDetailPage() throws InterruptedException {
			  hp.clickonFirstProduct();

			  Assert.assertTrue(pdp.isProductNameIsvisible());
			  
			  pdp.ClickOnAddCardButton();
		  }
		  @Test(priority=4)
		  public void VerifyUserCanRemoveProduct() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(cp.isPlaceOrderButtonNamevisible());
			
			  cp.ClickOnRemoveButton1();
			  cp.ClickOnRemoveButton2();
		  }
		  
		  @AfterMethod
		  public void afterMethod(ITestResult result) throws IOException {
			  if(result.getStatus()==ITestResult.SUCCESS)
			  {
				  test.log(Status.PASS,result.getName() +"test pass");
			  }
			  else 
			  {
				  String path = hp.getScreenshot(driver, result.getName());
				  test.log(Status.FAIL,result.getName() +"test fail",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			  }
		  }
		  @AfterClass
		  public void afterClass() {
			  report.flush();
			  driver.quit();
		  }
	}

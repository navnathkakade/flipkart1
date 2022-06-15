package PomClasses;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilityclasses.UtilClass1;

public class Home_Page extends UtilClass1 {
	WebDriver driver;
	 @FindBy(xpath="//input[@type='text']")
	 private WebElement searchfeild;
	 @FindBy(xpath="//button[@type='submit']")
	 private WebElement  searchbutton;
	 @FindBy(xpath="//div[text()='Navnath']")
	 private WebElement profileName;
	 @FindBy(xpath="//div[@class='_2kHMtA']")
	 private WebElement productlist;
	 public Home_Page(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 this.driver=driver;
	 }
	 
	 public void entersearchfield() throws IOException
	 {
		 searchfeild.sendKeys(getDataFromPropertyFile("searchfeild"));
	 }
	 public void clicksearchbutton()
	 {
		 searchbutton.click();
	 }

	 
	 public boolean isprofileNamevisible()
	 {
		 try
		 {
			 WebElement element =explicitwait(driver,profileName);
			 return true;
		 }catch(Exception e)
		 {
			return false; 
		 }
	 }
	 public boolean isproductlistAppeared()
	 {
		 try
		 {
			 WebElement element =explicitwait(driver,productlist);
			 return true;
		 }catch(Exception e)
		 {
			return false; 
		 }
	 }

	public void clearsearchfield(String searchData) {

		for(int i=0;i<searchData.length();i++)
		{
			searchfeild.sendKeys(Keys.BACK_SPACE);
		}
	}
		public void clickonFirstProduct()
		{
			productlist.click();
		ArrayList<String> adresses = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(adresses.get(1));
		}
	}

	
		
		
	



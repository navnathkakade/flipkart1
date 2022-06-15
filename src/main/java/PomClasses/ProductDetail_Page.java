package PomClasses;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilityclasses.UtilClass1;

public class ProductDetail_Page extends UtilClass1 {
	

WebDriver driver;
@FindBy(xpath="//span[@class='B_NuCI']")
private WebElement ProductName;
@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
private WebElement AddCardButton;
public ProductDetail_Page(WebDriver driver)
{
	PageFactory.initElements(driver,this);
	this.driver=driver;
}

public boolean isProductNameIsvisible()
{
	 try
	 {
		 WebElement element =explicitwait(driver, ProductName);
		 return true;
	 }catch(Exception e)
	 {
		return false; 
	 }
}
	 public void ClickOnAddCardButton()
	 
	 {
		 	 AddCardButton.click();
	 }
		
	
		
}




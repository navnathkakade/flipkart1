package PomClasses;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilityclasses.UtilClass1;

public class Cart_Page extends UtilClass1 {

	WebDriver driver;
	@FindBy(xpath="//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	private WebElement PlaceOrderButton;
	//div[@class='_1P2-0f']
	@FindBy(xpath="//div[text()='Remove']")
	private WebElement RemoveButton1;
	@FindBy(xpath="//div[@class='_3dsJAO _24d-qY FhkMJZ']")
	private WebElement RemoveButton2;
	//div[text()='Remove']
	public Cart_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this. driver=driver;
	}
	 public boolean isPlaceOrderButtonNamevisible()
	 {
		 try
		 {
			 WebElement element =explicitwait(driver,PlaceOrderButton);
			 return true;
		 }catch(Exception e)
		 {
			return false; 
		 }
	 }
	 public void ClickOnPlaceOrderButton()
	 {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",PlaceOrderButton);
		 
	 }
public void ClickOnRemoveButton1()
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",RemoveButton1);
	

}
public void ClickOnRemoveButton2()
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",RemoveButton2);
//RemoveButton2.click();
}
}

	
 
	 

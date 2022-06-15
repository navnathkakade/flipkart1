package PomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilityclasses.UtilClass1;

public class Login_Page extends UtilClass1{
	WebDriver driver;
@FindBy(xpath="(//input[@type='text'])[2]")
private WebElement email;
@FindBy(xpath="//input[@type='password']")
private WebElement password;
@FindBy(xpath="(//button[@type='submit'])[2]")
private WebElement loginbutton;
public Login_Page(WebDriver driver)
{
	PageFactory.initElements(driver,this);
	this.driver=driver;
}

public void putemail() throws IOException 
{
	email.sendKeys(getDataFromPropertyFile("email"));

			
}
public void putpassword() throws IOException
{
password.sendKeys(getDataFromPropertyFile("password"));
	
	 
}
public void putloginbutton()
{
	 loginbutton.click();
	 
}
}

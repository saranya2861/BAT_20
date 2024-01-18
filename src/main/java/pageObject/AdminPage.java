package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	WebDriver ldriver;
	//WebElement txtEmail=driver.findElement(By.xpath("//input[@id='Email']")); //Java Project
	
	public AdminPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Maven Project
	@FindBy (xpath="//input[@id='Email']")
	WebElement txtEmail; //Here we storing webelement
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement btnLogin;
	
	//Create user defined methods to perform operation on above three webelements
	//UserNAme and Password we are passing it from feature file.
	
	public void setUserName(String uName) {
		txtEmail.clear();
		txtEmail.sendKeys(uName);
		
	}
	
	public void setPassWord(String pwd) {
		
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		
		btnLogin.click();
		
	}
	
}

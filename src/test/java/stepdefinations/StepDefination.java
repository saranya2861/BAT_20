package stepdefinations;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AdminPage;
import utilities.ReadConfig;

public class StepDefination extends Base {
	
	//@Before & @After are Hooks concepts in BDD Cucumber
	//@Before will execute before each scenario
	
	@Before
	public void setUp() throws Exception {
		
		System.out.println("Setup Method Execution");
		
		readConfig=new ReadConfig(); //Creating object of ReadConfig class
		String browser =readConfig.getBrowser(); //firefox
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if (browser.equalsIgnoreCase("firebox")) {
			driver= new FirefoxDriver();
			Thread.sleep(2000);
			driver.manage().window().maximize();
			Thread.sleep(2000);		
		}else if (browser.equalsIgnoreCase("IE")) {
			driver= new InternetExplorerDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}
	}
	

@Given("User Lanch Chrome Browser")
public void user_lanch_chrome_browser() {
	
	//driver = new ChromeDriver();
	ad = new AdminPage(driver); //Create Object of AdminPage java class
    
}

@When("User open url {string}")
public void user_open_url(String url) {
	
	driver.get(url);
    
}

@When("User enter Email as {string} and password as {string}")
public void user_enter_email_as_and_password_as(String email, String password) {
	
	ad.setUserName(email);
	ad.setPassWord(password);
    
}

@When("User click on Login button")
public void user_click_on_login_button() {
	
	ad.clickOnLogin();
   
}

@Then("User verify page title should be {string}")
public void user_verify_page_title_should_be(String title) {
	
	Assert.assertEquals(driver.getTitle(), title);
    
}

@Then("close browser")
public void close_browser() {
   
}

}

package stepdefinations;

import org.openqa.selenium.WebDriver;

import pageObject.AdminPage;
import utilities.ReadConfig;

public class Base {
	
	public WebDriver driver; //Declared webdriver
	public AdminPage ad; //Created refernece for AdminPage
	public ReadConfig readConfig;

}

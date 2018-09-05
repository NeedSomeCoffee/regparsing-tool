package edu.regparsing.registration;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import edu.regparsing.models.Account;
import edu.regparsing.models.pageobjects.BasePage;
import edu.regparsing.models.pageobjects.MainPage;
import edu.regparsing.models.pageobjects.RegistrationPage;

public class RegistrationService {
	private Logger logger = Logger.getLogger("WebRegistration");
	WebDriver driver = DriverProvider.getDriver();
	
	public void registerUser(Account account) {		
		BasePage startPage = new BasePage(driver);
		RegistrationPage registration = startPage.goToRegistrationPage();
		
		MainPage main = registration.registerAccount(account);
		
		main.skip();
	}
	
	public static void main(String[] args) {
		RegistrationService registrator = new RegistrationService();
		
		Account acc = new Account("ejgnsdifjgsddfgfgfjg", "qweertrt123dfgdfg342", "sfdhgdfgdfhfh@fg.gfh");
		
		registrator.registerUser(acc);
	}
}

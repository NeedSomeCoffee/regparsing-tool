package edu.regparsing.models.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import edu.regparsing.models.Account;

public class RegistrationPage {
	private WebDriver driver;
	@FindBy(id = "ap_customer_name")
	private WebElement nameField;
	@FindBy(id = "ap_email")
	private WebElement emailField;
	@FindBy(id = "ap_password")
	private WebElement passwordField;
	@FindBy(id = "ap_password_check")
	private WebElement passwordCheckField;
	@FindBy(id = "continue")
	private WebElement submitButton;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public MainPage registerAccount(Account account) {
		nameField.sendKeys(account.getLogin());
		
		emailField.sendKeys(account.getEmail());
		
		passwordField.sendKeys(account.getPassword());
		
		passwordCheckField.sendKeys(account.getPassword());
		
		submitButton.submit();
		
		return new MainPage(driver);
	}
}

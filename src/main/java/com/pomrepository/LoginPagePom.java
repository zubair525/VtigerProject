package com.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 
public class LoginPagePom {
	public LoginPagePom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement UN;
	
	@FindBy(name ="user_password")
	private WebElement PWD;
	
	@FindBy(id = "submitButton")
	private WebElement login;

	public WebElement getUsername() {
		return UN;
	}

	public WebElement getPassword() {
		return PWD;
	}

	public WebElement getLogin() {
		return login;
	}
	
	public void loginToApp(String username, String password) {
		UN.sendKeys(username);
		PWD.sendKeys(password);
		login.click();
	}
	
	
}

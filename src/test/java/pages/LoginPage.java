package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	@FindBy(className = "login")
	WebElement loginLink;

	@FindBy(className = "email")
	WebElement userName;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(id = "remember-me")
	WebElement rememberMe;

	@FindBy(name = "btn_login")
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void LoginFunction(String UserNameVal, String PwdVal) {

		loginLink.click();

		userName.sendKeys("abc@gmail");

		Password.sendKeys("123xyz@246");

		rememberMe.click();

		loginBtn.click();

	}

}

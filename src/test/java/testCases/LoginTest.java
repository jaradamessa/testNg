package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void LoginFailureTest() {
		LoginPage login = new LoginPage(GetDriver());
		login.LoginFunction("abc@gmail", "123xyz@246");

		WebElement errorMessage = GetDriver().findElement(By.id("error_box"));
		System.out.println(errorMessage.getText());

		String actMsg = errorMessage.getText();
		String expMsg = "Please enter a valid email address";
		Assert.assertEquals(actMsg, expMsg);
	}

	@Test
	public void LoginSuccessTest() {
		LoginPage login = new LoginPage(GetDriver());
		login.LoginFunction("real@abc.com", "realpwd@246");

	}

}

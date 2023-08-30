package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class LoginPage extends Base {

	public void user_enter_username_and_password(String uname,String pass ) {

		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("uname");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("pass");
	}

	public void clickonLoginButton() {

		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginBtn.click();

	}

	public boolean validate_successful_login() {
		return driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();

	}

}

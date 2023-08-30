package stepDefinations;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModel.LoginPage;

public class LoginSteps {
	LoginPage login=new LoginPage();



@When("user enter {string} and {string}")
	public void user_enter_and(String uname, String pass) {
		login.user_enter_username_and_password(uname,pass);
	}

@When("user click on login button")
public void user_click_on_login_button() {
   login.clickonLoginButton();
}

@Then("validate login page is successful")
public void validate_login_page_is_successful() {
   Assert.assertTrue(login.validate_successful_login());
   }
}



	
	






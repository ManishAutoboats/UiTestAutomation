Feature: login functionality

@Reg
Scenario: verify login functionality with valid credentials
When user enter "standard_user" and "secret_sauce"
And user click on login button
Then validate login page is successful

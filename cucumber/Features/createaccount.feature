Feature: create account
@AccountTest
Scenario: create an user account

Given create an user 
When click on createaccount button
When user enter firstname,lastname,mobile number,newpassword etc 
And click on signup button
Then account should be created

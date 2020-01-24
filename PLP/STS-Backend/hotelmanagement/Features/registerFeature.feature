Feature:  Testing the Register Feature


Scenario: Testing the Register Feature with Valid Data
Given the User has loaded the application in the browser
When the User click on register Button on Navbar
When the User enter the userName in the userName textbox
And the User enter the email in the email textbox
And the User enter the password in the password textbox
And the User enters the phoneNumber in the phoneNumber textbox
And User selects the gender in the radio
And the User selects the nationality in the role dropdown
And the User clicks on the register Button
Then the board pages must be loaded
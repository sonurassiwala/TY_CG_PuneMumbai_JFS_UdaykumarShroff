Feature:  Testing the User login Feature

Scenario: Testing the User login Feature with Valid Data
Given the User has loaded the application in the browser
When the User clicks on the login Button on navbar
When the User enters the email in the email textbox
And the User enters the  password in the password textbox
And the User clicks on the login Button
Then the dashboard pages must be loaded
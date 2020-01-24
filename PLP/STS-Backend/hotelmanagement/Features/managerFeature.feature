Feature:  Testing the Manager login Feature

Scenario: Testing the Manager login Feature with Valid Data
Given the Manager has loaded the application in the browser
When the Manager clicks on the login Button on navbar
When the Manager enters the email in the email textbox
And the Manager enters the  password in the password textbox
And the Manager clicks on the login Button
Then the dash pages must be loaded
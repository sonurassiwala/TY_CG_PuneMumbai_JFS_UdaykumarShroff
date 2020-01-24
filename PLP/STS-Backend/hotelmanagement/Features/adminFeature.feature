Feature:  Testing the Admin login Feature

Scenario: Testing the Admin login Feature with Valid Data
Given the Admin has loaded the application in the browser
When the Admin clicks on the login Button on navbar
When the Admin enters the email in the email textbox
And the Admin enters the  password in the password textbox
And the Admin clicks on the login Button
Then the again dashboard pages must be loaded

#And Admin Clicks on hotel
And Admin enters hotel name
And Admin enters location
And Admin enters image url
And Admin enters add hotel
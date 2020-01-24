Feature: Testing  the booking Features

Scenario: Testing the User login Feature with Valid Data
Given the User has loaded the application in the browser
When the User clicks on the login Button on navbar
When the User enters the email in the email textbox
And the User enters the password in the password textbox
And the User clicks on the login Button
And the User click on hotel-list
And the list of hotel appears
And the User click on hotel image 
And the hotel description opens
And the User click on hotel image 
And the room description appears 
And the user click on book button 
And the booking confirm page appears
And the User has to select check-in date
And the User has to select check-out date
And the User click on book button
And the payment page will display
And the User enter crad holders name
And the User enter the cvv
And the User select year
And the User select month
And the User click on confirm payment
Then booking confirm page display
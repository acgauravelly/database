@All
Feature:AF360status
IF I visit http://admin.flix360.com
I should see the webpage

@AF360status
Scenario:Http status

Given I Navigate to  "Adminflix360Portal"
Then I should be able to get the status of the "Adminflix360Portal"

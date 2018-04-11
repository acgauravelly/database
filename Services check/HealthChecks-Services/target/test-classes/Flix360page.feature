@All
Feature:Flix360

IF I visit http://www.flix360.com/
I should see the webpage

@360status
Scenario:Http status

Given I Navigate to  "Flix360URL"
Then I should be able to get the status of the "Flix360URL"

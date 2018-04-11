@All
Feature:Flixfacts

IF I visit http://flixfacts.co.uk
I should see the webpage

@FFstatus
Scenario:Http status

Given I Navigate to  "Flixfacts"
Then I should be able to get the status of the "Flixfacts"
